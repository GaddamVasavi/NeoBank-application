import React, { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import { User, AuthResponse } from '../types/auth';
import { authApi } from '../api/authApi';
import { userApi } from '../api/userApi';

interface AuthContextType {
  user: User | null;
  isAuthenticated: boolean;
  isLoading: boolean;
  login: (c: any) => Promise<AuthResponse>;
  register: (p: any) => Promise<AuthResponse>;
  verifyMfa: (token: string, code: string) => Promise<AuthResponse>;
  logout: () => Promise<void>;
  refreshUser: () => Promise<void>;
  hasRole: (r: string) => boolean;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
  const [user, setUser] = useState<User | null>(null);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  useEffect(() => {
    const init = async () => {
      const token = localStorage.getItem('neobank_access_token');
      if (token) {
        try {
          const res = await userApi.getCurrentUser();
          if (res.success) setUser(res.data);
        } catch (e) {
          localStorage.removeItem('neobank_access_token');
        }
      }
      setIsLoading(false);
    };
    init();
  }, []);

  const login = async (creds: any): Promise<AuthResponse> => {
    const res = await authApi.login(creds);
    if (res.success && res.data) {
      if (!res.data.mfaRequired && res.data.accessToken) {
        localStorage.setItem('neobank_access_token', res.data.accessToken);
        if (res.data.refreshToken) localStorage.setItem('neobank_refresh_token', res.data.refreshToken);
        if (res.data.user) setUser(res.data.user);
      }
      return res.data;
    }
    throw new Error(res.message || 'Login failed');
  };

  const register = async (payload: any): Promise<AuthResponse> => {
    const res = await authApi.register(payload);
    if (res.success && res.data) {
      if (res.data.accessToken) {
        localStorage.setItem('neobank_access_token', res.data.accessToken);
        if (res.data.refreshToken) localStorage.setItem('neobank_refresh_token', res.data.refreshToken);
        if (res.data.user) setUser(res.data.user);
      }
      return res.data;
    }
    throw new Error(res.message || 'Registration failed');
  };

  const verifyMfa = async (mfaSessionToken: string, code: string): Promise<AuthResponse> => {
    const res = await authApi.verifyMfa({ mfaSessionToken, code });
    if (res.success && res.data) {
      if (res.data.accessToken) {
        localStorage.setItem('neobank_access_token', res.data.accessToken);
        if (res.data.refreshToken) localStorage.setItem('neobank_refresh_token', res.data.refreshToken);
        if (res.data.user) setUser(res.data.user);
      }
      return res.data;
    }
    throw new Error(res.message || 'MFA failed');
  };

  const logout = async () => {
    const rt = localStorage.getItem('neobank_refresh_token') || undefined;
    try { await authApi.logout(rt); } catch(e){} finally {
      localStorage.removeItem('neobank_access_token');
      localStorage.removeItem('neobank_refresh_token');
      setUser(null);
    }
  };

  const refreshUser = async () => {
    try { const res = await userApi.getCurrentUser(); if (res.success) setUser(res.data); } catch(e){}
  };

  const hasRole = (role: string): boolean => {
    if (!user || !user.roles) return false;
    return user.roles.includes(role) || user.roles.includes(`ROLE_${role}`);
  };

  return (
    <AuthContext.Provider value={{ user, isAuthenticated: !!user, isLoading, login, register, verifyMfa, logout, refreshUser, hasRole }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) throw new Error('useAuth must be used inside AuthProvider');
  return context;
};

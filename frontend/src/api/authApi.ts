import { apiClient } from './axiosClient';
import { ApiResponse } from '../types/api';
import { AuthResponse, UserDevice } from '../types/auth';
export const authApi = {
  login: async (creds: any) => (await apiClient.post<ApiResponse<AuthResponse>>('/auth/login', creds)).data,
  register: async (payload: any) => (await apiClient.post<ApiResponse<AuthResponse>>('/auth/register', payload)).data,
  verifyMfa: async (payload: any) => (await apiClient.post<ApiResponse<AuthResponse>>('/auth/verify-mfa', payload)).data,
  logout: async (refreshToken?: string) => (await apiClient.post<ApiResponse<void>>('/auth/logout', { refreshToken })).data,
  requestPasswordReset: async (email: string) => (await apiClient.post<ApiResponse<void>>('/auth/password-reset/request', { email })).data,
  confirmPasswordReset: async (payload: any) => (await apiClient.post<ApiResponse<void>>('/auth/password-reset/confirm', payload)).data,
  getDevices: async () => (await apiClient.get<ApiResponse<UserDevice[]>>('/auth/devices')).data,
};

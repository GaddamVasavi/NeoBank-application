import { apiClient } from './axiosClient';
import { ApiResponse } from '../types/api';
import { User, UserPreferences, Address, UserProfile } from '../types/auth';
export const userApi = {
  getCurrentUser: async () => (await apiClient.get<ApiResponse<User>>('/users/me')).data,
  changePassword: async (payload: any) => (await apiClient.post<ApiResponse<void>>('/users/change-password', payload)).data,
  getPreferences: async () => (await apiClient.get<ApiResponse<UserPreferences>>('/users/preferences')).data,
  updatePreferences: async (p: Partial<UserPreferences>) => (await apiClient.put<ApiResponse<UserPreferences>>('/users/preferences', p)).data,
  getAddresses: async () => (await apiClient.get<ApiResponse<Address[]>>('/users/addresses')).data,
  addAddress: async (a: Address) => (await apiClient.post<ApiResponse<Address>>('/users/addresses', a)).data,
  deleteAddress: async (id: string) => (await apiClient.delete<ApiResponse<void>>(`/users/addresses/${id}`)).data,
  getProfile: async () => (await apiClient.get<ApiResponse<UserProfile>>('/profile')).data,
  updateProfile: async (p: Partial<UserProfile>) => (await apiClient.put<ApiResponse<UserProfile>>('/profile', p)).data,
};

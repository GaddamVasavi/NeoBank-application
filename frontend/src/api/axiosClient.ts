import axios, { AxiosError, InternalAxiosRequestConfig } from 'axios';
const API_BASE_URL = '/api/v1';
export const apiClient = axios.create({ baseURL: API_BASE_URL, headers: { 'Content-Type': 'application/json' }, timeout: 30000 });
apiClient.interceptors.request.use((config: InternalAxiosRequestConfig) => {
  const token = localStorage.getItem('neobank_access_token');
  if (token && config.headers) config.headers.Authorization = `Bearer ${token}`;
  return config;
});
apiClient.interceptors.response.use(
  (res) => res,
  async (error: AxiosError) => {
    const original = error.config as InternalAxiosRequestConfig & { _retry?: boolean };
    if (error.response?.status === 401 && !original._retry && !original.url?.includes('/auth/login')) {
      original._retry = true;
      const refreshToken = localStorage.getItem('neobank_refresh_token');
      if (refreshToken) {
        try {
          const res = await axios.post(`${API_BASE_URL}/auth/refresh-token`, { refreshToken });
          const newAccessToken = res.data.data.accessToken;
          localStorage.setItem('neobank_access_token', newAccessToken);
          if (original.headers) original.headers.Authorization = `Bearer ${newAccessToken}`;
          return apiClient(original);
        } catch (e) {
          localStorage.removeItem('neobank_access_token');
          localStorage.removeItem('neobank_refresh_token');
          window.location.href = '/login?expired=true';
        }
      }
    }
    return Promise.reject(error);
  }
);

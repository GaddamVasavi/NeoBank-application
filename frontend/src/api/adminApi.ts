import { apiClient } from './axiosClient';
import { ApiResponse } from '../types/api';
import { AdminStats, FraudCase, SupportTicket, TicketMessage, CashFlowData } from '../types/admin';
import { User } from '../types/auth';

export const adminApi = {
  getStats: async () => (await apiClient.get<ApiResponse<AdminStats>>('/admin/stats')).data,
  getUsers: async () => (await apiClient.get<ApiResponse<User[]>>('/admin/users')).data,
  updateUserStatus: async (userId: string, status: string) => (await apiClient.patch<ApiResponse<void>>(`/admin/users/${userId}/status?status=${status}`)).data,
  getFraudCases: async () => (await apiClient.get<ApiResponse<FraudCase[]>>('/admin/fraud/cases')).data,
  resolveFraudCase: async (caseId: string, resolution: string, notes: string) => (await apiClient.post<ApiResponse<void>>(`/admin/fraud/cases/${caseId}/resolve?resolution=${resolution}&notes=${notes}`)).data,
  getTickets: async () => (await apiClient.get<ApiResponse<SupportTicket[]>>('/support/tickets')).data,
  createTicket: async (p: { subject: string; category: string; priority: string; message: string }) => (await apiClient.post<ApiResponse<SupportTicket>>(`/support/tickets?subject=${p.subject}&category=${p.category}&priority=${p.priority}&message=${p.message}`)).data,
  getMessages: async (tId: string) => (await apiClient.get<ApiResponse<TicketMessage[]>>(`/support/tickets/${tId}/messages`)).data,
  replyTicket: async (tId: string, message: string) => (await apiClient.post<ApiResponse<TicketMessage>>(`/support/tickets/${tId}/reply?message=${message}`)).data,
  getCashFlow: async () => (await apiClient.get<ApiResponse<CashFlowData[]>>('/analytics/cashflow')).data,
};

import { apiClient } from './axiosClient';
import { ApiResponse } from '../types/api';
import { Card } from '../types/card';
import { Loan, LoanProduct } from '../types/loan';
import { KycDocument } from '../types/kyc';
import { AppNotification } from '../types/notification';

export const productsApi = {
  getCards: async () => (await apiClient.get<ApiResponse<Card[]>>('/cards')).data,
  issueCard: async (accountId: string, type: string, isVirtual: boolean) => (await apiClient.post<ApiResponse<Card>>(`/cards/issue?accountId=${accountId}&type=${type}&isVirtual=${isVirtual}`)).data,
  toggleFreezeCard: async (cardId: string) => (await apiClient.patch<ApiResponse<Card>>(`/cards/${cardId}/freeze`)).data,
  getLoanProducts: async () => (await apiClient.get<ApiResponse<LoanProduct[]>>('/loans/products')).data,
  getLoans: async () => (await apiClient.get<ApiResponse<Loan[]>>('/loans')).data,
  applyLoan: async (p: { accountId: string; productId: string; principal: number; tenureMonths: number }) => (await apiClient.post<ApiResponse<Loan>>(`/loans/apply?accountId=${p.accountId}&productId=${p.productId}&principal=${p.principal}&tenureMonths=${p.tenureMonths}`)).data,
  calculateEmi: async (principal: number, rate: number, months: number) => (await apiClient.get<ApiResponse<number>>(`/loans/calculator?principal=${principal}&rate=${rate}&months=${months}`)).data,
  getKycDocuments: async () => (await apiClient.get<ApiResponse<KycDocument[]>>('/kyc')).data,
  uploadKyc: async (docType: string, fileName: string, docNum?: string) => (await apiClient.post<ApiResponse<KycDocument>>(`/kyc/upload?documentType=${docType}&fileName=${fileName}${docNum ? '&documentNumber=' + docNum : ''}`)).data,
  getNotifications: async () => (await apiClient.get<ApiResponse<AppNotification[]>>('/notifications')).data,
  markNotificationRead: async (id: string) => (await apiClient.patch<ApiResponse<void>>(`/notifications/${id}/read`)).data,
};

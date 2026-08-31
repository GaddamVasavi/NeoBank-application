import { apiClient } from './axiosClient';
import { ApiResponse, PagedResponse } from '../types/api';
import { Account } from '../types/account';
import { Transaction } from '../types/transaction';
import { Beneficiary, TransferRequest, TransferResponse } from '../types/transfer';
import { Biller, BillPayment } from '../types/bill';

export const bankingApi = {
  getAccounts: async () => (await apiClient.get<ApiResponse<Account[]>>('/accounts')).data,
  getAccount: async (id: string) => (await apiClient.get<ApiResponse<Account>>(`/accounts/${id}`)).data,
  createAccount: async (p: any) => (await apiClient.post<ApiResponse<Account>>('/accounts', p)).data,
  getTransactions: async (accountId: string, page = 0, size = 10) => (await apiClient.get<ApiResponse<PagedResponse<Transaction>>>(`/transactions/account/${accountId}?page=${page}&size=${size}`)).data,
  getRecentTransactions: async (accountId: string) => (await apiClient.get<ApiResponse<Transaction[]>>(`/transactions/account/${accountId}/recent`)).data,
  transfer: async (req: TransferRequest) => (await apiClient.post<ApiResponse<TransferResponse>>('/transfers', req)).data,
  getBeneficiaries: async () => (await apiClient.get<ApiResponse<Beneficiary[]>>('/transfers/beneficiaries')).data,
  addBeneficiary: async (b: Partial<Beneficiary>) => (await apiClient.post<ApiResponse<Beneficiary>>('/transfers/beneficiaries', b)).data,
  deleteBeneficiary: async (id: string) => (await apiClient.delete<ApiResponse<void>>(`/transfers/beneficiaries/${id}`)).data,
  getBillers: async () => (await apiClient.get<ApiResponse<Biller[]>>('/bills/billers')).data,
  payBill: async (p: { accountId: string; billerId: string; consumerNumber: string; amount: number }) => (await apiClient.post<ApiResponse<BillPayment>>(`/bills/pay?accountId=${p.accountId}&billerId=${p.billerId}&consumerNumber=${p.consumerNumber}&amount=${p.amount}`)).data,
  getBillHistory: async (accountId: string) => (await apiClient.get<ApiResponse<BillPayment[]>>(`/bills/history/${accountId}`)).data,
};

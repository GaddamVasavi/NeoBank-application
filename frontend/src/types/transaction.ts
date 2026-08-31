export type TransactionType = 'DEPOSIT' | 'WITHDRAWAL' | 'TRANSFER_IN' | 'TRANSFER_OUT' | 'BILL_PAYMENT' | 'CARD_PURCHASE' | 'LOAN_DISBURSEMENT' | 'LOAN_REPAYMENT' | 'INTEREST_CREDIT' | 'FEE';
export type TransactionStatus = 'PENDING' | 'COMPLETED' | 'FAILED' | 'CANCELLED' | 'REVERSED';
export interface Transaction {
  id: string;
  accountId: string;
  referenceNumber: string;
  transactionType: TransactionType;
  category: string;
  amount: number;
  fee: number;
  currency: string;
  balanceAfter: number;
  description: string;
  status: TransactionStatus;
  counterpartyAccount?: string;
  counterpartyName?: string;
  transactionDate: string;
}

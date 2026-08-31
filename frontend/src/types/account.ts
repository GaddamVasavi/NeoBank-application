export type AccountType = 'SAVINGS' | 'CHECKING' | 'FIXED_DEPOSIT' | 'BUSINESS';
export type AccountStatus = 'ACTIVE' | 'FROZEN' | 'DORMANT' | 'CLOSED';
export interface Account {
  id: string;
  accountNumber: string;
  accountType: AccountType;
  status: AccountStatus;
  currency: string;
  balance: number;
  availableBalance: number;
  interestRate: number;
  dailyTransferLimit: number;
  singleTransferLimit: number;
  routingNumber: string;
  nickname?: string;
  openedAt: string;
}

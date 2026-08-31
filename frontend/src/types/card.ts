export interface Card {
  id: string;
  accountId: string;
  maskedCardNumber: string;
  cardholderName: string;
  cardType: 'DEBIT' | 'CREDIT' | 'PREPAID';
  cardNetwork: string;
  status: 'ACTIVE' | 'FROZEN' | 'BLOCKED' | 'EXPIRED';
  expiryMonth: number;
  expiryYear: number;
  dailyLimit: number;
  monthlyLimit: number;
  onlinePaymentsEnabled: boolean;
  internationalPaymentsEnabled: boolean;
  contactlessEnabled: boolean;
  atmWithdrawalsEnabled: boolean;
  virtual: boolean;
}

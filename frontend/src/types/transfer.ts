export type TransferType = 'INTERNAL_OWN_ACCOUNT' | 'INTRA_BANK' | 'INTER_BANK' | 'WIRE' | 'INSTANT_PAY';
export interface Beneficiary {
  id: string;
  name: string;
  nickname?: string;
  accountNumber: string;
  bankName: string;
  routingNumber?: string;
  internal: boolean;
  favorite: boolean;
}
export interface TransferRequest {
  sourceAccountId: string;
  destinationAccountId?: string;
  destinationAccountNumber?: string;
  beneficiaryId?: string;
  amount: number;
  transferType: TransferType;
  note?: string;
  idempotencyKey?: string;
}
export interface TransferResponse {
  transferId: string;
  referenceId: string;
  status: string;
  amount: number;
  currency: string;
  timestamp: string;
  message: string;
}

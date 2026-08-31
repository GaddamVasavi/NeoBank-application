export interface Biller {
  id: string;
  name: string;
  category: string;
  accountIdentifierName: string;
  logoUrl?: string;
}
export interface BillPayment {
  id: string;
  referenceId: string;
  consumerNumber: string;
  amount: number;
  currency: string;
  status: string;
  paidAt: string;
  biller: Biller;
}

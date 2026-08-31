export interface LoanProduct {
  id: string; name: string; loanType: string; minAmount: number; maxAmount: number; interestRate: number; minTenureMonths: number; maxTenureMonths: number;
}
export interface Loan {
  id: string; loanReference: string; loanType: string; principalAmount: number; totalAmountPayable: number; outstandingBalance: number; interestRate: number; tenureMonths: number; monthlyInstallment: number; status: string; disbursedAt: string;
}

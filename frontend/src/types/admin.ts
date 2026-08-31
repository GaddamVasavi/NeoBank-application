export interface AdminStats {
  totalUsers: number;
  totalAccounts: number;
  activeFraudCases: number;
  systemHealth: string;
}
export interface FraudCase {
  id: string;
  caseReference: string;
  riskScore: number;
  triggerReason: string;
  status: string;
  createdAt: string;
}
export interface SupportTicket {
  id: string;
  ticketNumber: string;
  subject: string;
  category: string;
  priority: string;
  status: string;
  createdAt: string;
}
export interface TicketMessage {
  id: string;
  message: string;
  internal: boolean;
  createdAt: string;
}
export interface CashFlowData {
  month: string;
  income: number;
  expense: number;
}

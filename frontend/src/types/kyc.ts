export interface KycDocument {
  id: string; documentType: string; documentNumber?: string; fileName: string; fileUrl: string; status: 'PENDING' | 'VERIFIED' | 'REJECTED'; rejectionReason?: string; createdAt: string;
}

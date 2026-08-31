export interface ApiResponse<T> {
  correlationId: string;
  success: boolean;
  message: string;
  data: T;
  error?: {
    code: string;
    message: string;
    path?: string;
    status?: number;
  };
  timestamp: string;
}
export interface PagedResponse<T> {
  content: T[];
  pageNumber: number;
  pageSize: number;
  totalElements: number;
  totalPages: number;
  isFirst: boolean;
  isLast: boolean;
  hasNext: boolean;
  hasPrevious: boolean;
}

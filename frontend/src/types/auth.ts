export interface UserProfile {
  id: string;
  firstName: string;
  middleName?: string;
  lastName: string;
  fullName: string;
  dateOfBirth?: string;
  gender?: 'MALE' | 'FEMALE' | 'NON_BINARY' | 'PREFER_NOT_TO_SAY';
  nationality: string;
  avatarUrl?: string;
  occupation?: string;
  annualIncome?: number;
  kycStatus: 'UNVERIFIED' | 'PENDING' | 'VERIFIED' | 'REJECTED';
  riskScore: number;
}
export interface UserPreferences {
  theme: 'LIGHT' | 'DARK' | 'SYSTEM';
  currency: string;
  language: string;
  emailNotifications: boolean;
  smsNotifications: boolean;
  pushNotifications: boolean;
  marketingEmails: boolean;
  twoFactorOnLogin: boolean;
  twoFactorOnTransfer: boolean;
}
export interface User {
  id: string;
  username: string;
  email: string;
  phoneNumber?: string;
  status: 'PENDING_VERIFICATION' | 'ACTIVE' | 'SUSPENDED' | 'LOCKED' | 'DEACTIVATED';
  emailVerified: boolean;
  phoneVerified: boolean;
  mfaEnabled: boolean;
  roles: string[];
  profile?: UserProfile;
  preferences?: UserPreferences;
  createdAt: string;
}
export interface AuthResponse {
  accessToken?: string;
  refreshToken?: string;
  tokenType: string;
  expiresInMs: number;
  mfaRequired?: boolean;
  mfaSessionToken?: string;
  roles: string[];
  user?: User;
}
export interface UserDevice {
  id: string;
  deviceFingerprint: string;
  deviceName?: string;
  deviceType?: string;
  operatingSystem?: string;
  browser?: string;
  ipAddress?: string;
  city?: string;
  country?: string;
  trusted: boolean;
  lastActiveAt: string;
}
export interface Address {
  id?: string;
  addressType: 'RESIDENTIAL' | 'BILLING' | 'MAILING' | 'OFFICE';
  streetLine1: string;
  streetLine2?: string;
  city: string;
  stateProvince: string;
  postalCode: string;
  country: string;
  primary: boolean;
}

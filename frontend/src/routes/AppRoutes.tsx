import React from 'react'; import { Routes, Route, Navigate } from 'react-router-dom';
import { PublicLayout } from '../layouts/PublicLayout'; import { DashboardLayout } from '../layouts/DashboardLayout'; import { ProtectedRoute } from './ProtectedRoute';
import { LandingPage } from '../pages/public/LandingPage'; import { LoginPage } from '../pages/public/LoginPage';
import { RegisterPage } from '../pages/public/RegisterPage'; import { MfaVerifyPage } from '../pages/public/MfaVerifyPage';
import { ForgotPasswordPage } from '../pages/public/ForgotPasswordPage'; import { ResetPasswordPage } from '../pages/public/ResetPasswordPage';
import { ProfilePage } from '../pages/profile/ProfilePage';
import { DashboardPage } from '../pages/dashboard/DashboardPage';
import { AccountsPage } from '../pages/accounts/AccountsPage';
import { TransfersPage } from '../pages/transfers/TransfersPage';
import { TransactionsPage } from '../pages/transactions/TransactionsPage';
import { BillsPage } from '../pages/bills/BillsPage';
import { CardsPage } from '../pages/cards/CardsPage';
import { LoansPage } from '../pages/loans/LoansPage';
import { KycPage } from '../pages/kyc/KycPage';
import { NotificationsPage } from '../pages/notifications/NotificationsPage';
import { SupportPage } from '../pages/support/SupportPage';
import { AdminDashboardPage } from '../pages/admin/AdminDashboardPage';
export const AppRoutes: React.FC = () => {
  return (
    <Routes>
      <Route element={<PublicLayout />}>
        <Route path="/" element={<LandingPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/mfa-verify" element={<MfaVerifyPage />} />
        <Route path="/forgot-password" element={<ForgotPasswordPage />} />
        <Route path="/reset-password" element={<ResetPasswordPage />} />
      </Route>
      <Route element={<ProtectedRoute />}>
        <Route element={<DashboardLayout />}>
          <Route path="/dashboard" element={<DashboardPage />} />
          <Route path="/accounts" element={<AccountsPage />} />
          <Route path="/transfers" element={<TransfersPage />} />
          <Route path="/transactions" element={<TransactionsPage />} />
          <Route path="/bills" element={<BillsPage />} />
          <Route path="/cards" element={<CardsPage />} />
          <Route path="/loans" element={<LoansPage />} />
          <Route path="/kyc" element={<KycPage />} />
          <Route path="/notifications" element={<NotificationsPage />} />
          <Route path="/support" element={<SupportPage />} />
          <Route path="/profile" element={<ProfilePage />} />
        </Route>
      </Route>
      <Route element={<ProtectedRoute requiredRole="ADMIN" />}>
        <Route element={<DashboardLayout />}>
          <Route path="/admin" element={<AdminDashboardPage />} />
        </Route>
      </Route>
      <Route path="*" element={<Navigate to="/" replace />} />
    </Routes>
  );
};

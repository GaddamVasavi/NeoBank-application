import React, { useState } from 'react'; import { Input } from '../../components/ui/Input'; import { Button } from '../../components/ui/Button'; import { authApi } from '../../api/authApi';
export const ResetPasswordPage: React.FC = () => {
  const [newPassword, setNewPassword] = useState(''); const [confirmPassword, setConfirmPassword] = useState(''); const [success, setSuccess] = useState(false);
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault(); if (newPassword === confirmPassword) { await authApi.confirmPasswordReset({ token: 'test', newPassword, confirmPassword }); setSuccess(true); }
  };
  return (
    <div className="flex-1 flex items-center justify-center px-4 py-12">
      <div className="w-full max-w-md glass-panel p-8 rounded-2xl border border-slate-800">
        <h2 className="text-2xl font-bold text-center mb-6">Set New Password</h2>
        {success ? <p className="text-center text-emerald-400 text-sm">Password updated successfully!</p> : (
          <form onSubmit={handleSubmit} className="space-y-4">
            <Input label="New Password" type="password" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} required />
            <Input label="Confirm Password" type="password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} required />
            <Button type="submit" className="w-full">Save Password</Button>
          </form>
        )}
      </div>
    </div>
  );
};

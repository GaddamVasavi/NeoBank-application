import React, { useState } from 'react'; import { Input } from '../../components/ui/Input'; import { Button } from '../../components/ui/Button'; import { authApi } from '../../api/authApi';
export const ForgotPasswordPage: React.FC = () => {
  const [email, setEmail] = useState(''); const [sent, setSent] = useState(false);
  const handleSubmit = async (e: React.FormEvent) => { e.preventDefault(); await authApi.requestPasswordReset(email); setSent(true); };
  return (
    <div className="flex-1 flex items-center justify-center px-4 py-12">
      <div className="w-full max-w-md glass-panel p-8 rounded-2xl border border-slate-800">
        <h2 className="text-2xl font-bold text-center mb-6">Reset Password</h2>
        {sent ? <p className="text-center text-emerald-400 text-sm">Instructions sent to your email!</p> : (
          <form onSubmit={handleSubmit} className="space-y-4">
            <Input label="Email" type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            <Button type="submit" className="w-full">Send Reset Link</Button>
          </form>
        )}
      </div>
    </div>
  );
};

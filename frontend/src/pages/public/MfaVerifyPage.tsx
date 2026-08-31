import React, { useState } from 'react'; import { useLocation, useNavigate } from 'react-router-dom'; import { Input } from '../../components/ui/Input'; import { Button } from '../../components/ui/Button'; import { useAuth } from '../../contexts/AuthContext';
export const MfaVerifyPage: React.FC = () => {
  const { verifyMfa } = useAuth(); const loc = useLocation(); const navigate = useNavigate(); const [code, setCode] = useState(''); const [loading, setLoading] = useState(false); const [err, setErr] = useState('');
  const token = loc.state?.mfaSessionToken;
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault(); if (!token) return navigate('/login'); setLoading(true); setErr('');
    try { await verifyMfa(token, code); navigate('/dashboard'); } catch(e: any) { setErr(e.message || 'MFA failed'); } finally { setLoading(false); }
  };
  return (
    <div className="flex-1 flex items-center justify-center px-4 py-12">
      <div className="w-full max-w-md glass-panel p-8 rounded-2xl border border-slate-800">
        <h2 className="text-2xl font-bold text-center mb-6">Two-Factor Verification</h2>
        {err && <div className="p-3 mb-4 rounded bg-rose-500/10 text-rose-400 text-xs">{err}</div>}
        <form onSubmit={handleSubmit} className="space-y-4">
          <Input label="Verification Code" placeholder="123456" value={code} onChange={(e) => setCode(e.target.value)} required />
          <Button type="submit" className="w-full" isLoading={loading}>Verify</Button>
        </form>
      </div>
    </div>
  );
};

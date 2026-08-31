import React, { useState } from 'react'; import { Link, useNavigate } from 'react-router-dom'; import { Input } from '../../components/ui/Input'; import { Button } from '../../components/ui/Button'; import { useAuth } from '../../contexts/AuthContext';
export const LoginPage: React.FC = () => {
  const { login } = useAuth(); const navigate = useNavigate(); const [usernameOrEmail, setUsernameOrEmail] = useState(''); const [password, setPassword] = useState(''); const [error, setError] = useState(''); const [loading, setLoading] = useState(false);
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault(); setLoading(true); setError('');
    try {
      const res = await login({ usernameOrEmail, password });
      if (res.mfaRequired && res.mfaSessionToken) navigate('/mfa-verify', { state: { mfaSessionToken: res.mfaSessionToken } });
      else navigate('/dashboard');
    } catch(err: any) { setError(err.message || 'Login failed'); } finally { setLoading(false); }
  };
  return (
    <div className="flex-1 flex items-center justify-center px-4 py-12">
      <div className="w-full max-w-md glass-panel p-8 rounded-2xl border border-slate-800">
        <h2 className="text-2xl font-bold text-center mb-6">Sign in to NeoBank</h2>
        {error && <div className="p-3 mb-4 rounded bg-rose-500/10 border border-rose-500/20 text-rose-400 text-xs">{error}</div>}
        <form onSubmit={handleSubmit} className="space-y-4">
          <Input label="Username or Email" value={usernameOrEmail} onChange={(e) => setUsernameOrEmail(e.target.value)} required />
          <Input label="Password" type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
          <Button type="submit" className="w-full" isLoading={loading}>Sign In</Button>
        </form>
        <p className="text-center text-xs text-slate-400 mt-4">Need an account? <Link to="/register" className="text-brand-400">Register</Link></p>
      </div>
    </div>
  );
};

import React, { useState } from 'react'; import { Link, useNavigate } from 'react-router-dom'; import { Input } from '../../components/ui/Input'; import { Button } from '../../components/ui/Button'; import { useAuth } from '../../contexts/AuthContext';
export const RegisterPage: React.FC = () => {
  const { register } = useAuth(); const navigate = useNavigate(); const [form, setForm] = useState({ username: '', email: '', password: '', firstName: '', lastName: '' }); const [error, setError] = useState(''); const [loading, setLoading] = useState(false);
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault(); setLoading(true); setError('');
    try { await register(form); navigate('/dashboard'); } catch(err: any) { setError(err.message || 'Registration failed'); } finally { setLoading(false); }
  };
  return (
    <div className="flex-1 flex items-center justify-center px-4 py-12">
      <div className="w-full max-w-lg glass-panel p-8 rounded-2xl border border-slate-800">
        <h2 className="text-2xl font-bold text-center mb-6">Open NeoBank Account</h2>
        {error && <div className="p-3 mb-4 rounded bg-rose-500/10 border border-rose-500/20 text-rose-400 text-xs">{error}</div>}
        <form onSubmit={handleSubmit} className="space-y-4">
          <div className="grid grid-cols-2 gap-4">
            <Input label="First Name" value={form.firstName} onChange={(e) => setForm({...form, firstName: e.target.value})} required />
            <Input label="Last Name" value={form.lastName} onChange={(e) => setForm({...form, lastName: e.target.value})} required />
          </div>
          <Input label="Username" value={form.username} onChange={(e) => setForm({...form, username: e.target.value})} required />
          <Input label="Email" type="email" value={form.email} onChange={(e) => setForm({...form, email: e.target.value})} required />
          <Input label="Password" type="password" value={form.password} onChange={(e) => setForm({...form, password: e.target.value})} required />
          <Button type="submit" className="w-full" isLoading={loading}>Create Account</Button>
        </form>
        <p className="text-center text-xs text-slate-400 mt-4">Have an account? <Link to="/login" className="text-brand-400">Sign In</Link></p>
      </div>
    </div>
  );
};

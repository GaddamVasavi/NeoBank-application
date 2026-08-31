import React, { useState } from 'react'; import { Link, useNavigate } from 'react-router-dom'; import { Card } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button';
export const RegisterPage: React.FC = () => {
  const [orgName, setOrgName] = useState('Apex Financial Capital'); const [email, setEmail] = useState('admin@apexcap.com'); const navigate = useNavigate();
  const handleSubmit = (e: React.FormEvent) => { e.preventDefault(); navigate('/dashboard'); };
  return (
    <div className="min-h-screen bg-slate-950 flex items-center justify-center p-4">
      <Card className="w-full max-w-md p-8 border-slate-800">
        <div className="text-center mb-6"><div className="w-12 h-12 rounded-xl bg-emerald-500 flex items-center justify-center font-bold text-slate-950 text-2xl mx-auto mb-3">F</div><h2 className="text-2xl font-bold text-white">Register Organization</h2><p className="text-xs text-slate-400 mt-1">Create a new FinVerse SaaS Tenant</p></div>
        <form onSubmit={handleSubmit} className="space-y-4">
          <div><label className="block text-xs font-medium text-slate-300 mb-1">Organization Name</label><input type="text" value={orgName} onChange={(e) => setOrgName(e.target.value)} required className="w-full px-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-emerald-500 focus:outline-none" /></div>
          <div><label className="block text-xs font-medium text-slate-300 mb-1">Corporate Email</label><input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required className="w-full px-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-emerald-500 focus:outline-none" /></div>
          <Button type="submit" className="w-full py-2.5 mt-2">Provision Tenant Workspace</Button>
        </form>
        <div className="mt-6 text-center text-xs text-slate-400">Already registered? <Link to="/login" className="text-emerald-400 hover:underline">Sign In</Link></div>
      </Card>
    </div>
  );
};

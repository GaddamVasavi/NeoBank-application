import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Badge } from '../../components/ui/Badge'; import { adminApi } from '../../api/adminApi'; import { AdminStats, FraudCase } from '../../types/admin'; import { ShieldAlert, Users, Wallet, Activity, CheckCircle2 } from 'lucide-react';
export const AdminDashboardPage: React.FC = () => {
  const [stats, setStats] = useState<AdminStats | null>(null); const [fraudCases, setFraudCases] = useState<FraudCase[]>([]);
  useEffect(() => {
    const load = async () => { const s = await adminApi.getStats(); if (s.success) setStats(s.data); const f = await adminApi.getFraudCases(); if (f.success) setFraudCases(f.data); };
    load();
  }, []);
  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center"><h1 className="text-2xl font-bold text-white">System Administration & Governance</h1><Badge variant="success">System Status: {stats?.systemHealth || 'HEALTHY'}</Badge></div>
      <div className="grid grid-cols-1 md:grid-cols-4 gap-5">
        <Card><span className="text-xs text-slate-400">Total Registered Users</span><h2 className="text-3xl font-bold text-white mt-2">{stats?.totalUsers || 0}</h2></Card>
        <Card><span className="text-xs text-slate-400">Total Deposit Accounts</span><h2 className="text-3xl font-bold text-white mt-2">{stats?.totalAccounts || 0}</h2></Card>
        <Card><span className="text-xs text-slate-400">Active AML / Fraud Cases</span><h2 className="text-3xl font-bold text-rose-400 mt-2">{stats?.activeFraudCases || 0}</h2></Card>
        <Card><span className="text-xs text-slate-400">Compliance Gateway</span><h2 className="text-3xl font-bold text-emerald-400 mt-2">100%</h2></Card>
      </div>
      <Card title="High-Risk AML & Fraud Detection Queue">
        {fraudCases.length === 0 ? <p className="text-sm text-slate-400 py-6 text-center">No active fraud alerts. Security engine is clear.</p> : (
          <div className="divide-y divide-slate-800">{fraudCases.map(c => (
            <div key={c.id} className="py-3 flex justify-between items-center"><div><p className="text-sm font-bold text-rose-400">Risk Score: {c.riskScore}/100 • {c.caseReference}</p><p className="text-xs text-slate-300 mt-0.5">{c.triggerReason}</p></div><Badge variant="danger">{c.status}</Badge></div>
          ))}</div>
        )}
      </Card>
    </div>
  );
};

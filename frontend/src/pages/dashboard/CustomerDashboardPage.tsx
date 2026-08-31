import React from 'react'; import { Card } from '../../components/ui/Card'; import { Badge } from '../../components/ui/Badge'; import { Button } from '../../components/ui/Button'; import { Plus } from 'lucide-react';
export const CustomerDashboardPage: React.FC = () => (
  <div className="min-h-screen bg-slate-950 text-slate-100 p-8 space-y-8">
    <div className="flex flex-col md:flex-row md:items-center justify-between gap-4">
      <div><h1 className="text-3xl font-bold text-white">Financial Command Center</h1><p className="text-sm text-slate-400 mt-1">Tenant: Apex Financial Capital (ID: 018f-apex-tenant)</p></div>
      <div className="flex space-x-3"><Button variant="secondary">Download Statement</Button><Button icon={<Plus className="w-4 h-4" />}>Transfer Funds</Button></div>
    </div>
    <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
      <Card><span className="text-xs text-slate-400 uppercase font-semibold">Total Liquidity</span><h2 className="text-3xl font-bold text-white mt-1">$14,250,890.00</h2><Badge variant="success" className="mt-2">+12.4% this month</Badge></Card>
      <Card><span className="text-xs text-slate-400 uppercase font-semibold">Operating Inflow</span><h2 className="text-3xl font-bold text-emerald-400 mt-1">$2,840,120.00</h2><span className="text-xs text-slate-400 block mt-2">38 cleared payments</span></Card>
      <Card><span className="text-xs text-slate-400 uppercase font-semibold">Active Subscriptions</span><h2 className="text-3xl font-bold text-sky-400 mt-1">1,420</h2><span className="text-xs text-slate-400 block mt-2">$184K ARR</span></Card>
      <Card><span className="text-xs text-slate-400 uppercase font-semibold">Risk Health Score</span><h2 className="text-3xl font-bold text-emerald-400 mt-1">99.8%</h2><Badge variant="success" className="mt-2">Grade AAA</Badge></Card>
    </div>
  </div>
);

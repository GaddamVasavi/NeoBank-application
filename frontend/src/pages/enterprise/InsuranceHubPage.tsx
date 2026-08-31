import React, { useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { Input } from '../../components/ui/Input';
import { Activity, Shield, DollarSign, FileText, CheckCircle, Plus, Search, Filter } from 'lucide-react';

export const InsuranceHubPage: React.FC = () => {
  const [search, setSearch] = useState('');

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-white">Insurance Policies & Claims Management</h1>
          <p className="text-sm text-slate-400 mt-1">Manage life, property, and travel medical policies with instant claim filing</p>
        </div>
        <div className="flex gap-3">
          <Button variant="secondary" icon={<Filter className="w-4 h-4" />}>Filter</Button>
          <Button icon={<Plus className="w-4 h-4" />}>Create</Button>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <Card><span className="text-xs text-slate-400">Portfolio Exposure</span><h3 className="text-2xl font-bold text-white mt-1">$18,950,000.00</h3><Badge variant="success" className="mt-2">Active</Badge></Card>
        <Card><span className="text-xs text-slate-400">Settled Value</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">$6,420,000.00</h3><span className="text-xs text-slate-400 block mt-2">100% On-Time</span></Card>
        <Card><span className="text-xs text-slate-400">Performance Score</span><h3 className="text-2xl font-bold text-brand-400 mt-1">99.8%</h3><span className="text-xs text-slate-400 block mt-2">Grade A+</span></Card>
        <Card><span className="text-xs text-slate-400">Action Items</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">0 Pending</h3><span className="text-xs text-slate-400 block mt-2">Up to date</span></Card>
      </div>

      <Card title="Operations & Transaction Registry">
        <div className="flex gap-4 mb-4">
          <Input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search by dossier reference or entity name..." />
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="bg-slate-800/60 text-slate-400 text-xs uppercase">
              <tr>
                <th className="p-3">Dossier Ref</th>
                <th className="p-3">Specification</th>
                <th className="p-3">Metric Value</th>
                <th className="p-3">Status</th>
                <th className="p-3">Timestamp</th>
                <th className="p-3 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {[1, 2, 3, 4, 5, 6].map((item) => (
                <tr key={item} className="hover:bg-slate-800/30 transition">
                  <td className="p-3 font-mono text-xs text-brand-400">DOS-2026-{item}084</td>
                  <td className="p-3 font-medium text-white">Enterprise Insurance Policies & Claims Management Record #{item}</td>
                  <td className="p-3 font-semibold text-emerald-400">$850,000.00</td>
                  <td className="p-3"><Badge variant="success">Operational</Badge></td>
                  <td className="p-3 text-xs text-slate-400">2026-08-31 20:55:00</td>
                  <td className="p-3 text-right"><Button variant="ghost" size="sm">Audit</Button></td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </Card>
    </div>
  );
};

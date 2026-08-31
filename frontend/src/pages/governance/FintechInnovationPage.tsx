import React, { useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { Input } from '../../components/ui/Input';
import { Activity, Shield, DollarSign, FileText, CheckCircle, Plus, Search, Filter } from 'lucide-react';

export const FintechInnovationPage: React.FC = () => {
  const [search, setSearch] = useState('');

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-white">Digital Assets & Embedded BaaS</h1>
          <p className="text-sm text-slate-400 mt-1">Smart contract escrow, tokenized deposits, digital identity, and BaaS partner APIs</p>
        </div>
        <div className="flex gap-3">
          <Button variant="secondary" icon={<Filter className="w-4 h-4" />}>Filter</Button>
          <Button icon={<Plus className="w-4 h-4" />}>New Execution</Button>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <Card><span className="text-xs text-slate-400">Institutional Capital</span><h3 className="text-2xl font-bold text-white mt-1">$124,500,000.00</h3><Badge variant="success" className="mt-2">Adequate</Badge></Card>
        <Card><span className="text-xs text-slate-400">Clearing Health</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">100.0%</h3><span className="text-xs text-slate-400 block mt-2">Zero Margin Calls</span></Card>
        <Card><span className="text-xs text-slate-400">Regulatory Index</span><h3 className="text-2xl font-bold text-brand-400 mt-1">Compliant</h3><span className="text-xs text-slate-400 block mt-2">Verified</span></Card>
        <Card><span className="text-xs text-slate-400">Open Actions</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">0</h3><span className="text-xs text-slate-400 block mt-2">Up to date</span></Card>
      </div>

      <Card title="Institutional Regulatory & Execution Stream">
        <div className="flex gap-4 mb-4">
          <Input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search institutional records..." />
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="bg-slate-800/60 text-slate-400 text-xs uppercase">
              <tr>
                <th className="p-3">Institutional Ref</th>
                <th className="p-3">Specification</th>
                <th className="p-3">Nominal Valuation</th>
                <th className="p-3">Status</th>
                <th className="p-3">Finalized Date</th>
                <th className="p-3 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {[1, 2, 3, 4, 5].map((item) => (
                <tr key={item} className="hover:bg-slate-800/30 transition">
                  <td className="p-3 font-mono text-xs text-brand-400">INST-2026-{item}902</td>
                  <td className="p-3 font-medium text-white">Regulatory Digital Assets & Embedded BaaS Record #{item}</td>
                  <td className="p-3 font-semibold text-emerald-400">$5,000,000.00</td>
                  <td className="p-3"><Badge variant="success">Finalized</Badge></td>
                  <td className="p-3 text-xs text-slate-400">2026-08-31 21:00:00</td>
                  <td className="p-3 text-right"><Button variant="ghost" size="sm">Review</Button></td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </Card>
    </div>
  );
};

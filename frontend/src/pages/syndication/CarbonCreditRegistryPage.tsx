import React, { useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { Input } from '../../components/ui/Input';
import { Activity, Shield, DollarSign, FileText, CheckCircle, Plus, Search, Filter } from 'lucide-react';

export const CarbonCreditRegistryPage: React.FC = () => {
  const [search, setSearch] = useState('');

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-white">Carbon Credits & Green ESG Financing</h1>
          <p className="text-sm text-slate-400 mt-1">Verra / Gold standard offsets, Scope 3 financed emissions, and Green Asset Ratio</p>
        </div>
        <div className="flex gap-3">
          <Button variant="secondary" icon={<Filter className="w-4 h-4" />}>Filter</Button>
          <Button icon={<Plus className="w-4 h-4" />}>New Execution</Button>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <Card><span className="text-xs text-slate-400">Institutional Total</span><h3 className="text-2xl font-bold text-white mt-1">$185,000,000.00</h3><Badge variant="success" className="mt-2">Optimal</Badge></Card>
        <Card><span className="text-xs text-slate-400">Execution Rate</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">100.0%</h3><span className="text-xs text-slate-400 block mt-2">Instant Settlement</span></Card>
        <Card><span className="text-xs text-slate-400">Regulatory Status</span><h3 className="text-2xl font-bold text-brand-400 mt-1">Pristine Grade</h3><span className="text-xs text-slate-400 block mt-2">Verified</span></Card>
        <Card><span className="text-xs text-slate-400">Open Reviews</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">0</h3><span className="text-xs text-slate-400 block mt-2">Up to date</span></Card>
      </div>

      <Card title="Institutional Protocol Ledger">
        <div className="flex gap-4 mb-4">
          <Input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search by protocol reference..." />
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="bg-slate-800/60 text-slate-400 text-xs uppercase">
              <tr>
                <th className="p-3">Protocol Ref</th>
                <th className="p-3">Operation</th>
                <th className="p-3">Notional Metric</th>
                <th className="p-3">State</th>
                <th className="p-3">Timestamp</th>
                <th className="p-3 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {[1, 2, 3, 4, 5, 6].map((item) => (
                <tr key={item} className="hover:bg-slate-800/30 transition">
                  <td className="p-3 font-mono text-xs text-brand-400">PROT-2026-{item}881</td>
                  <td className="p-3 font-medium text-white">Institutional Carbon Credits & Green ESG Financing Event #{item}</td>
                  <td className="p-3 font-semibold text-emerald-400">$8,500,000.00</td>
                  <td className="p-3"><Badge variant="success">Executed</Badge></td>
                  <td className="p-3 text-xs text-slate-400">2026-08-31 21:35:00</td>
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

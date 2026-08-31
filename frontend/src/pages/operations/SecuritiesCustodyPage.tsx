import React, { useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { Input } from '../../components/ui/Input';
import { Activity, Shield, DollarSign, FileText, CheckCircle, Plus, Search, Filter } from 'lucide-react';

export const SecuritiesCustodyPage: React.FC = () => {
  const [search, setSearch] = useState('');

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-white">Global Custody & Corporate Actions</h1>
          <p className="text-sm text-slate-400 mt-1">Client asset segregation, proxy voting mandates, and dividend reinvestment (DRIP)</p>
        </div>
        <div className="flex gap-3">
          <Button variant="secondary" icon={<Filter className="w-4 h-4" />}>Filter</Button>
          <Button icon={<Plus className="w-4 h-4" />}>Initiate</Button>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <Card><span className="text-xs text-slate-400">Total Volume</span><h3 className="text-2xl font-bold text-white mt-1">$34,250,000.00</h3><Badge variant="success" className="mt-2">Cleared</Badge></Card>
        <Card><span className="text-xs text-slate-400">Daily Clearing Count</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">14,280 tx</h3><span className="text-xs text-slate-400 block mt-2">100% Success</span></Card>
        <Card><span className="text-xs text-slate-400">Settlement Health</span><h3 className="text-2xl font-bold text-brand-400 mt-1">Tier 1 Prime</h3><span className="text-xs text-slate-400 block mt-2">Compliant</span></Card>
        <Card><span className="text-xs text-slate-400">Exceptions</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">0 Clean</h3><span className="text-xs text-slate-400 block mt-2">Reconciled</span></Card>
      </div>

      <Card title="Market Execution Ledger">
        <div className="flex gap-4 mb-4">
          <Input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search by market reference or ISIN..." />
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="bg-slate-800/60 text-slate-400 text-xs uppercase">
              <tr>
                <th className="p-3">Reference</th>
                <th className="p-3">Specification</th>
                <th className="p-3">Amount</th>
                <th className="p-3">Status</th>
                <th className="p-3">Timestamp</th>
                <th className="p-3 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {[1, 2, 3, 4, 5].map((item) => (
                <tr key={item} className="hover:bg-slate-800/30 transition">
                  <td className="p-3 font-mono text-xs text-brand-400">STLM-2026-{item}092</td>
                  <td className="p-3 font-medium text-white">Institutional Global Custody & Corporate Actions Batch #{item}</td>
                  <td className="p-3 font-semibold text-emerald-400">$1,250,000.00</td>
                  <td className="p-3"><Badge variant="success">Settled</Badge></td>
                  <td className="p-3 text-xs text-slate-400">2026-08-31 20:45:00</td>
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

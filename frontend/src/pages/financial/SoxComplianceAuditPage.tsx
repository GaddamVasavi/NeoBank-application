import React, { useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { Input } from '../../components/ui/Input';
import { Activity, Shield, DollarSign, FileText, CheckCircle, Plus, Search, Filter } from 'lucide-react';

export const SoxComplianceAuditPage: React.FC = () => {
  const [search, setSearch] = useState('');

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-white">Sarbanes-Oxley (SOX 404) & Capital Buffers</h1>
          <p className="text-sm text-slate-400 mt-1">Internal control deficiency remediations, CCAR stress tests, and capital buffers</p>
        </div>
        <div className="flex gap-3">
          <Button variant="secondary" icon={<Filter className="w-4 h-4" />}>Filter</Button>
          <Button icon={<Plus className="w-4 h-4" />}>New Order</Button>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <Card><span className="text-xs text-slate-400">Notional Value</span><h3 className="text-2xl font-bold text-white mt-1">$72,500,000.00</h3><Badge variant="success" className="mt-2">Balanced</Badge></Card>
        <Card><span className="text-xs text-slate-400">Clearing Rate</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">100.0%</h3><span className="text-xs text-slate-400 block mt-2">Sub-second</span></Card>
        <Card><span className="text-xs text-slate-400">Risk Quality</span><h3 className="text-2xl font-bold text-brand-400 mt-1">Investment Grade</h3><span className="text-xs text-slate-400 block mt-2">Verified</span></Card>
        <Card><span className="text-xs text-slate-400">Pending Settlements</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">0</h3><span className="text-xs text-slate-400 block mt-2">Up to date</span></Card>
      </div>

      <Card title="Institutional Financial Stream">
        <div className="flex gap-4 mb-4">
          <Input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search entries by clearing key or instrument..." />
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="bg-slate-800/60 text-slate-400 text-xs uppercase">
              <tr>
                <th className="p-3">Clearing Key</th>
                <th className="p-3">Instrument</th>
                <th className="p-3">Principal Valuation</th>
                <th className="p-3">Status</th>
                <th className="p-3">Timestamp</th>
                <th className="p-3 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {[1, 2, 3, 4, 5].map((item) => (
                <tr key={item} className="hover:bg-slate-800/30 transition">
                  <td className="p-3 font-mono text-xs text-brand-400">CLR-2026-{item}993</td>
                  <td className="p-3 font-medium text-white">Financial Sarbanes-Oxley (SOX 404) & Capital Buffers Record #{item}</td>
                  <td className="p-3 font-semibold text-emerald-400">$3,500,000.00</td>
                  <td className="p-3"><Badge variant="success">Reconciled</Badge></td>
                  <td className="p-3 text-xs text-slate-400">2026-08-31 21:25:00</td>
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

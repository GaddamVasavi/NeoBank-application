import React, { useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { Input } from '../../components/ui/Input';
import { Activity, Shield, DollarSign, FileText, CheckCircle, Plus, Search, Filter } from 'lucide-react';

export const IntradayLiquidityPage: React.FC = () => {
  const [search, setSearch] = useState('');

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-white">Intraday Liquidity & Central Bank Reserves</h1>
          <p className="text-sm text-slate-400 mt-1">Basel liquidity stress testing, committed overdraft facilities, and Nostro funding forecasts</p>
        </div>
        <div className="flex gap-3">
          <Button variant="secondary" icon={<Filter className="w-4 h-4" />}>Filter</Button>
          <Button icon={<Plus className="w-4 h-4" />}>Execute</Button>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <Card><span className="text-xs text-slate-400">Institutional Pool</span><h3 className="text-2xl font-bold text-white mt-1">$58,900,000.00</h3><Badge variant="success" className="mt-2">Adequate</Badge></Card>
        <Card><span className="text-xs text-slate-400">Clearing Success</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">100%</h3><span className="text-xs text-slate-400 block mt-2">Verified</span></Card>
        <Card><span className="text-xs text-slate-400">Reserve Compliance</span><h3 className="text-2xl font-bold text-brand-400 mt-1">Grade A</h3><span className="text-xs text-slate-400 block mt-2">Surplus</span></Card>
        <Card><span className="text-xs text-slate-400">Pending Actions</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">0</h3><span className="text-xs text-slate-400 block mt-2">Up to date</span></Card>
      </div>

      <Card title="Institutional Liquidity & Trading Stream">
        <div className="flex gap-4 mb-4">
          <Input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search by market reference or ISIN..." />
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="bg-slate-800/60 text-slate-400 text-xs uppercase">
              <tr>
                <th className="p-3">Reference</th>
                <th className="p-3">Specification</th>
                <th className="p-3">Nominal Value</th>
                <th className="p-3">Status</th>
                <th className="p-3">Timestamp</th>
                <th className="p-3 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {[1, 2, 3, 4, 5].map((item) => (
                <tr key={item} className="hover:bg-slate-800/30 transition">
                  <td className="p-3 font-mono text-xs text-brand-400">SEC-2026-{item}772</td>
                  <td className="p-3 font-medium text-white">Institutional Intraday Liquidity & Central Bank Reserves Record #{item}</td>
                  <td className="p-3 font-semibold text-emerald-400">$4,250,000.00</td>
                  <td className="p-3"><Badge variant="success">Verified</Badge></td>
                  <td className="p-3 text-xs text-slate-400">2026-08-31 21:20:00</td>
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

import React, { useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Button } from '../../components/ui/Button';
import { Badge } from '../../components/ui/Badge';
import { Input } from '../../components/ui/Input';
import { Activity, Shield, DollarSign, FileText, CheckCircle, Plus, Search, Filter, Server, Database, Globe } from 'lucide-react';

export const OperationsClearingPage: React.FC = () => {
  const [search, setSearch] = useState('');
  const [activeTab, setActiveTab] = useState('OVERVIEW');

  return (
    <div className="space-y-6">
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-white">Operations, Clearing & SWIFT Gateway</h1>
          <p className="text-sm text-slate-400 mt-1">Real-time ledger exception resolution, ISO 20022 message tracking, and clearing batches</p>
        </div>
        <div className="flex gap-3">
          <Button variant="secondary" icon={<Filter className="w-4 h-4" />}>Filter View</Button>
          <Button icon={<Plus className="w-4 h-4" />}>Execute Task</Button>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <Card><span className="text-xs text-slate-400">Aggregated Value</span><h3 className="text-2xl font-bold text-white mt-1">$8,940,250.00</h3><Badge variant="success" className="mt-2">Optimal</Badge></Card>
        <Card><span className="text-xs text-slate-400">System Throughput</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">1,850 ops/sec</h3><span className="text-xs text-slate-400 block mt-2">Sub-millisecond</span></Card>
        <Card><span className="text-xs text-slate-400">Compliance Level</span><h3 className="text-2xl font-bold text-brand-400 mt-1">100% Passed</h3><span className="text-xs text-slate-400 block mt-2">Verified</span></Card>
        <Card><span className="text-xs text-slate-400">Active Exceptions</span><h3 className="text-2xl font-bold text-emerald-400 mt-1">0 Clean</h3><span className="text-xs text-slate-400 block mt-2">Reconciled</span></Card>
      </div>

      <Card title="Operations Telemetry & Real-Time Event Stream">
        <div className="flex gap-4 mb-4">
          <Input value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search by transaction reference, batch identifier, or party..." />
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="bg-slate-800/60 text-slate-400 text-xs uppercase">
              <tr>
                <th className="p-3">Event ID</th>
                <th className="p-3">Operation</th>
                <th className="p-3">Nominal Value</th>
                <th className="p-3">State</th>
                <th className="p-3">Timestamp</th>
                <th className="p-3 text-right">Inspection</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {[1, 2, 3, 4, 5, 6, 7, 8].map((item) => (
                <tr key={item} className="hover:bg-slate-800/30 transition">
                  <td className="p-3 font-mono text-xs text-brand-400">EVT-2026-0831-00{item}</td>
                  <td className="p-3 font-medium text-white">Automated Settlement Batch Execution #{item}</td>
                  <td className="p-3 font-semibold text-emerald-400">$45,000.00</td>
                  <td className="p-3"><Badge variant="success">Verified</Badge></td>
                  <td className="p-3 text-xs text-slate-400">2026-08-31 20:30:00</td>
                  <td className="p-3 text-right"><Button variant="ghost" size="sm">Details</Button></td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </Card>
    </div>
  );
};

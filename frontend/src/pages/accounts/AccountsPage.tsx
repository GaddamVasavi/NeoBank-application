import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button'; import { Badge } from '../../components/ui/Badge'; import { bankingApi } from '../../api/bankingApi'; import { Account } from '../../types/account'; import { Plus, Wallet, Shield } from 'lucide-react';
export const AccountsPage: React.FC = () => {
  const [accounts, setAccounts] = useState<Account[]>([]); const [isOpen, setIsOpen] = useState(false); const [type, setType] = useState('SAVINGS'); const [deposit, setDeposit] = useState('100');
  const load = async () => { const res = await bankingApi.getAccounts(); if (res.success) setAccounts(res.data); };
  useEffect(() => { load(); }, []);
  const handleCreate = async (e: React.FormEvent) => { e.preventDefault(); await bankingApi.createAccount({ accountType: type, initialDeposit: parseFloat(deposit) }); setIsOpen(false); load(); };
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <h1 className="text-2xl font-bold text-white">Deposit & Savings Accounts</h1>
        <Button onClick={() => setIsOpen(true)} icon={<Plus className="w-4 h-4" />}>Open New Account</Button>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {accounts.map((a) => (
          <Card key={a.id} className="relative overflow-hidden">
            <div className="flex justify-between items-start mb-4">
              <div>
                <span className="text-xs text-slate-400 uppercase tracking-wider">{a.accountType}</span>
                <h3 className="text-lg font-bold text-white mt-1">•••• {a.accountNumber.slice(-4)}</h3>
              </div>
              <Badge variant="success">{a.status}</Badge>
            </div>
            <div className="mt-4">
              <span className="text-xs text-slate-400">Available Balance</span>
              <p className="text-3xl font-extrabold text-white mt-1">${a.availableBalance.toFixed(2)}</p>
            </div>
            <div className="mt-6 pt-4 border-t border-slate-800 flex justify-between text-xs text-slate-400">
              <span>Routing: {a.routingNumber}</span>
              <span>Interest: {a.interestRate}% APY</span>
            </div>
          </Card>
        ))}
      </div>
      {isOpen && (
        <div className="fixed inset-0 z-50 bg-slate-950/80 flex items-center justify-center p-4">
          <div className="glass-panel p-6 rounded-2xl max-w-md w-full border border-slate-800 space-y-4">
            <h3 className="text-lg font-bold text-white">Open High-Yield Account</h3>
            <form onSubmit={handleCreate} className="space-y-4">
              <select value={type} onChange={(e) => setType(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100">
                <option value="SAVINGS">High-Yield Savings (4.25% APY)</option>
                <option value="CHECKING">Standard Checking</option>
              </select>
              <input type="number" value={deposit} onChange={(e) => setDeposit(e.target.value)} placeholder="Initial Deposit ($)" className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100" />
              <div className="flex justify-end gap-3">
                <Button variant="ghost" type="button" onClick={() => setIsOpen(false)}>Cancel</Button>
                <Button type="submit">Open Account</Button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};

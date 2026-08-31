import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button'; import { Input } from '../../components/ui/Input'; import { bankingApi } from '../../api/bankingApi'; import { Account } from '../../types/account'; import { Biller } from '../../types/bill';
export const BillsPage: React.FC = () => {
  const [accounts, setAccounts] = useState<Account[]>([]); const [billers, setBillers] = useState<Biller[]>([]); const [selectedAcc, setSelectedAcc] = useState(''); const [selectedBiller, setSelectedBiller] = useState(''); const [consumerNum, setConsumerNum] = useState(''); const [amount, setAmount] = useState(''); const [msg, setMsg] = useState('');
  useEffect(() => {
    const load = async () => {
      const a = await bankingApi.getAccounts(); if (a.success && a.data.length > 0) { setAccounts(a.data); setSelectedAcc(a.data[0].id); }
      const b = await bankingApi.getBillers(); if (b.success && b.data.length > 0) { setBillers(b.data); setSelectedBiller(b.data[0].id); }
    };
    load();
  }, []);
  const handlePay = async (e: React.FormEvent) => {
    e.preventDefault(); setMsg('');
    try {
      const res = await bankingApi.payBill({ accountId: selectedAcc, billerId: selectedBiller, consumerNumber: consumerNum, amount: parseFloat(amount) });
      if (res.success) setMsg('Bill paid successfully!');
    } catch(e: any) { setMsg(e.message || 'Payment failed'); }
  };
  return (
    <div className="space-y-6 max-w-xl">
      <h1 className="text-2xl font-bold text-white">Utility Bill Payments</h1>
      {msg && <div className="p-3 rounded bg-emerald-500/10 text-emerald-400 text-sm">{msg}</div>}
      <Card title="Pay Bill">
        <form onSubmit={handlePay} className="space-y-4">
          <div>
            <label className="block text-xs text-slate-400 mb-1">From Account</label>
            <select value={selectedAcc} onChange={(e) => setSelectedAcc(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm">
              {accounts.map(a => <option key={a.id} value={a.id}>{a.accountType} (•••• {a.accountNumber.slice(-4)}) - ${a.availableBalance.toFixed(2)}</option>)}
            </select>
          </div>
          <div>
            <label className="block text-xs text-slate-400 mb-1">Biller</label>
            <select value={selectedBiller} onChange={(e) => setSelectedBiller(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm">
              {billers.map(b => <option key={b.id} value={b.id}>{b.name} ({b.category})</option>)}
            </select>
          </div>
          <Input label="Account / Consumer Number" value={consumerNum} onChange={(e) => setConsumerNum(e.target.value)} required />
          <Input label="Amount ($)" type="number" value={amount} onChange={(e) => setAmount(e.target.value)} required />
          <Button type="submit" className="w-full">Pay Now</Button>
        </form>
      </Card>
    </div>
  );
};

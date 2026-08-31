import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button'; import { Input } from '../../components/ui/Input'; import { bankingApi } from '../../api/bankingApi'; import { Account } from '../../types/account'; import { Beneficiary } from '../../types/transfer';
export const TransfersPage: React.FC = () => {
  const [accounts, setAccounts] = useState<Account[]>([]); const [beneficiaries, setBeneficiaries] = useState<Beneficiary[]>([]); const [source, setSource] = useState(''); const [dest, setDest] = useState(''); const [amount, setAmount] = useState(''); const [note, setNote] = useState(''); const [msg, setMsg] = useState('');
  useEffect(() => {
    const load = async () => {
      const a = await bankingApi.getAccounts(); if (a.success) { setAccounts(a.data); if (a.data.length > 0) setSource(a.data[0].id); }
      const b = await bankingApi.getBeneficiaries(); if (b.success) setBeneficiaries(b.data);
    };
    load();
  }, []);
  const handleTransfer = async (e: React.FormEvent) => {
    e.preventDefault(); setMsg('');
    try {
      const res = await bankingApi.transfer({ sourceAccountId: source, destinationAccountId: dest || undefined, amount: parseFloat(amount), transferType: 'INTERNAL_OWN_ACCOUNT', note });
      if (res.success) setMsg('Transfer executed successfully!');
    } catch(e: any) { setMsg(e.message || 'Transfer failed'); }
  };
  return (
    <div className="space-y-6 max-w-2xl">
      <h1 className="text-2xl font-bold text-white">Transfer Funds</h1>
      {msg && <div className="p-3 rounded bg-emerald-500/10 text-emerald-400 text-sm">{msg}</div>}
      <Card title="Transfer Details">
        <form onSubmit={handleTransfer} className="space-y-4">
          <div>
            <label className="block text-xs text-slate-400 mb-1">Source Account</label>
            <select value={source} onChange={(e) => setSource(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm">
              {accounts.map((a) => <option key={a.id} value={a.id}>{a.accountType} (•••• {a.accountNumber.slice(-4)}) - ${a.availableBalance.toFixed(2)}</option>)}
            </select>
          </div>
          <div>
            <label className="block text-xs text-slate-400 mb-1">Destination Account</label>
            <select value={dest} onChange={(e) => setDest(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm">
              <option value="">Select Account</option>
              {accounts.filter(a => a.id !== source).map((a) => <option key={a.id} value={a.id}>{a.accountType} (•••• {a.accountNumber.slice(-4)})</option>)}
            </select>
          </div>
          <Input label="Amount ($)" type="number" value={amount} onChange={(e) => setAmount(e.target.value)} required />
          <Input label="Note / Reference" value={note} onChange={(e) => setNote(e.target.value)} />
          <Button type="submit" className="w-full">Confirm & Send</Button>
        </form>
      </Card>
    </div>
  );
};

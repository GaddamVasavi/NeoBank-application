import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { bankingApi } from '../../api/bankingApi'; import { Account } from '../../types/account'; import { Transaction } from '../../types/transaction';
export const TransactionsPage: React.FC = () => {
  const [accounts, setAccounts] = useState<Account[]>([]); const [selectedAcc, setSelectedAcc] = useState(''); const [transactions, setTransactions] = useState<Transaction[]>([]);
  useEffect(() => {
    const load = async () => {
      const a = await bankingApi.getAccounts();
      if (a.success && a.data.length > 0) {
        setAccounts(a.data); setSelectedAcc(a.data[0].id);
        const tx = await bankingApi.getTransactions(a.data[0].id);
        if (tx.success && tx.data) setTransactions(tx.data.content);
      }
    };
    load();
  }, []);
  const handleAccChange = async (accId: string) => {
    setSelectedAcc(accId);
    const tx = await bankingApi.getTransactions(accId);
    if (tx.success && tx.data) setTransactions(tx.data.content);
  };
  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <h1 className="text-2xl font-bold text-white">Transaction History</h1>
        <select value={selectedAcc} onChange={(e) => handleAccChange(e.target.value)} className="p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm">
          {accounts.map(a => <option key={a.id} value={a.id}>{a.accountType} (•••• {a.accountNumber.slice(-4)})</option>)}
        </select>
      </div>
      <Card>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm text-slate-300">
            <thead className="text-xs uppercase bg-slate-900/50 text-slate-400 border-b border-slate-800">
              <tr><th className="p-3">Date</th><th className="p-3">Reference</th><th className="p-3">Description</th><th className="p-3">Type</th><th className="p-3 text-right">Amount</th></tr>
            </thead>
            <tbody className="divide-y divide-slate-800">
              {transactions.map(t => (
                <tr key={t.id}>
                  <td className="p-3">{new Date(t.transactionDate).toLocaleDateString()}</td>
                  <td className="p-3 font-mono text-xs text-slate-400">{t.referenceNumber}</td>
                  <td className="p-3 text-white font-medium">{t.description}</td>
                  <td className="p-3 text-xs">{t.transactionType}</td>
                  <td className={`p-3 text-right font-bold ${t.amount < 0 ? 'text-slate-200' : 'text-emerald-400'}`}>${Math.abs(t.amount).toFixed(2)}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </Card>
    </div>
  );
};

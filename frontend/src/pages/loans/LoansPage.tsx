import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button'; import { Input } from '../../components/ui/Input'; import { productsApi } from '../../api/productsApi'; import { bankingApi } from '../../api/bankingApi'; import { Loan, LoanProduct } from '../../types/loan'; import { Account } from '../../types/account'; import { PiggyBank, Calculator } from 'lucide-react';
export const LoansPage: React.FC = () => {
  const [loans, setLoans] = useState<Loan[]>([]); const [products, setProducts] = useState<LoanProduct[]>([]); const [accounts, setAccounts] = useState<Account[]>([]); const [selectedAcc, setSelectedAcc] = useState(''); const [selectedProd, setSelectedProd] = useState(''); const [amount, setAmount] = useState('5000'); const [months, setMonths] = useState(12); const [emi, setEmi] = useState<number>(0); const [msg, setMsg] = useState('');
  useEffect(() => {
    const load = async () => {
      const l = await productsApi.getLoans(); if (l.success) setLoans(l.data);
      const p = await productsApi.getLoanProducts(); if (p.success && p.data.length > 0) { setProducts(p.data); setSelectedProd(p.data[0].id); }
      const a = await bankingApi.getAccounts(); if (a.success && a.data.length > 0) { setAccounts(a.data); setSelectedAcc(a.data[0].id); }
    };
    load();
  }, []);
  useEffect(() => {
    const calc = async () => {
      const prod = products.find(p => p.id === selectedProd);
      if (prod) {
        const res = await productsApi.calculateEmi(parseFloat(amount) || 1000, prod.interestRate, months);
        if (res.success) setEmi(res.data);
      }
    };
    calc();
  }, [amount, months, selectedProd, products]);
  const handleApply = async (e: React.FormEvent) => {
    e.preventDefault(); setMsg('');
    try {
      const res = await productsApi.applyLoan({ accountId: selectedAcc, productId: selectedProd, principal: parseFloat(amount), tenureMonths: months });
      if (res.success) { setMsg('Loan approved & disbursed instantly!'); const l = await productsApi.getLoans(); if (l.success) setLoans(l.data); }
    } catch(e: any) { setMsg(e.message || 'Application failed'); }
  };
  return (
    <div className="space-y-6">
      <h1 className="text-2xl font-bold text-white">Loans & Credit Facilities</h1>
      {msg && <div className="p-3 rounded bg-emerald-500/10 text-emerald-400 text-sm">{msg}</div>}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <Card title="Instant Loan Application & EMI Simulator">
          <form onSubmit={handleApply} className="space-y-4">
            <div><label className="block text-xs text-slate-400 mb-1">Deposit Account</label><select value={selectedAcc} onChange={e => setSelectedAcc(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm">{accounts.map(a => <option key={a.id} value={a.id}>{a.accountType} (•••• {a.accountNumber.slice(-4)})</option>)}</select></div>
            <div><label className="block text-xs text-slate-400 mb-1">Loan Product</label><select value={selectedProd} onChange={e => setSelectedProd(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm">{products.map(p => <option key={p.id} value={p.id}>{p.name} ({p.interestRate}% APR)</option>)}</select></div>
            <Input label="Principal Amount ($)" type="number" value={amount} onChange={e => setAmount(e.target.value)} required />
            <div><label className="block text-xs text-slate-400 mb-1">Tenure: {months} Months</label><input type="range" min={6} max={60} step={6} value={months} onChange={e => setMonths(parseInt(e.target.value))} className="w-full" /></div>
            <div className="p-4 rounded-xl bg-slate-900/80 border border-slate-800 flex justify-between items-center"><div><span className="text-xs text-slate-400">Estimated Monthly EMI</span><p className="text-2xl font-bold text-emerald-400">${emi.toFixed(2)}/mo</p></div><Button type="submit">Apply & Disburse</Button></div>
          </form>
        </Card>
        <Card title="Active Loans Portfolio">
          {loans.length === 0 ? <p className="text-sm text-slate-400 py-6 text-center">No active loans</p> : (
            <div className="space-y-3">{loans.map(l => (
              <div key={l.id} className="p-4 rounded-xl bg-slate-900 border border-slate-800"><div className="flex justify-between"><span className="font-bold text-white">{l.loanType}</span><span className="text-xs text-emerald-400 font-semibold">{l.status}</span></div><p className="text-xl font-extrabold text-white mt-2">${l.outstandingBalance.toFixed(2)}</p><p className="text-xs text-slate-400 mt-1">EMI: ${l.monthlyInstallment.toFixed(2)} • {l.interestRate}% APR</p></div>
            ))}</div>
          )}
        </Card>
      </div>
    </div>
  );
};

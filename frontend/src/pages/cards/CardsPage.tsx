import React, { useEffect, useState } from 'react'; import { Card as UiCard } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button'; import { Badge } from '../../components/ui/Badge'; import { productsApi } from '../../api/productsApi'; import { bankingApi } from '../../api/bankingApi'; import { Card } from '../../types/card'; import { Account } from '../../types/account'; import { CreditCard, Lock, Unlock, Plus, ShieldCheck } from 'lucide-react';
export const CardsPage: React.FC = () => {
  const [cards, setCards] = useState<Card[]>([]); const [accounts, setAccounts] = useState<Account[]>([]); const [isOpen, setIsOpen] = useState(false); const [selectedAcc, setSelectedAcc] = useState(''); const [type, setType] = useState('DEBIT'); const [isVirt, setIsVirt] = useState(false);
  const load = async () => { const res = await productsApi.getCards(); if (res.success) setCards(res.data); const a = await bankingApi.getAccounts(); if (a.success && a.data.length > 0) { setAccounts(a.data); setSelectedAcc(a.data[0].id); } };
  useEffect(() => { load(); }, []);
  const handleIssue = async (e: React.FormEvent) => { e.preventDefault(); await productsApi.issueCard(selectedAcc, type, isVirt); setIsOpen(false); load(); };
  const toggleFreeze = async (id: string) => { await productsApi.toggleFreezeCard(id); load(); };
  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <h1 className="text-2xl font-bold text-white">Debit & Virtual Cards</h1>
        <Button onClick={() => setIsOpen(true)} icon={<Plus className="w-4 h-4" />}>Issue Card</Button>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {cards.map(c => (
          <div key={c.id} className="p-6 rounded-2xl bg-gradient-to-tr from-slate-900 via-indigo-950 to-slate-900 border border-slate-800 shadow-2xl relative">
            <div className="flex justify-between items-center mb-8">
              <span className="text-xs font-mono tracking-widest text-indigo-400 font-semibold">NEOBANK {c.virtual ? 'VIRTUAL' : 'TITANIUM'}</span>
              <Badge variant={c.status === 'ACTIVE' ? 'success' : 'danger'}>{c.status}</Badge>
            </div>
            <p className="font-mono text-xl tracking-widest text-white mb-6">{c.maskedCardNumber}</p>
            <div className="flex justify-between items-end">
              <div><span className="text-[10px] text-slate-400 uppercase">Cardholder</span><p className="text-sm font-semibold text-slate-200">{c.cardholderName}</p></div>
              <div><span className="text-[10px] text-slate-400 uppercase">Expires</span><p className="text-sm font-semibold text-slate-200">{c.expiryMonth}/{c.expiryYear}</p></div>
              <Button size="sm" variant={c.status === 'ACTIVE' ? 'danger' : 'primary'} onClick={() => toggleFreeze(c.id)} icon={c.status === 'ACTIVE' ? <Lock className="w-3 h-3" /> : <Unlock className="w-3 h-3" />}>{c.status === 'ACTIVE' ? 'Freeze' : 'Unfreeze'}</Button>
            </div>
          </div>
        ))}
      </div>
      {isOpen && (
        <div className="fixed inset-0 z-50 bg-slate-950/80 flex items-center justify-center p-4">
          <div className="glass-panel p-6 rounded-2xl max-w-md w-full border border-slate-800 space-y-4">
            <h3 className="text-lg font-bold text-white">Issue Instant Card</h3>
            <form onSubmit={handleIssue} className="space-y-4">
              <div><label className="block text-xs text-slate-400 mb-1">Linked Account</label><select value={selectedAcc} onChange={e => setSelectedAcc(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100">{accounts.map(a => <option key={a.id} value={a.id}>{a.accountType} (•••• {a.accountNumber.slice(-4)})</option>)}</select></div>
              <div><label className="block text-xs text-slate-400 mb-1">Card Type</label><select value={type} onChange={e => setType(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100"><option value="DEBIT">Debit Card</option><option value="CREDIT">Credit Card</option></select></div>
              <label className="flex items-center gap-2 text-xs text-slate-300"><input type="checkbox" checked={isVirt} onChange={e => setIsVirt(e.target.checked)} /> Instant Virtual Card</label>
              <div className="flex justify-end gap-3"><Button variant="ghost" type="button" onClick={() => setIsOpen(false)}>Cancel</Button><Button type="submit">Issue Now</Button></div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};

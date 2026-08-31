import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button'; import { Input } from '../../components/ui/Input'; import { Badge } from '../../components/ui/Badge'; import { adminApi } from '../../api/adminApi'; import { SupportTicket, TicketMessage } from '../../types/admin'; import { HelpCircle, MessageSquare, Send, Plus } from 'lucide-react';
export const SupportPage: React.FC = () => {
  const [tickets, setTickets] = useState<SupportTicket[]>([]); const [selectedTicket, setSelectedTicket] = useState<string | null>(null); const [messages, setMessages] = useState<TicketMessage[]>([]); const [reply, setReply] = useState(''); const [isOpen, setIsOpen] = useState(false); const [sub, setSub] = useState(''); const [cat, setCat] = useState('TRANSFERS'); const [msg, setMsg] = useState('');
  const load = async () => { const res = await adminApi.getTickets(); if (res.success) setTickets(res.data); };
  useEffect(() => { load(); }, []);
  const openChat = async (id: string) => { setSelectedTicket(id); const res = await adminApi.getMessages(id); if (res.success) setMessages(res.data); };
  const handleReply = async (e: React.FormEvent) => { e.preventDefault(); if (!selectedTicket || !reply) return; await adminApi.replyTicket(selectedTicket, reply); setReply(''); openChat(selectedTicket); };
  const handleCreate = async (e: React.FormEvent) => { e.preventDefault(); await adminApi.createTicket({ subject: sub, category: cat, priority: 'HIGH', message: msg }); setIsOpen(false); load(); };
  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center"><h1 className="text-2xl font-bold text-white">Customer Support & Concierge</h1><Button onClick={() => setIsOpen(true)} icon={<Plus className="w-4 h-4" />}>Open New Ticket</Button></div>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        <div className="space-y-3">{tickets.map(t => (
          <div key={t.id} onClick={() => openChat(t.id)} className={`p-4 rounded-xl cursor-pointer border ${selectedTicket === t.id ? 'bg-slate-800 border-brand-500' : 'bg-slate-900 border-slate-800'}`}><div className="flex justify-between items-start"><span className="font-bold text-white text-sm">{t.subject}</span><Badge variant="info">{t.status}</Badge></div><p className="text-xs text-slate-400 mt-1">{t.category} • {t.ticketNumber}</p></div>
        ))}</div>
        <div className="md:col-span-2"><Card title="Ticket Conversation">
          {selectedTicket ? (<div className="space-y-4"><div className="h-64 overflow-y-auto space-y-2 p-2 bg-slate-950/60 rounded-xl">{messages.map(m => (<div key={m.id} className="p-3 rounded-lg bg-slate-800 text-sm text-slate-200"><p>{m.message}</p><span className="text-[10px] text-slate-400 mt-1 block">{new Date(m.createdAt).toLocaleTimeString()}</span></div>))}</div><form onSubmit={handleReply} className="flex gap-2"><Input value={reply} onChange={e => setReply(e.target.value)} placeholder="Write reply..." /><Button type="submit" icon={<Send className="w-4 h-4" />}>Send</Button></form></div>) : <p className="text-sm text-slate-400 py-12 text-center">Select a ticket to open conversation</p>}
        </Card></div>
      </div>
      {isOpen && (<div className="fixed inset-0 z-50 bg-slate-950/80 flex items-center justify-center p-4"><div className="glass-panel p-6 rounded-2xl max-w-md w-full border border-slate-800 space-y-4"><h3 className="text-lg font-bold text-white">New Support Ticket</h3><form onSubmit={handleCreate} className="space-y-4"><Input label="Subject" value={sub} onChange={e => setSub(e.target.value)} required /><div><label className="block text-xs text-slate-400 mb-1">Category</label><select value={cat} onChange={e => setCat(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100"><option value="TRANSFERS">Transfers & Payments</option><option value="CARDS">Cards & PINs</option><option value="LOANS">Loans & Mortgages</option><option value="SECURITY">Account Security</option></select></div><div><label className="block text-xs text-slate-400 mb-1">Message</label><textarea value={msg} onChange={e => setMsg(e.target.value)} rows={3} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm" required /></div><div className="flex justify-end gap-3"><Button variant="ghost" type="button" onClick={() => setIsOpen(false)}>Cancel</Button><Button type="submit">Submit</Button></div></form></div></div>)}
    </div>
  );
};

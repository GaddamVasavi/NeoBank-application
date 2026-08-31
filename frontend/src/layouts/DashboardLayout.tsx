import React, { useState } from 'react'; import { Outlet, Link, useLocation, useNavigate } from 'react-router-dom';
import { LayoutDashboard, Wallet, ArrowLeftRight, Receipt, CreditCard, PiggyBank, FileCheck, Bell, HelpCircle, Settings, ShieldAlert, LogOut, Menu, X, User as UserIcon } from 'lucide-react';
import { useAuth } from '../contexts/AuthContext';
export const DashboardLayout: React.FC = () => {
  const { user, logout, hasRole } = useAuth(); const location = useLocation(); const navigate = useNavigate(); const [isOpen, setIsOpen] = useState(false);
  const items = [
    { name: 'Dashboard', href: '/dashboard', icon: LayoutDashboard }, { name: 'Accounts', href: '/accounts', icon: Wallet },
    { name: 'Transfers', href: '/transfers', icon: ArrowLeftRight }, { name: 'Bill Payments', href: '/bills', icon: Receipt },
    { name: 'Cards', href: '/cards', icon: CreditCard }, { name: 'Loans & Credit', href: '/loans', icon: PiggyBank },
    { name: 'KYC & Verification', href: '/kyc', icon: FileCheck }, { name: 'Notifications', href: '/notifications', icon: Bell },
    { name: 'Support', href: '/support', icon: HelpCircle }, { name: 'Profile & Security', href: '/profile', icon: Settings },
  ];
  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 flex flex-col md:flex-row">
      <div className="md:hidden flex items-center justify-between p-4 border-b border-slate-800 bg-slate-900/90">
        <span className="font-bold text-lg text-white">NeoBank</span>
        <button onClick={() => setIsOpen(!isOpen)}>{isOpen ? <X /> : <Menu />}</button>
      </div>
      <aside className={`fixed md:sticky top-0 z-30 h-screen w-64 bg-slate-900 border-r border-slate-800 flex flex-col justify-between ${isOpen ? 'translate-x-0' : '-translate-x-full md:translate-x-0'}`}>
        <div>
          <div className="h-16 px-6 flex items-center gap-3 border-b border-slate-800">
            <span className="font-bold text-lg text-white">NeoBank Enterprise</span>
          </div>
          <nav className="p-4 space-y-1">
            {items.map((i) => {
              const Icon = i.icon;
              return <Link key={i.name} to={i.href} className="flex items-center gap-3 px-3 py-2 rounded-lg text-sm text-slate-300 hover:bg-slate-800"><Icon className="w-4 h-4" />{i.name}</Link>;
            })}
            {hasRole('ADMIN') && <Link to="/admin" className="flex items-center gap-3 px-3 py-2 rounded-lg text-sm text-amber-400 hover:bg-slate-800"><ShieldAlert className="w-4 h-4" />Admin Portal</Link>}
          </nav>
        </div>
        <div className="p-4 border-t border-slate-800 flex items-center justify-between">
          <span className="text-xs text-slate-300 truncate">{user?.email}</span>
          <button onClick={() => { logout(); navigate('/login'); }} className="p-1 text-slate-400 hover:text-rose-400"><LogOut className="w-4 h-4" /></button>
        </div>
      </aside>
      <main className="flex-1 p-6 max-w-7xl mx-auto w-full"><Outlet /></main>
    </div>
  );
};

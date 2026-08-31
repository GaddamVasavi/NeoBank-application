import React from 'react';
import { Outlet, Link } from 'react-router-dom';
import { ShieldCheck, ArrowRight } from 'lucide-react';
import { Button } from '../components/ui/Button';
export const PublicLayout: React.FC = () => {
  return (
    <div className="min-h-screen flex flex-col bg-slate-950">
      <header className="border-b border-slate-800/80 bg-slate-950/70 backdrop-blur-md sticky top-0 z-40">
        <div className="max-w-7xl mx-auto px-4 h-16 flex items-center justify-between">
          <Link to="/" className="flex items-center gap-2.5">
            <div className="w-9 h-9 rounded-xl bg-gradient-to-tr from-brand-600 to-indigo-500 flex items-center justify-center shadow-lg shadow-brand-600/30">
              <ShieldCheck className="w-5 h-5 text-white" />
            </div>
            <span className="text-xl font-bold tracking-tight bg-gradient-to-r from-white via-slate-200 to-brand-400 bg-clip-text text-transparent">NeoBank</span>
          </Link>
          <div className="flex items-center gap-3">
            <Link to="/login"><Button variant="ghost" size="sm">Sign In</Button></Link>
            <Link to="/register"><Button variant="primary" size="sm" icon={<ArrowRight className="w-3.5 h-3.5" />}>Open Account</Button></Link>
          </div>
        </div>
      </header>
      <main className="flex-1 flex flex-col"><Outlet /></main>
      <footer className="border-t border-slate-900 bg-slate-950 py-8 text-center text-xs text-slate-500">© 2026 NeoBank Digital Banking</footer>
    </div>
  );
};

import React from 'react'; import { Link } from 'react-router-dom'; import { Button } from '../../components/ui/Button'; import { Zap, ArrowRight } from 'lucide-react';
export const LandingPage: React.FC = () => (
  <div className="min-h-screen bg-slate-950 text-white flex flex-col justify-between">
    <header className="border-b border-slate-800/80 px-8 py-4 flex items-center justify-between">
      <div className="flex items-center space-x-3"><div className="w-9 h-9 rounded-lg bg-emerald-500 flex items-center justify-center font-bold text-slate-950 text-xl">F</div><span className="text-xl font-bold tracking-tight text-white">Fin<span className="text-emerald-400">Verse</span></span></div>
      <div className="flex items-center space-x-4"><Link to="/login"><Button variant="ghost">Sign In</Button></Link><Link to="/register"><Button>Get Started</Button></Link></div>
    </header>
    <main className="max-w-6xl mx-auto px-6 py-20 text-center space-y-8">
      <div className="inline-flex items-center px-4 py-1.5 rounded-full bg-emerald-500/10 border border-emerald-500/30 text-emerald-400 text-sm font-medium"><Zap className="w-4 h-4 mr-2" /> Integrated Multi-Tenant Financial Services SaaS</div>
      <h1 className="text-5xl md:text-7xl font-extrabold tracking-tight leading-tight">Enterprise Banking & Finance <br /><span className="text-transparent bg-clip-text bg-gradient-to-r from-emerald-400 to-teal-200">Reimagined</span></h1>
      <p className="max-w-2xl mx-auto text-slate-400 text-lg">Unified double-entry ledger, multi-currency accounts, real-time payments, subscriptions, lending, fraud prevention, and institutional treasury operations.</p>
      <div className="flex justify-center space-x-4 pt-4"><Link to="/register"><Button size="lg" icon={<ArrowRight className="w-5 h-5" />}>Open Corporate Account</Button></Link><Link to="/login"><Button size="lg" variant="secondary">Launch Sandbox</Button></Link></div>
    </main>
    <footer className="border-t border-slate-800/80 px-8 py-6 text-center text-xs text-slate-500">© 2026 FinVerse Global Financial Services SaaS. Multi-tenant architecture with cryptographic audit trails.</footer>
  </div>
);

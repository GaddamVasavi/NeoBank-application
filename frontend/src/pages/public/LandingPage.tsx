import React from 'react'; import { Link } from 'react-router-dom'; import { ShieldCheck, ArrowRight } from 'lucide-react'; import { Button } from '../../components/ui/Button';
export const LandingPage: React.FC = () => {
  return (
    <div className="flex-1 flex flex-col justify-center text-center max-w-4xl mx-auto px-4 py-20">
      <h1 className="text-5xl font-extrabold text-white mb-6">Banking Engineered for the Digital Age</h1>
      <p className="text-lg text-slate-400 mb-8">Full-featured digital banking platform with multi-factor authentication, accounts, transfers, loans, and automated fraud prevention.</p>
      <div className="flex justify-center gap-4">
        <Link to="/register"><Button size="lg" icon={<ArrowRight className="w-4 h-4" />}>Open Account</Button></Link>
        <Link to="/login"><Button size="lg" variant="outline">Sign In</Button></Link>
      </div>
    </div>
  );
};

import React, { useEffect, useState } from 'react';
import { Card } from '../../components/ui/Card';
import { Badge } from '../../components/ui/Badge';
import { Button } from '../../components/ui/Button';
import { bankingApi } from '../../api/bankingApi';
import { Account } from '../../types/account';
import { Transaction } from '../../types/transaction';
import { ArrowUpRight, ArrowDownLeft, Wallet, CreditCard, ShieldCheck, Plus, ArrowRight } from 'lucide-react';
import { Link } from 'react-router-dom';

export const DashboardPage: React.FC = () => {
  const [accounts, setAccounts] = useState<Account[]>([]);
  const [recentTx, setRecentTx] = useState<Transaction[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const load = async () => {
      try {
        const accRes = await bankingApi.getAccounts();
        if (accRes.success && accRes.data) {
          setAccounts(accRes.data);
          if (accRes.data.length > 0) {
            const txRes = await bankingApi.getRecentTransactions(accRes.data[0].id);
            if (txRes.success) setRecentTx(txRes.data);
          }
        }
      } catch (e) {
      } finally {
        setLoading(false);
      }
    };
    load();
  }, []);

  const totalBalance = accounts.reduce((acc, a) => acc + (a.balance || 0), 0);

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-2xl font-bold text-white">Financial Overview</h1>
          <p className="text-xs text-slate-400 mt-1">Welcome back to your secure banking control center</p>
        </div>
        <div className="flex gap-3">
          <Link to="/transfers"><Button size="sm" icon={<ArrowUpRight className="w-4 h-4" />}>Send Money</Button></Link>
          <Link to="/accounts"><Button variant="outline" size="sm" icon={<Plus className="w-4 h-4" />}>New Account</Button></Link>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-5">
        <Card className="bg-gradient-to-br from-indigo-900/40 via-slate-900 to-slate-900 border-indigo-500/20">
          <span className="text-xs font-medium text-indigo-300">Total Net Worth</span>
          <h2 className="text-3xl font-extrabold text-white mt-2">${totalBalance.toLocaleString('en-US', { minimumFractionDigits: 2 })}</h2>
          <span className="text-xs text-emerald-400 flex items-center gap-1 mt-2">+4.25% APY active</span>
        </Card>
        <Card>
          <span className="text-xs text-slate-400">Active Accounts</span>
          <h2 className="text-2xl font-bold text-white mt-2">{accounts.length} Accounts</h2>
          <p className="text-xs text-slate-400 mt-2">Savings & Checking</p>
        </Card>
        <Card>
          <span className="text-xs text-slate-400">Security Status</span>
          <div className="flex items-center gap-2 mt-2">
            <Badge variant="success">MFA Protected</Badge>
          </div>
          <p className="text-xs text-slate-400 mt-2">Zero fraud alerts</p>
        </Card>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 space-y-4">
          <Card title="Recent Activity" subtitle="Latest transactions across your active accounts" action={<Link to="/transactions" className="text-xs text-brand-400 hover:underline flex items-center gap-1">View All <ArrowRight className="w-3 h-3" /></Link>}>
            {recentTx.length === 0 ? (
              <p className="text-sm text-slate-400 py-6 text-center">No recent transactions</p>
            ) : (
              <div className="divide-y divide-slate-800">
                {recentTx.map((tx) => (
                  <div key={tx.id} className="py-3 flex items-center justify-between">
                    <div className="flex items-center gap-3">
                      <div className={`p-2 rounded-lg ${tx.amount < 0 ? 'bg-rose-500/10 text-rose-400' : 'bg-emerald-500/10 text-emerald-400'}`}>
                        {tx.amount < 0 ? <ArrowUpRight className="w-4 h-4" /> : <ArrowDownLeft className="w-4 h-4" />}
                      </div>
                      <div>
                        <p className="text-sm font-medium text-slate-200">{tx.description}</p>
                        <p className="text-xs text-slate-500">{new Date(tx.transactionDate).toLocaleDateString()}</p>
                      </div>
                    </div>
                    <span className={`text-sm font-bold ${tx.amount < 0 ? 'text-slate-200' : 'text-emerald-400'}`}>
                      {tx.amount < 0 ? '-' : '+'}${Math.abs(tx.amount).toFixed(2)}
                    </span>
                  </div>
                ))}
              </div>
            )}
          </Card>
        </div>
        <div>
          <Card title="Quick Transfer">
            <div className="space-y-3">
              <p className="text-xs text-slate-400">Fast transfers to your registered beneficiaries</p>
              <Link to="/transfers"><Button className="w-full">Make a Transfer</Button></Link>
            </div>
          </Card>
        </div>
      </div>
    </div>
  );
};

import React from 'react';
import { clsx } from 'clsx';
import { twMerge } from 'tailwind-merge';
export interface BadgeProps { children: React.ReactNode; variant?: 'success' | 'warning' | 'danger' | 'info' | 'neutral'; size?: 'sm' | 'md'; className?: string; }
export const Badge: React.FC<BadgeProps> = ({ children, variant = 'neutral', size = 'md', className }) => {
  const variants = {
    success: 'bg-emerald-500/10 text-emerald-400 border border-emerald-500/20',
    warning: 'bg-amber-500/10 text-amber-400 border border-amber-500/20',
    danger: 'bg-rose-500/10 text-rose-400 border border-rose-500/20',
    info: 'bg-sky-500/10 text-sky-400 border border-sky-500/20',
    neutral: 'bg-slate-800 text-slate-300 border border-slate-700',
  };
  const sizes = { sm: 'text-[10px] px-2 py-0.5 rounded-full', md: 'text-xs px-2.5 py-1 rounded-full font-semibold' };
  return <span className={twMerge(clsx('inline-flex items-center gap-1', variants[variant], sizes[size], className))}>{children}</span>;
};

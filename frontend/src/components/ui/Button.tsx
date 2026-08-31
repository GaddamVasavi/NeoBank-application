import React, { ButtonHTMLAttributes } from 'react';
import { clsx } from 'clsx';
import { twMerge } from 'tailwind-merge';
import { Loader2 } from 'lucide-react';
export interface ButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: 'primary' | 'secondary' | 'danger' | 'ghost' | 'outline';
  size?: 'sm' | 'md' | 'lg';
  isLoading?: boolean;
  icon?: React.ReactNode;
}
export const Button: React.FC<ButtonProps> = ({ children, variant = 'primary', size = 'md', isLoading = false, disabled, icon, className, ...props }) => {
  const base = 'inline-flex items-center justify-center font-medium rounded-lg transition-all focus:outline-none disabled:opacity-50';
  const variants = {
    primary: 'bg-brand-600 hover:bg-brand-500 text-white shadow-lg shadow-brand-600/30 border border-brand-500/30',
    secondary: 'bg-slate-800 hover:bg-slate-700 text-slate-200 border border-slate-700',
    danger: 'bg-rose-600 hover:bg-rose-500 text-white shadow-lg shadow-rose-600/30',
    ghost: 'hover:bg-slate-800/80 text-slate-300 hover:text-white',
    outline: 'border border-slate-600 hover:border-slate-400 text-slate-200 hover:bg-slate-800/40',
  };
  const sizes = { sm: 'text-xs px-3 py-1.5 gap-1.5', md: 'text-sm px-4 py-2 gap-2', lg: 'text-base px-6 py-3 gap-2.5' };
  return (
    <button className={twMerge(clsx(base, variants[variant], sizes[size], className))} disabled={disabled || isLoading} {...props}>
      {isLoading ? <Loader2 className="w-4 h-4 animate-spin" /> : icon}
      {children}
    </button>
  );
};

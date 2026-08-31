import React from 'react';
export interface ButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: 'primary' | 'secondary' | 'outline' | 'danger' | 'ghost';
  size?: 'sm' | 'md' | 'lg';
  icon?: React.ReactNode;
}
export const Button: React.FC<ButtonProps> = ({ children, variant = 'primary', size = 'md', icon, className = '', ...props }) => {
  const base = 'inline-flex items-center justify-center font-medium rounded-lg transition focus:outline-none disabled:opacity-50';
  const variants = {
    primary: 'bg-emerald-600 hover:bg-emerald-500 text-white shadow-lg shadow-emerald-900/30',
    secondary: 'bg-slate-800 hover:bg-slate-700 text-slate-200 border border-slate-700',
    outline: 'border border-emerald-500 text-emerald-400 hover:bg-emerald-950/40',
    danger: 'bg-rose-600 hover:bg-rose-500 text-white',
    ghost: 'text-slate-400 hover:text-white hover:bg-slate-800/50'
  };
  const sizes = { sm: 'px-3 py-1.5 text-xs', md: 'px-4 py-2 text-sm', lg: 'px-6 py-3 text-base' };
  return <button className={`${base} ${variants[variant]} ${sizes[size]} ${className}`} {...props}>{icon && <span className="mr-2">{icon}</span>}{children}</button>;
};

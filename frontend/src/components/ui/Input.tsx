import React from 'react';
export interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> { label?: string; error?: string; }
export const Input: React.FC<InputProps> = ({ label, error, className = '', ...props }) => (
  <div className="w-full space-y-1">
    {label && <label className="block text-xs font-medium text-slate-300">{label}</label>}
    <input className={`w-full px-3 py-2 bg-slate-900 border border-slate-800 rounded-lg text-white text-sm focus:border-emerald-500 focus:outline-none transition ${className}`} {...props} />
    {error && <p className="text-xs text-rose-400">{error}</p>}
  </div>
);

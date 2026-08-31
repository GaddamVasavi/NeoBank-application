import React, { InputHTMLAttributes, forwardRef } from 'react';
import { clsx } from 'clsx';
import { twMerge } from 'tailwind-merge';
export interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
  label?: string; error?: string; helperText?: string; leftIcon?: React.ReactNode; rightIcon?: React.ReactNode;
}
export const Input = forwardRef<HTMLInputElement, InputProps>(({ label, error, helperText, leftIcon, rightIcon, className, id, ...props }, ref) => {
  const inputId = id || (label ? label.toLowerCase().replace(/\s+/g, '-') : undefined);
  return (
    <div className="w-full">
      {label && <label htmlFor={inputId} className="block text-xs font-medium text-slate-300 mb-1.5">{label}</label>}
      <div className="relative rounded-lg shadow-sm">
        {leftIcon && <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none text-slate-400">{leftIcon}</div>}
        <input ref={ref} id={inputId} className={twMerge(clsx('block w-full rounded-lg bg-slate-900 border text-slate-100 text-sm py-2.5 focus:outline-none transition-all', leftIcon ? 'pl-10' : 'pl-3.5', rightIcon ? 'pr-10' : 'pr-3.5', error ? 'border-rose-500 focus:ring-rose-500' : 'border-slate-800 focus:border-brand-500', className))} {...props} />
        {rightIcon && <div className="absolute inset-y-0 right-0 pr-3 flex items-center text-slate-400">{rightIcon}</div>}
      </div>
      {error && <p className="mt-1 text-xs text-rose-400">{error}</p>}
      {helperText && !error && <p className="mt-1 text-xs text-slate-400">{helperText}</p>}
    </div>
  );
});
Input.displayName = 'Input';

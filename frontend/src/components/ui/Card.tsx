import React from 'react';
export interface CardProps { title?: string; subtitle?: string; children: React.ReactNode; className?: string; }
export const Card: React.FC<CardProps> = ({ title, subtitle, children, className = '' }) => (
  <div className={`bg-slate-900/80 border border-slate-800/80 rounded-xl p-5 shadow-xl backdrop-blur-sm ${className}`}>
    {(title || subtitle) && (
      <div className="mb-4">
        {title && <h3 className="text-lg font-semibold text-white">{title}</h3>}
        {subtitle && <p className="text-xs text-slate-400 mt-0.5">{subtitle}</p>}
      </div>
    )}
    {children}
  </div>
);

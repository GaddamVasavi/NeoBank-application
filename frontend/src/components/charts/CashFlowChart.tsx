import React from 'react';
import { ResponsiveContainer, BarChart, Bar, XAxis, YAxis, Tooltip, Legend } from 'recharts';
import { CashFlowData } from '../../types/admin';

export const CashFlowChart: React.FC<{ data: CashFlowData[] }> = ({ data }) => {
  return (
    <div className="h-72 w-full">
      <ResponsiveContainer width="100%" height="100%">
        <BarChart data={data}>
          <XAxis dataKey="month" stroke="#64748b" fontSize={12} />
          <YAxis stroke="#64748b" fontSize={12} tickFormatter={(val) => `$${val}`} />
          <Tooltip contentStyle={{ backgroundColor: '#0f172a', borderColor: '#334155', borderRadius: '8px' }} />
          <Legend />
          <Bar dataKey="income" fill="#10b981" name="Inflow ($)" radius={[4, 4, 0, 0]} />
          <Bar dataKey="expense" fill="#f43f5e" name="Outflow ($)" radius={[4, 4, 0, 0]} />
        </BarChart>
      </ResponsiveContainer>
    </div>
  );
};

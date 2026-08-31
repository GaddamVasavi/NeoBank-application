import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Badge } from '../../components/ui/Badge'; import { productsApi } from '../../api/productsApi'; import { AppNotification } from '../../types/notification'; import { Bell, Check } from 'lucide-react';
export const NotificationsPage: React.FC = () => {
  const [notifications, setNotifications] = useState<AppNotification[]>([]);
  const load = async () => { const res = await productsApi.getNotifications(); if (res.success) setNotifications(res.data); };
  useEffect(() => { load(); }, []);
  const markRead = async (id: string) => { await productsApi.markNotificationRead(id); load(); };
  return (
    <div className="space-y-6 max-w-2xl">
      <h1 className="text-2xl font-bold text-white">Notifications & Alerts</h1>
      <Card>
        {notifications.length === 0 ? <p className="text-sm text-slate-400 py-8 text-center">You're all caught up!</p> : (
          <div className="divide-y divide-slate-800">{notifications.map(n => (
            <div key={n.id} className={`py-4 flex justify-between items-start ${n.read ? 'opacity-60' : ''}`}><div><h4 className="text-sm font-bold text-white">{n.title}</h4><p className="text-xs text-slate-300 mt-1">{n.message}</p><span className="text-[10px] text-slate-500 mt-2 block">{new Date(n.createdAt).toLocaleString()}</span></div>{!n.read && <button onClick={() => markRead(n.id)} className="p-1 text-slate-400 hover:text-emerald-400"><Check className="w-4 h-4" /></button>}</div>
          ))}</div>
        )}
      </Card>
    </div>
  );
};

import React, { useEffect, useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Button } from '../../components/ui/Button'; import { Badge } from '../../components/ui/Badge'; import { productsApi } from '../../api/productsApi'; import { KycDocument } from '../../types/kyc'; import { FileCheck, UploadCloud, ShieldCheck } from 'lucide-react';
export const KycPage: React.FC = () => {
  const [docs, setDocs] = useState<KycDocument[]>([]); const [docType, setDocType] = useState('PASSPORT'); const [docNum, setDocNum] = useState(''); const [fileName, setFileName] = useState(''); const [msg, setMsg] = useState('');
  const load = async () => { const res = await productsApi.getKycDocuments(); if (res.success) setDocs(res.data); };
  useEffect(() => { load(); }, []);
  const handleUpload = async (e: React.FormEvent) => {
    e.preventDefault();
    await productsApi.uploadKyc(docType, fileName || 'identity_document.pdf', docNum);
    setMsg('Document uploaded for automated compliance check!');
    load();
  };
  return (
    <div className="space-y-6 max-w-2xl">
      <h1 className="text-2xl font-bold text-white">KYC & Identity Verification</h1>
      {msg && <div className="p-3 rounded bg-emerald-500/10 text-emerald-400 text-sm">{msg}</div>}
      <Card title="Submit Identification Document">
        <form onSubmit={handleUpload} className="space-y-4">
          <div><label className="block text-xs text-slate-400 mb-1">Document Type</label><select value={docType} onChange={e => setDocType(e.target.value)} className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm"><option value="PASSPORT">International Passport</option><option value="DRIVERS_LICENSE">Driver's License</option><option value="NATIONAL_ID">National Identity Card</option><option value="UTILITY_BILL">Utility Bill (Proof of Address)</option></select></div>
          <div><label className="block text-xs text-slate-400 mb-1">Document Number</label><input type="text" value={docNum} onChange={e => setDocNum(e.target.value)} placeholder="e.g. A12345678" className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm" required /></div>
          <div><label className="block text-xs text-slate-400 mb-1">File Name</label><input type="text" value={fileName} onChange={e => setFileName(e.target.value)} placeholder="passport_scan.pdf" className="w-full p-2 bg-slate-900 border border-slate-800 rounded text-slate-100 text-sm" required /></div>
          <Button type="submit" className="w-full" icon={<UploadCloud className="w-4 h-4" />}>Submit Document</Button>
        </form>
      </Card>
      <Card title="Verification Status">
        {docs.length === 0 ? <p className="text-sm text-slate-400 py-4 text-center">No documents submitted yet</p> : (
          <div className="divide-y divide-slate-800">{docs.map(d => (
            <div key={d.id} className="py-3 flex justify-between items-center"><div><p className="text-sm font-semibold text-white">{d.documentType}</p><p className="text-xs text-slate-400">{d.fileName}</p></div><Badge variant={d.status === 'VERIFIED' ? 'success' : d.status === 'PENDING' ? 'warning' : 'danger'}>{d.status}</Badge></div>
          ))}</div>
        )}
      </Card>
    </div>
  );
};

import React, { useState } from 'react'; import { Card } from '../../components/ui/Card'; import { Input } from '../../components/ui/Input'; import { Button } from '../../components/ui/Button'; import { useAuth } from '../../contexts/AuthContext'; import { userApi } from '../../api/userApi';
export const ProfilePage: React.FC = () => {
  const { user, refreshUser } = useAuth(); const [name, setName] = useState(user?.profile?.firstName || '');
  const handleSave = async () => { await userApi.updateProfile({ firstName: name }); await refreshUser(); };
  return (
    <div className="space-y-6 max-w-xl">
      <h1 className="text-2xl font-bold text-white">Account Profile</h1>
      <Card title="Personal Details">
        <div className="space-y-4">
          <Input label="First Name" value={name} onChange={(e) => setName(e.target.value)} />
          <Input label="Email" value={user?.email || ''} disabled />
          <Button onClick={handleSave}>Save Changes</Button>
        </div>
      </Card>
    </div>
  );
};

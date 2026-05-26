import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../api/axios';
import { useAuth } from '../context/AuthContext';
import ChatWindow from '../components/ChatWindow';

export default function HomePage() {
  const { user, logout } = useAuth();
  const [users, setUsers] = useState([]);
  const [activeConversation, setActiveConversation] = useState(null);
  const [activeUser, setActiveUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    api.get('/users').then(res => setUsers(res.data));
  }, []);

  useEffect(() => {
    if (!activeConversation && user && users.length) {
      const firstContact = users.find(u => u.id !== user.userId);
      if (firstContact) {
        openChat(firstContact);
      }
    }
  }, [users, user]);

  const openChat = async (otherUser) => {
    const res = await api.get(`/conversations/between/${user.userId}/${otherUser.id}`);
    setActiveConversation(res.data);
    setActiveUser(otherUser);
  };

  return (
    <div className="flex h-screen bg-gray-100 font-sans">

      {/* LEFT SIDEBAR */}
      <div className="w-80 bg-white flex flex-col border-r border-gray-200 shadow-sm">

        {/* Header */}
        <div className="bg-green-700 text-white px-4 py-3 flex items-center justify-between">
          <div className="flex items-center gap-3">
            <img
              src={user?.profilePic || '/default-avatar.png'}
              className="w-9 h-9 rounded-full object-cover cursor-pointer"
              onClick={() => navigate(`/profile/${user.userId}`)}
              alt="You"
            />
            <div>
              <p className="font-semibold text-sm">{user?.fullName}</p>
              <p className="text-xs text-green-200 capitalize">{user?.role?.toLowerCase()}</p>
            </div>
          </div>
          <button onClick={logout} className="text-xs text-green-200 hover:text-white">Logout</button>
        </div>

        {/* Search bar */}
        <div className="px-3 py-2 bg-gray-50 border-b">
          <input
            placeholder="Search users..."
            className="w-full bg-white border rounded-full px-4 py-1.5 text-sm focus:outline-none focus:ring-1 focus:ring-green-400"
          />
        </div>

        {/* Users list */}
        <div className="overflow-y-auto flex-1">
          {users
            .filter(u => u.id !== user.userId)
            .map(u => (
              <div
                key={u.id}
                onClick={() => openChat(u)}
                className={`flex items-center gap-3 px-4 py-3 cursor-pointer hover:bg-gray-50 border-b border-gray-100
                  ${activeUser?.id === u.id ? 'bg-green-50 border-l-4 border-l-green-500' : ''}`}
              >
                <img
                  src={u.profilePic || '/default-avatar.png'}
                  className="w-11 h-11 rounded-full object-cover"
                  alt={u.fullName}
                />
                <div className="flex-1 min-w-0">
                  <p className="font-medium text-sm text-gray-800 truncate">{u.fullName}</p>
                  <p className="text-xs text-green-600 font-medium">{u.status}</p>
                </div>
              </div>
            ))}
        </div>
      </div>

      {/* RIGHT PANEL */}
      <div className="flex-1 flex flex-col">
        {activeConversation ? (
          <ChatWindow
            conversation={activeConversation}
            currentUser={user}
            otherUser={activeUser}
          />
        ) : (
          <div className="flex-1 flex flex-col items-center justify-center text-gray-400">
            <span className="text-6xl mb-4">🌾</span>
            <p className="text-xl font-medium">Welcome to Farmer's Hub</p>
            <p className="text-sm mt-2">Select a contact to start chatting</p>
          </div>
        )}
      </div>
    </div>
  );
}
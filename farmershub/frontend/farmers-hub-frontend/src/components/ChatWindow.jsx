import { useEffect, useRef, useState } from 'react';
import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import api from '../api/axios';
import { useNavigate } from 'react-router-dom';

export default function ChatWindow({ conversation, currentUser, otherUser }) {
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState('');
  const stompRef = useRef(null);
  const bottomRef = useRef(null);
  const navigate = useNavigate();

  // Load existing messages when conversation changes
  useEffect(() => {
    api.get(`/conversations/${conversation.id}/messages`)
      .then(res => setMessages(res.data));
  }, [conversation.id]);

  // Connect to WebSocket
  useEffect(() => {
    const client = new Client({
      webSocketFactory: () => new SockJS('http://localhost:8080/ws'),
      onConnect: () => {
        // Listen for new messages in this conversation
        client.subscribe(`/topic/conversation/${conversation.id}`, (msg) => {
          const newMsg = JSON.parse(msg.body);
          setMessages(prev => [...prev, newMsg]);
        });
      },
    });

    client.activate();
    stompRef.current = client;

    return () => client.deactivate(); // Disconnect when component unmounts
  }, [conversation.id]);

  // Auto-scroll to bottom when new message arrives
  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [messages]);

  const sendMessage = () => {
    if (!input.trim() || !stompRef.current) return;

    stompRef.current.publish({
      destination: '/app/chat.send',
      body: JSON.stringify({
        conversationId: conversation.id,
        senderId: currentUser.userId,
        content: input.trim(),
      }),
    });

    setInput('');
  };

  const handleKeyDown = (e) => {
    if (e.key === 'Enter' && !e.shiftKey) {
      e.preventDefault();
      sendMessage();
    }
  };

  return (
    <div className="flex flex-col h-full">
      {/* Chat header */}
      <div className="bg-green-700 text-white px-4 py-3 flex items-center gap-3 shadow">
        <img
          src={otherUser.profilePic || '/default-avatar.png'}
          className="w-10 h-10 rounded-full object-cover cursor-pointer"
          onClick={() => navigate(`/profile/${otherUser.id}`)}
          alt={otherUser.fullName}
        />
        <div>
          <p className="font-semibold">{otherUser.fullName}</p>
          <p className="text-xs text-green-200">{otherUser.status}</p>
        </div>
      </div>

      {/* Messages */}
      <div
        className="flex-1 overflow-y-auto p-4 space-y-2 bg-gradient-to-br from-green-50 via-white to-green-100"
      >
        {messages.map((msg, i) => {
          const isMine = msg.sender?.id === currentUser.userId ||
            msg.senderId === currentUser.userId;
          return (
            <div key={i} className={`flex ${isMine ? 'justify-end' : 'justify-start'}`}>
              <div className={`max-w-xs px-4 py-2 rounded-2xl text-sm shadow-sm
                ${isMine
                  ? 'bg-green-500 text-white rounded-br-sm'
                  : 'bg-white text-gray-800 rounded-bl-sm'}`}
              >
                <p>{msg.content}</p>
                <p className={`text-xs mt-1 ${isMine ? 'text-green-100' : 'text-gray-400'}`}>
                  {new Date(msg.sentAt).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}
                </p>
              </div>
            </div>
          );
        })}
        <div ref={bottomRef} />
      </div>

      {/* Input */}
      <div className="bg-white border-t px-4 py-3 flex items-center gap-3">
        <input
          value={input}
          onChange={e => setInput(e.target.value)}
          onKeyDown={handleKeyDown}
          placeholder="Type a message..."
          className="flex-1 border rounded-full px-4 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-green-400"
        />
        <button
          onClick={sendMessage}
          className="bg-green-600 hover:bg-green-700 text-white p-2 rounded-full w-10 h-10 flex items-center justify-center"
        >
          ➤
        </button>
      </div>
    </div>
  );
}
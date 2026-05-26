import { useEffect, useRef, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import api from '../api/axios';
import { useAuth } from '../context/AuthContext';

export default function ProfilePage() {
  const { userId } = useParams();
  const { user: currentUser } = useAuth();
  const [profile, setProfile] = useState(null);
  const [posts, setPosts] = useState([]);
  const [caption, setCaption] = useState('');
  const fileRef = useRef();
  const navigate = useNavigate();

  const isOwnProfile = currentUser?.userId == userId;

  useEffect(() => {
    api.get(`/users/${userId}`).then(res => setProfile(res.data));
    api.get(`/posts/user/${userId}`).then(res => setPosts(res.data));
  }, [userId]);

  const handleProfilePicUpload = async (e) => {
    const file = e.target.files[0];
    if (!file) return;
    const form = new FormData();
    form.append('file', file);
    const res = await api.post(`/users/${userId}/profile-pic`, form, {
      headers: { 'Content-Type': 'multipart/form-data' },
    });
    setProfile(res.data);
  };

  const handlePostUpload = async (e) => {
    const file = e.target.files[0];
    if (!file) return;
    const form = new FormData();
    form.append('userId', userId);
    form.append('image', file);
    form.append('caption', caption);
    const res = await api.post('/posts', form, {
      headers: { 'Content-Type': 'multipart/form-data' },
    });
    setPosts(prev => [res.data, ...prev]);
    setCaption('');
  };

  if (!profile) return <div className="flex items-center justify-center h-screen">Loading...</div>;

  return (
    <div className="min-h-screen bg-gray-50">
      {/* Back button */}
      <div className="bg-green-700 text-white px-4 py-3 flex items-center gap-3">
        <button onClick={() => navigate('/')} className="hover:underline text-sm">← Back</button>
        <p className="font-semibold">{isOwnProfile ? 'My Profile' : profile.fullName}</p>
      </div>

      <div className="max-w-2xl mx-auto py-8 px-4">
        {/* Profile card */}
        <div className="bg-white rounded-2xl shadow p-6 flex items-center gap-6 mb-6">
          <div className="relative">
            <img
              src={profile.profilePic || '/default-avatar.png'}
              className="w-20 h-20 rounded-full object-cover border-4 border-green-300"
              alt="Profile"
            />
            {isOwnProfile && (
              <>
                <button
                  onClick={() => fileRef.current.click()}
                  className="absolute bottom-0 right-0 bg-green-500 text-white rounded-full w-6 h-6 text-xs flex items-center justify-center"
                >
                  +
                </button>
                <input ref={fileRef} type="file" accept="image/*"
                  className="hidden" onChange={handleProfilePicUpload} />
              </>
            )}
          </div>

          <div>
            <h2 className="text-xl font-bold text-gray-800">{profile.fullName}</h2>
            <span className={`inline-block text-xs font-bold px-3 py-1 rounded-full mt-1
              ${profile.status === 'FARMER' ? 'bg-green-100 text-green-700' : 'bg-yellow-100 text-yellow-700'}`}>
              {profile.status}
            </span>
            {profile.bio && <p className="text-gray-500 text-sm mt-2">{profile.bio}</p>}
          </div>
        </div>

        {/* Post uploader (own profile only) */}
        {isOwnProfile && (
          <div className="bg-white rounded-2xl shadow p-4 mb-6">
            <p className="font-semibold text-gray-700 mb-3">📸 Share a Farm Photo</p>
            <input
              type="text"
              placeholder="Add a caption..."
              value={caption}
              onChange={e => setCaption(e.target.value)}
              className="w-full border rounded-lg px-3 py-2 text-sm mb-3 focus:outline-none focus:ring-2 focus:ring-green-400"
            />
            <label className="bg-green-600 text-white text-sm px-4 py-2 rounded-lg cursor-pointer hover:bg-green-700">
              Choose Photo
              <input type="file" accept="image/*" className="hidden" onChange={handlePostUpload} />
            </label>
          </div>
        )}

        {/* Posts grid */}
        <h3 className="font-bold text-gray-700 mb-3">
          {isOwnProfile ? 'My Farm Posts' : `${profile.fullName}'s Farm`}
        </h3>
        {posts.length === 0 ? (
          <p className="text-gray-400 text-sm">No posts yet.</p>
        ) : (
          <div className="grid grid-cols-2 gap-3">
            {posts.map(post => (
              <div key={post.id} className="bg-white rounded-xl overflow-hidden shadow">
                <img
                  src={`http://localhost:8080${post.imageUrl}`}
                  className="w-full h-40 object-cover"
                  alt={post.caption}
                />
                {post.caption && (
                  <p className="px-3 py-2 text-xs text-gray-600">{post.caption}</p>
                )}
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}
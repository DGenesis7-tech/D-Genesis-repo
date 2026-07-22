import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../api/axios';
import { useAuth } from '../context/AuthContext';
import ChatWindow from '../components/ChatWindow';
import PostCard from '../components/PostCard';

const categories = [
    { label: 'All', value: null },
    { label: 'Crops', value: 'CROPS' },
    { label: 'Livestock', value: 'LIVESTOCK' },
    { label: 'Vegetables', value: 'VEGETABLES' },
];

export default function MarketplacePage() {
    const { user, logout } = useAuth();
    const [posts, setPosts] = useState([]);
    const [page, setPage] = useState(0);
    const [hasMore, setHasMore] = useState(true);
    const [category, setCategory] = useState(null);
    const [selectedPost, setSelectedPost] = useState(null);
    const [orderQuantity, setOrderQuantity] = useState(1);
    const [activeConversation, setActiveConversation] = useState(null);
    const [activeUser, setActiveUser] = useState(null);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    const loadPosts = async (reset = false, pageStart = null) => {
        if (!user) return;
        const nextPage = pageStart !== null ? pageStart : reset ? 0 : page;
        setLoading(true);
        const query = new URLSearchParams({
            page: String(nextPage),
            size: '12',
            ...(category ? { category } : {}),
        }).toString();

        try {
            const res = await api.get(`/posts/feed?${query}`);
            const feed = res.data.content || [];
            setPosts(prev => (reset ? feed : [...prev, ...feed]));
            setHasMore(!res.data.last);
            setPage(nextPage + 1);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadPosts(true, 0);
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [category, user]);

    const openChat = async (otherUser) => {
        if (!user || !otherUser || otherUser.id === user.userId) return;
        const res = await api.get(`/conversations/between/${user.userId}/${otherUser.id}`);
        setActiveConversation(res.data);
        setActiveUser(otherUser);
    };

    const handleBuy = (post) => {
        setSelectedPost(post);
        setOrderQuantity(1);
    };

    const confirmOrder = async () => {
        if (!selectedPost) return;
        try {
            const res = await api.post('/posts/buy', {
                postId: selectedPost.id,
                quantity: Number(orderQuantity),
            });
            setPosts(prev => prev.map(post => post.id === res.data.id ? res.data : post));
            setSelectedPost(null);
            alert('Purchase successful! The farmer has been notified.');
        } catch (error) {
            const message = error?.response?.data?.message || 'Order failed';
            alert(message);
        }
    };

    const handleCategory = (value) => {
        setCategory(value);
        setPage(0);
        setHasMore(true);
        loadPosts(true, 0);
    };

    return (
        <div className="flex h-screen bg-gray-100 font-sans">
            <div className="w-80 bg-white flex flex-col border-r border-gray-200 shadow-sm overflow-hidden">
                <div className="bg-green-700 text-white px-5 py-4 flex items-center justify-between">
                    <div>
                        <p className="text-sm font-semibold">{user?.fullName || 'Farmer'}</p>
                        <p className="text-xs uppercase tracking-[0.25em] text-green-200">Marketplace</p>
                    </div>
                    <button onClick={logout} className="text-xs text-green-200 hover:text-white">Logout</button>
                </div>

                <div className="px-5 py-4 border-b border-gray-200">
                    <p className="text-xs uppercase tracking-[0.25em] text-gray-500 mb-2">Categories</p>
                    <div className="flex flex-wrap gap-2">
                        {categories.map(cat => (
                            <button
                                key={cat.label}
                                onClick={() => handleCategory(cat.value)}
                                className={`rounded-full px-3 py-2 text-xs font-semibold transition ${category === cat.value ? 'bg-green-600 text-white' : 'bg-gray-100 text-gray-700 hover:bg-gray-200'}`}
                            >
                                {cat.label}
                            </button>
                        ))}
                    </div>
                </div>

                <div className="p-5">
                    <div className="rounded-3xl bg-gradient-to-br from-green-50 to-white p-5 border border-gray-200">
                        <p className="text-xs uppercase tracking-[0.25em] text-green-600">Why Farmer's Hub</p>
                        <h2 className="mt-3 text-xl font-bold text-slate-900">Shoppable feed built for farmers.</h2>
                        <p className="mt-2 text-sm text-slate-600">Browse the freshest listings, buy direct, and chat with the farmer without leaving the page.</p>
                    </div>
                </div>
            </div>

            <div className="flex-1 flex flex-col overflow-hidden">
                <div className="px-6 py-5 border-b border-gray-200 bg-white">
                    <div className="flex items-center justify-between gap-4">
                        <div>
                            <p className="text-xs uppercase tracking-[0.3em] text-gray-500">Marketplace Feed</p>
                            <h1 className="text-3xl font-bold text-slate-900">Latest farm listings</h1>
                        </div>
                        <div className="text-sm text-slate-500">{posts.length} listings</div>
                    </div>
                </div>

                <div className="flex-1 overflow-hidden flex">
                    <div className="flex-1 overflow-y-auto px-6 py-6">
                        {posts.length === 0 && !loading ? (
                            <div className="rounded-3xl border border-dashed border-gray-300 bg-white p-12 text-center text-gray-500">
                                No marketplace posts yet. Add a listing from the farmer dashboard or come back later.
                            </div>
                        ) : (
                            <div className="grid gap-6 xl:grid-cols-2">
                                {posts.map(post => (
                                    <PostCard
                                        key={post.id}
                                        post={post}
                                        currentUser={user}
                                        onBuy={handleBuy}
                                        onChat={openChat}
                                    />
                                ))}
                            </div>
                        )}

                        {hasMore && (
                            <div className="mt-6 flex justify-center">
                                <button
                                    onClick={() => loadPosts()}
                                    disabled={loading}
                                    className="rounded-full bg-green-600 text-white px-6 py-3 font-semibold hover:bg-green-700 disabled:opacity-50"
                                >
                                    {loading ? 'Loading…' : 'Load more listings'}
                                </button>
                            </div>
                        )}
                    </div>

                    <aside className="w-96 border-l border-gray-200 bg-white hidden xl:flex flex-col">
                        {activeConversation ? (
                            <ChatWindow
                                conversation={activeConversation}
                                currentUser={user}
                                otherUser={activeUser}
                            />
                        ) : (
                            <div className="flex-1 p-8 flex flex-col justify-center items-center text-center text-slate-500">
                                <div className="rounded-3xl border border-dashed border-gray-300 bg-green-50 p-8">
                                    <p className="text-2xl mb-4">💬</p>
                                    <p className="text-lg font-semibold text-slate-900">Chat with farmers instantly</p>
                                    <p className="mt-3 text-sm">Click any listing’s chat button to open a direct conversation and continue the sale.</p>
                                </div>
                            </div>
                        )}
                    </aside>
                </div>
            </div>

            {selectedPost && (
                <div className="fixed inset-0 z-50 bg-black/40 flex items-center justify-center p-4">
                    <div className="w-full max-w-lg rounded-3xl bg-white shadow-2xl p-6">
                        <div className="flex items-center justify-between mb-4">
                            <div>
                                <p className="text-sm text-gray-500">Order</p>
                                <h2 className="text-2xl font-bold text-slate-900">{selectedPost.caption || 'Farm product'}</h2>
                                <p className="text-sm text-gray-500">Seller: {selectedPost.user?.fullName || 'Farmer'}</p>
                            </div>
                            <button onClick={() => setSelectedPost(null)} className="text-gray-400 hover:text-gray-700">✕</button>
                        </div>

                        <div className="grid gap-4">
                            <div className="rounded-3xl border border-gray-200 p-4 bg-slate-50">
                                <p className="text-sm text-slate-600">Price</p>
                                <p className="mt-2 text-3xl font-bold text-green-600">₦{selectedPost.price?.toLocaleString()}</p>
                            </div>
                            <div>
                                <label className="block text-sm font-semibold text-slate-700 mb-2">Quantity</label>
                                <input
                                    type="number"
                                    min="1"
                                    max={selectedPost.quantity || 1}
                                    value={orderQuantity}
                                    onChange={e => setOrderQuantity(Math.max(1, Number(e.target.value) || 1))}
                                    className="w-full rounded-3xl border border-gray-200 px-4 py-3 text-sm focus:outline-none focus:ring-2 focus:ring-green-400"
                                />
                                <p className="mt-2 text-xs text-gray-500">Available: {selectedPost.quantity || 0} {selectedPost.unit || 'units'}</p>
                            </div>
                        </div>

                        <div className="mt-6 flex justify-end gap-3">
                            <button onClick={() => setSelectedPost(null)} className="rounded-full border border-gray-300 px-6 py-3 text-sm font-semibold text-gray-700 hover:bg-gray-100">Cancel</button>
                            <button
                                onClick={confirmOrder}
                                className="rounded-full bg-green-600 px-6 py-3 text-sm font-semibold text-white hover:bg-green-700"
                            >
                                Confirm purchase
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

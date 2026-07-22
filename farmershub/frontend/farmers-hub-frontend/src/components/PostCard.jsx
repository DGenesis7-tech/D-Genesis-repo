export default function PostCard({ post, currentUser, onBuy, onChat }) {
    const isSoldOut = !post.available || (post.quantity !== null && post.quantity <= 0);
    const owner = post.user || {};
    const isMine = owner.id === currentUser?.userId;

    return (
        <div className="bg-white rounded-3xl shadow-sm border border-gray-200 overflow-hidden flex flex-col">
            <div className="relative overflow-hidden">
                <img
                    src={post.imageUrl || '/default-image.png'}
                    alt={post.caption || 'Farmer post'}
                    className="w-full h-64 object-cover"
                />
                <div className="absolute top-3 left-3 bg-white/90 text-xs font-semibold uppercase tracking-[0.2em] text-gray-700 px-3 py-1 rounded-full">
                    {post.category || 'General'}
                </div>
                {isSoldOut && (
                    <div className="absolute inset-0 bg-black/40 flex items-center justify-center text-white text-xl font-bold">
                        Sold Out
                    </div>
                )}
            </div>

            <div className="p-5 flex-1 flex flex-col">
                <div className="flex items-center justify-between gap-3 mb-3">
                    <div>
                        <p className="text-sm text-gray-500">{owner.fullName || 'Farmer'}</p>
                        <p className="font-semibold text-lg text-slate-900 truncate">{post.caption || 'Fresh farm produce'}</p>
                    </div>
                    <div className="text-right">
                        <p className="text-2xl font-bold text-green-600">₦{post.price?.toLocaleString() || '0'}</p>
                        <p className="text-xs text-gray-500">{post.unit || 'unit'}</p>
                    </div>
                </div>

                <div className="grid gap-2 text-sm text-gray-600 mb-4">
                    <div>{post.location || 'Unknown location'}</div>
                    <div>{post.quantity != null ? `${post.quantity} ${post.unit || 'items'} available` : 'Quantity not specified'}</div>
                </div>

                <div className="mt-auto flex flex-col gap-3">
                    <button
                        type="button"
                        onClick={() => onBuy(post)}
                        disabled={isSoldOut || isMine}
                        className={`rounded-full px-4 py-3 text-sm font-semibold transition ${isSoldOut || isMine ? 'bg-gray-300 text-gray-600 cursor-not-allowed' : 'bg-green-600 text-white hover:bg-green-700'}`}
                    >
                        {isMine ? 'Your listing' : isSoldOut ? 'Sold Out' : 'Buy now'}
                    </button>
                    <button
                        type="button"
                        onClick={() => onChat(post.user)}
                        disabled={isMine}
                        className={`rounded-full px-4 py-3 text-sm font-semibold transition ${isMine ? 'bg-gray-100 text-gray-500 cursor-not-allowed' : 'border border-green-600 text-green-600 hover:bg-green-50'}`}
                    >
                        Chat with farmer
                    </button>
                </div>
            </div>
        </div>
    );
}

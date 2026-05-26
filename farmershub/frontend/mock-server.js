import express from 'express';
import cors from 'cors';

const app = express();
app.use(cors());
app.use(express.json());

// Mock database
const users = [
    {
        userId: '1',
        fullName: 'John Farmer',
        email: 'john@farmers.com',
        role: 'FARMER',
        status: 'Online',
        profilePic: 'https://i.pravatar.cc/150?img=1',
    },
    {
        userId: '2',
        fullName: 'Jane Aspirant',
        email: 'jane@farmers.com',
        role: 'ASPIRANT',
        status: 'Offline',
        profilePic: 'https://i.pravatar.cc/150?img=2',
    },
];

const conversations = {};
const messages = {};

// Auth endpoints
app.post('/api/auth/register', (req, res) => {
    const { fullName, email, password, status } = req.body;

    // Check if user exists
    if (users.find(u => u.email === email)) {
        return res.status(400).json({ message: 'Email already registered' });
    }

    const newUser = {
        userId: String(users.length + 1),
        fullName,
        email,
        role: status || 'ASPIRANT',
        status: 'Online',
        profilePic: `https://i.pravatar.cc/150?img=${users.length + 1}`,
    };

    users.push(newUser);

    res.json({
        ...newUser,
        token: `mock-token-${newUser.userId}`,
    });
});

app.post('/api/auth/login', (req, res) => {
    const { email, password } = req.body;

    const user = users.find(u => u.email === email);
    if (!user) {
        return res.status(401).json({ message: 'Invalid email or password' });
    }

    res.json({
        ...user,
        token: `mock-token-${user.userId}`,
    });
});

// Users endpoints
app.get('/api/users', (req, res) => {
    res.json(users);
});

app.get('/api/users/:userId', (req, res) => {
    const user = users.find(u => u.userId === req.params.userId);
    if (!user) {
        return res.status(404).json({ message: 'User not found' });
    }
    res.json(user);
});

// Conversations endpoints
app.get('/api/conversations/between/:userId1/:userId2', (req, res) => {
    const { userId1, userId2 } = req.params;
    const key = `${userId1}-${userId2}`;

    if (!conversations[key]) {
        conversations[key] = {
            id: key,
            user1Id: userId1,
            user2Id: userId2,
        };
        messages[key] = [];
    }

    res.json(conversations[key]);
});

app.get('/api/conversations/:conversationId/messages', (req, res) => {
    const msgs = messages[req.params.conversationId] || [];
    res.json(msgs);
});

// Posts endpoints (for ProfilePage)
app.get('/api/posts/user/:userId', (req, res) => {
    res.json([]);
});

app.post('/api/posts', (req, res) => {
    const { userId, caption } = req.body;
    const post = {
        id: Date.now(),
        userId,
        caption,
        imageUrl: '/default-image.png',
    };
    res.json(post);
});

app.post('/api/users/:userId/profile-pic', (req, res) => {
    const user = users.find(u => u.userId === req.params.userId);
    if (user) {
        user.profilePic = `https://i.pravatar.cc/150?img=${Math.random()}`;
    }
    res.json(user);
});

const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Mock backend running on http://localhost:${PORT}`);
});

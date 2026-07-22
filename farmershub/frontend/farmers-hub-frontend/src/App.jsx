import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import LoginPage from './pages/LoginPage.jsx';
import RegisterPage from './pages/RegisterPage.jsx';
import MarketplacePage from './pages/MarketplacePage.jsx';
import ProfilePage from './pages/ProfilePage.jsx';

// Guard: redirect to login if not logged in
function PrivateRoute({ children }) {
  const { user } = useAuth();
  return user ? children : <Navigate to="/login" />;
}

export default function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/" element={
            <PrivateRoute><MarketplacePage /></PrivateRoute>
          } />
          <Route path="/chat" element={
            <PrivateRoute><MarketplacePage /></PrivateRoute>
          } />
          <Route path="/profile/:userId" element={
            <PrivateRoute><ProfilePage /></PrivateRoute>
          } />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}
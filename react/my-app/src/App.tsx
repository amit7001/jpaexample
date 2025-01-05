// src/App.tsx
import React from 'react';
import './App.css';
import { BrowserRouter as BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './components/Login.tsx';
import Signup from './components/Signup.tsx';
import { AuthProvider } from './context/AuthContext.tsx';
import Dashboard from './components/Dashboard.tsx';

const App: React.FC = () => {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
        <Route path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
};

export default App;


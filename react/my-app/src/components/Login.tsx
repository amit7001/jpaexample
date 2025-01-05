// src/components/Login.tsx
import React from 'react';
import { loginUser } from '../api/api.ts';
import AuthForm from './AuthForm.tsx';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom'

const Login: React.FC = () => {
    const navigate = useNavigate();

    const handleLogin = async (id: number, password: string) => {
        try {
            const response = await loginUser(id, password);
            // Assuming the response contains a token or some data
            localStorage.setItem('authToken', response.token);
            navigate('/dashboard'); // Redirect to the dashboard after successful login
        } catch (error) {
            alert(error.message); // Show login error
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <AuthForm onSubmit={handleLogin} buttonText="Login" />
            <Link to="/signup">Go to Signup</Link>

        </div>
    );
};

export default Login;

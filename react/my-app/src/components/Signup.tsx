// src/components/Signup.tsx
import React from 'react';
import { signupUser } from '../api/api.ts';
import SignupForm from './SignupForm.tsx';
import { useNavigate } from 'react-router-dom';

const Signup: React.FC = () => {
    
        const navigate = useNavigate();

    const handleSignup = async (email: string, password: string,contact:number,name:string) => {
        try {
            const response = await signupUser(email, password,contact,name);
            // Assuming the response contains a token or some data
            localStorage.setItem('authToken', response.token);
            navigate('/login'); // Redirect to the dashboard after successful signup
        } catch (error) {
            alert(error.message); // Show signup error
        }
    };

    return (
        <div>
            <h2>Signup</h2>
            <SignupForm onSubmit={handleSignup} buttonText="Signup" />
        </div>
    );
};

export default Signup;

// src/components/AuthForm.tsx
import React, { useState } from 'react';

interface SignupFormProps {
    onSubmit: (email: string, password: string,contact:number,name:string) => void;
    buttonText: string;
}

const SignupForm: React.FC<SignupFormProps> = ({ onSubmit, buttonText }) => {
    const [contact, setcontact] = useState<number>(0);
    const [password, setPassword] = useState<string>('');
    const [name, setname] = useState<string>('');
    const [email, setEmail] = useState<string>('');
    const [error, setError] = useState<string | null>(null);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (name && password && email && contact) {
            onSubmit(email, password, contact ,name);
        } else {
            setError("All fields are required");
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Customer name &nbsp;</label>
                <input
                    type="string"
                    value={name}
                    onChange={(e) => setname(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Customer email &nbsp;</label>
                <input
                    type="string"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
            </div>
         
            <div>
                <label>Customer Contact &nbsp;</label>
                <input
                    type="number"
                    value={contact}
                    onChange={(e) => setcontact(e.target.valueAsNumber)}
                    required
                />
            </div>
            <div>
                <label>Password &nbsp;</label>
                <input
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
            </div>
            {error && <div className="error">{error}</div>}
            <button type="submit">{buttonText}</button>
        </form>
    );
};

export default SignupForm;

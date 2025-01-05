// src/components/AuthForm.tsx
import React, { useState } from 'react';

interface AuthFormProps {
    onSubmit: (id: number, password: string) => void;
    buttonText: string;
}

const AuthForm: React.FC<AuthFormProps> = ({ onSubmit, buttonText }) => {
    const [id, setId] = useState<number>(0);
    const [password, setPassword] = useState<string>('');
    const [error, setError] = useState<string | null>(null);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (id && password) {
            onSubmit(id, password);
        } else {
            setError("Both fields are required");
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Customer id &nbsp;</label>
                <input
                    type="number"
                    value={id}
                    onChange={(e) => setId(e.target.valueAsNumber)}
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

export default AuthForm;

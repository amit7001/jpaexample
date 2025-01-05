// src/api/api.ts
const API_URL = "http://localhost:8080"; // Replace with your API base URL

export const loginUser = async (id: number, password: string) => {
    const response = await fetch(`${API_URL}/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ id, password }),
    });

    if (!response.ok) {
        throw new Error("Login failed");
    }

    return response.json();
};

export const signupUser = async (email: string, password: string,contact:number,name:string) => {
    const response = await fetch(`${API_URL}/signup`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ name, email,contact,password }),
    });

    if (!response.ok) {
        throw new Error("Signup failed");
    }

    return response.json();
};

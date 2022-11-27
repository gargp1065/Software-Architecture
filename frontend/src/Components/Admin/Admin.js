import axios from 'axios';
import React from 'react';
import { useState } from 'react';

function Admin() {

    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        const data = {
            username: userName,
            password: password
        }
        axios.post("http://localhost:8081/project/author/register", data)
            .then((response) => {
                console.log(response);
                if(response.data === true)
                    alert("Successfully Registration")
            })
            .catch((error) => {
                console.log(error);
            })
    }
    return (
        <div className="container">
            
            Enter the credentials for the author.
            
            <div>
                <form onSubmit={handleSubmit}>
                    <input type="text"
                        
                        value={userName}
                        placeholder="Enter UserName"
                        onChange={(e) => setUserName(e.target.value)}>
                    </input>

                    <input type="password"
                        
                        value={password}
                        placeholder="Enter Password"
                        onChange={(e) => setPassword(e.target.value)}>
                    </input>
                    
                    <button onSubmit={handleSubmit}>Submit</button>
                </form>
            </div>
        </div>
    )
}
export default Admin;
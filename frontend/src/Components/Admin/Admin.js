import axios from 'axios';
import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router';
import '../CSS/login.css'
function Admin() {

    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
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

        setPassword("");
        setUserName("");
    }

    const handleLogout = (e) => {
        e.preventDefault();
        localStorage.clear();
        navigate("/login");
    }


    return (
        <div className="container">
            <div className="logout">
                <button onClick={handleLogout}>Logout</button>
            </div> 
            <center><h1>Add Author</h1></center>
            
            <div>
                <form onSubmit={handleSubmit}>
                    <div>
                        <label>UserName : </label>
                        <input type="text"
                            
                            value={userName}
                            placeholder="Enter UserName"
                            onChange={(e) => setUserName(e.target.value)}>
                        </input>
                    </div>

                    <div>
                        <label>Password : </label>
                        <input type="password"
                            value={password}
                            placeholder="Enter Password"
                            onChange={(e) => setPassword(e.target.value)}>
                        </input>
                    </div>
                    
                    <center><button onSubmit={handleSubmit}>Add Author</button></center>
                </form>
            </div>
        </div>
    )
}
export default Admin;
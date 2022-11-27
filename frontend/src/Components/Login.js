import React, {useState} from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
function Login() {

    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [role, setRole] = useState("");
    const navigate = useNavigate();
    const handleSubmit = (e) => {
        e.preventDefault();
        const data = {
            username: userName,
            password: password
        } 
        console.log(role);
        if(role === "Author") {
            axios.post("http://localhost:8081/project/author/login", data)
                .then( response => {
                    console.log(response);
                    const value = response.data;
                    console.log(value);
                    if(value !== -1) {
                        localStorage.setItem("authorId", value);
                        navigate("/authorPage");
                    }
                    else {
                        alert("wrong credentials");
                    }
                    // const responseValue = response.body;
                })
                .catch( error => {
                    console.log(error);
                });
        }
        else  {
            console.log("Admin");
            axios.post("http://localhost:8081/project/admin/login", data)
                .then((response) => {
                    console.log(response);
                    const value = response.data;
                    if(value === true) {
                        navigate("/adminPage");
                    }
                    else {
                        alert("wrong credentials");
                    }
                })
                .catch((error) => {
                    console.log(error);
                });
        }
        setPassword("");
        setUserName("");
    }

    return (
        <div className="container">
            This is Login Page.
            Input your credentials to login.    
        
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
                    <select type="text" value={role} name="role" placeholder="role" onChange={(e) => setRole(e.target.value)}>
                        <option>Admin</option>
                        <option>Author</option>
                    </select>
                    <button onSubmit={handleSubmit}>Submit</button>
                </form>
            </div>

        </div>
    )
}

export default Login;

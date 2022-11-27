import React from "react";
import { Navigate, useNavigate } from "react-router";


function Author() {

    const navigate = useNavigate();
    const addItem = (e) => {
        e.preventDefault();
        navigate("/addItem");
    }
    const generate = (e) => {
        e.preventDefault();
        navigate("/generateQuesPaper");
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
            <center><h1>Author Dashboard</h1></center>
            
            <button onClick={addItem} style={{marginLeft: "10px"}}>Add Item</button>
            
            <button onClick={generate} style={{marginLeft: "10px"}}>Generate Question Paper</button>
        </div>
    )
}

export default Author;
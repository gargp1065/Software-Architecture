import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router";
import '../CSS/generateQuesPaper.css'
function GenerateQuesPaper() {


    const [subject, setSubject] = useState("");
    const [number, setNumber] = useState(0);

    const navigate = useNavigate();


    const handleSubmit = (e) => {
        e.preventDefault();
        axios.get(`http://localhost:8081/project/get/${subject}/${number}`) 
            .then((response) => {
                // console.log(response);
                navigate('/showPaper', {state: response.data})
            })
            .catch((error) => {
                console.log(error);
            })
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
            <center><h1>New Question Paper</h1></center>
            <div className="generatePaper">
                <form onSubmit={handleSubmit}> 
                    <div>
                        <input type="number" value={number} placeholder="Enter Number of Questions" onChange={(e) => setNumber(e.target.value)}></input>
                    </div>
                    <div>
                        <input type="text" value={subject} placeholder="Enter Subject" onChange={(e) => setSubject(e.target.value)}></input>
                    </div>
                    <div>
                        <button onSubmit={handleSubmit}>Submit</button>
                    </div>
                </form>
            </div>
        </div>
    )
}


export default GenerateQuesPaper;
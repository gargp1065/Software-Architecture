import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router";

function GenerateQuesPaper() {


    const [subject, setSubject] = useState("");
    const [number, setNumber] = useState(0);

    const navigate = useNavigate();


    const handleSubmit = (e) => {
        e.preventDefault();
        axios.get(`http://localhost:8083/instrument/get/${subject}/${number}`) 
            .then((response) => {
                // console.log(response);
                navigate('/showPaper', {state: response.data})
            })
            .catch((error) => {
                console.log(error);
            })
    }
    return (
        <div className="container">
            <form onSubmit={handleSubmit}> 
                <input type="number" value={number} placeholder="Enter Number of Questions" onChange={(e) => setNumber(e.target.value)}></input>

                <input type="text" value={subject} placeholder="Enter Subject" onChange={(e) => setSubject(e.target.value)}></input>
                <button onSubmit={handleSubmit}>Submit</button>
            </form>
        </div>
    )
}


export default GenerateQuesPaper;
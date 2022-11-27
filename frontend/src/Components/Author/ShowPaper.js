import React, { useState } from "react";
import { useLocation, useNavigate } from "react-router";
import '../CSS/showPaper.css'

var count = -2;
const listTag = (element) => {
    // console.log(element);
    return (
            <label>{element}</label>
    )
}
const appendData = (element) => {
    console.log(count);
    count++;
    return (
        <li>
            <h4>Question {count}: {element.question}</h4>
            <ul className="choices">
                <div>Option A: {listTag(element.optionA)}</div>
                <div>Option B: {listTag(element.optionB)}</div>
                <div>Option C: {listTag(element.optionC)}</div>
                <div>Option D: {listTag(element.optionD)}</div>
            </ul>
        </li>
    )
    
}    

function ShowPaper(props) {
    const {state} = useLocation();
    // console.log(state);
    const navigate = useNavigate();
    const handleLogout = (e) => {
        e.preventDefault();
        localStorage.clear();
        navigate("/authorPage");
    }
    return (
        <div>
            <div className="logout">
                <button onClick={handleLogout}>Back</button>
            </div> 
            <center><h1>Question Paper</h1></center>
            <div className="listQuestion">
                <ul className="quiz">
                    {state.map((element, key, index) => 
                        <div key={index}>{appendData(element)}</div>  
                    )}
                </ul>
            </div>
        </div>
    )
}


export default ShowPaper;
import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router";
import '../CSS/addItem.css';
function AddItem() {


    const[question, setQuestion] = useState("");
    const[optionA, setOptionA] = useState("");
    const[optionB, setOptionB] = useState("");
    const[optionC, setOptionC] = useState("");
    const[optionD, setOptionD] = useState("");
    const[correctAns, setCorrectAns] = useState("");
    const[subject, setSubject] = useState("");

    const navigate = useNavigate();


    const handleLogout = (e) => {
        e.preventDefault();
        localStorage.clear();
        navigate("/login");
    }



    const handleSubmit = (e) => {
        console.log("in handle submit");
        e.preventDefault();
        const data = {
            question: question, 
            optionA: optionA,
            optionB: optionB,
            optionC: optionC,
            optionD: optionD,
            correctAnswer: correctAns,
            subject: subject 
        }
        console.log(data);
        const authorId = localStorage.getItem("authorId");
        axios.post(`http://localhost:8081/project/add/MCQ/${authorId}`, data)
            .then(response => {
                console.log(response);
                alert("Item Added Successfully");
                navigate("/authorPage");
            })
            .catch((error) => {
                console.log(error);
            })
        setCorrectAns("");
        setOptionA("");
        setOptionB("");
        setOptionC("");
        setOptionD("");
        setQuestion("");
        setSubject("");
    }

    return (
        
        <div className="container">
            <div className="logout">
                <button onClick={handleLogout}>Logout</button>
            </div> 
            <center><h1>Add New Item</h1></center>
            {console.log("In add item")}      
             
            <div className="formAddItem">
                <form onSubmit={handleSubmit}>
                    <div className="question">
                        <label>Question : </label>
                        <input 
                        type="text"
                        value={question}
                        placeholder="Enter Question"
                        onChange={(e) => setQuestion(e.target.value)}
                        ></input>
                    </div>
                    <div className="option">
                        <label>Option A : </label>
                        <input
                        type="text"
                        value={optionA}
                        placeholder="Enter Option A"
                        onChange={(e) => setOptionA(e.target.value)}
                        />
                    </div>

                    <div className="option">
                        <label>Option B : </label>
                        <input
                        type="text"
                        value={optionB}
                        placeholder="Enter Option B"
                        onChange={(e) => setOptionB(e.target.value)}
                        />
                    </div>
                    <div className="option">
                        <label>Option C : </label>
                        <input
                        type="text"
                        value={optionC}
                        placeholder="Enter Option C"
                        onChange={(e) => setOptionC(e.target.value)}
                        />
                    </div>

                    <div className="option">
                        <label>Option D : </label>
                        <input
                        type="text"
                        value={optionD}
                        placeholder="Enter Option D"
                        onChange={(e) => setOptionD(e.target.value)}
                        />
                    </div>
                    <div className="option">
                        <label>Correct : </label>
                        <input
                        type="text"
                        value={correctAns}
                        placeholder="Enter Correct Ans"
                        onChange={(e) => setCorrectAns(e.target.value)}
                        />
                    </div>
                    
                    <div className="option">
                        <label>Subject : </label>
                        <input
                        type="text"
                        value={subject}
                        placeholder="Enter Subject"
                        onChange={(e) => setSubject(e.target.value)}
                        />
                    </div>
                    
                    <button onSubmit={handleSubmit}>Add Item</button>
                </form>
            </div>

        </div>
    )
}


export default AddItem; 
import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router";

function AddItem() {


    const[question, setQuestion] = useState("");
    const[optionA, setOptionA] = useState("");
    const[optionB, setOptionB] = useState("");
    const[optionC, setOptionC] = useState("");
    const[optionD, setOptionD] = useState("");
    const[correctAns, setCorrectAns] = useState("");
    const[subject, setSubject] = useState("");

    const navigate = useNavigate();
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
        axios.post(`http://localhost:8083/instrument/add/MCQ/${authorId}`, data)
            .then(response => {
                console.log(response);
                alert("Item Added Successfully");
                navigate("/authorPage");
            })
            .catch((error) => {
                console.log(error);
            })
    }

    return (
        
        <div className="container">
            {console.log("In add item")}        
            <div>
                <form onSubmit={handleSubmit}>

                    <input 
                    type="text"
                    value={question}
                    placeholder="Enter Question"
                    onChange={(e) => setQuestion(e.target.value)}
                    ></input>

                    <input
                    type="text"
                    value={optionA}
                    placeholder="Enter Option A"
                    onChange={(e) => setOptionA(e.target.value)}
                    />

                    <input
                    type="text"
                    value={optionB}
                    placeholder="Enter Option B"
                    onChange={(e) => setOptionB(e.target.value)}
                    />

                    <input
                    type="text"
                    value={optionC}
                    placeholder="Enter Option C"
                    onChange={(e) => setOptionC(e.target.value)}
                    />

                    <input
                    type="text"
                    value={optionD}
                    placeholder="Enter Option D"
                    onChange={(e) => setOptionD(e.target.value)}
                    />

                    <input
                    type="text"
                    value={correctAns}
                    placeholder="Enter Correct Ans"
                    onChange={(e) => setCorrectAns(e.target.value)}
                    />
                    
                    <input
                    type="text"
                    value={subject}
                    placeholder="Enter Subject"
                    onChange={(e) => setSubject(e.target.value)}
                    />
                    
                    <button onSubmit={handleSubmit}>Add Item</button>
                </form>
            </div>

        </div>
    )
}


export default AddItem; 
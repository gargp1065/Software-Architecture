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
    return (
        <div className="container">
            <button onClick={addItem}>Add Item</button>
            <button onClick={generate}>Generate Question Paper</button>
        </div>
    )
}

export default Author;
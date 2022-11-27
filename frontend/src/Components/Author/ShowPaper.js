import React from "react";
import { useLocation } from "react-router";

function ShowPaper(props) {
    const {state} = useLocation();
    // console.log(state);

    

    return (
        <div className="container">
            
            
            
            Helllo

            {state.array.forEach(element => {
                Object.entries(element).map( ([key, value]) => {
                    <p>{element[key]}</p>
                })  
            })}


        </div>
    )
}


export default ShowPaper;
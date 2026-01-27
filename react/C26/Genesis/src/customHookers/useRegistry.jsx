/* eslint-disable react-hooks/set-state-in-effect */
import { useEffect, useState } from "react";

const useRegistry = (userDetails) => {
    const [name, setName] = useState("");
    const [message, setMessage] = useState("");

    useEffect(() => {
        if (userDetails && userDetails.firstName !== name) {
            setName(userDetails.firstName || ""); 
            setMessage("Registration Successful");
        }
    }, [userDetails, name]); 

    return { name, message };


};

    
export default useRegistry;

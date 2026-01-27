import { useState } from "react";
import styles from "./register.module.css";

const Register = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");
    const handleSubmit = (e) => {
        e.preventDefault();
        if (firstName && lastName && email && password) {
            setMessage("Registration Successful");
        } else {
            setMessage("Please fill in all fields");
        } 
    };  

   <div>
        {/* {message ? alert(message) : ""} */}

        <form onSubmit={handleSubmit} className={styles.registerForm}>
            <div className={styles.labelInput}>
                <label htmlFor="firstName"> First Name </label>
                <input
                    id="firstName"
                    onChange={(e) => setFirstName(e.target.value)}
                    className={styles.input}
                    type="text"
                    placeholder=""
                />
            </div>
            <div className={styles.labelInput}>
                <label htmlFor="lastName"> LastName </label>
                <input id="lastName" onChange={(e) => setLastName(e.target.value)} className={styles.input} type="text" placeholder="" />
            </div>
            <div className={styles.labelInput}>
                <label htmlFor="email"> Email </label>
                <input id="email" onChange={(e) => setEmail(e.target.value)} className={styles.input} type="email" placeholder="" />        
            </div>
            <div className={styles.labelInput}>
                <label htmlFor="password"> Password </label>
                <input id="password" onChange={(e) => setPassword(e.target.value)} className={styles.input} type="password" placeholder="" />
            </div>
            <div className={styles.message}>    
                {message && <p>{message}</p>}
            </div>
        
            <button className={styles.registerButton} type="submit"> Register </button>
        </form>
   </div>
}

export default Register;    
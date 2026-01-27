import { Link } from "react-router";
import styles from "./Login.module.css"


const Login = () => {
  return (
     <div>
     <form className={Login}>

        <div className={styles.labelInput}>
            <label hmmlFor = "email"> email </label>
            <input className={styles.input}  type="email" placeholder = "Enter email"/>
        </div>

        <div className={styles.labelInput}>
            <label hmmlFor = "password"> password </label>
            <input className={styles.input} type="password" placeholder = "Enter password"/>
        </div>
    </form>
    <span> Dont have an account</span>
    <Link to = "/Register"> Register </Link>
    {/* <a href=""></a> */}
  
    </div>
  )
}
export default Login;

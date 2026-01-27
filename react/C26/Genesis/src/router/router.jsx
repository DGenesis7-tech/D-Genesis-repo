import {createBrowserRouter}  from "react-router"
import Login from "../auth/Login/Login"
import Register from "../auth/Register/Register"


const router = createBrowserRouter([
    {
        path: "/Login",
        element: <Login />
    },
    {
        path: "/Register",
        element: <Register />
    }
])

export default router;
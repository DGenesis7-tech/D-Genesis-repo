// import { useState } from 'react'
// import Register from './auth/Register/Register'

import { RouterProvider } from "react-router" 
import router from "./router/router"

function App() {
  

  return (
  
      <>
        <Register/>
        <Login/>
        <RouterProvider router={router} />
      </>
      
  )
}

export default App

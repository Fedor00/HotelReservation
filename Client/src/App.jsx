import "./App.css";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Unauthorized from "./pages/Unauthorized";
import ProtectedRoutes from "./pages/ProtectedRoutes";
import Homepage from "./pages/Homepage";
import PageNotFound from "./pages/PageNotFound";
import { AuthProvider } from "./contexts/AuthContext";
import BookingsPage from "./pages/BookingsPage";
function App() {
  return (
    <>
      <AuthProvider>
        <BrowserRouter>
          <Routes>
            <Route path="login" element={<Login />} />
            <Route path="register" element={<Register />} />
            <Route path="unauthorized" element={<Unauthorized />} />
            <Route element={<ProtectedRoutes allowedRoles={["ROLE_USER"]} />}>
              <Route index element={<Homepage />}></Route>
              <Route path="bookings" element={<BookingsPage />} />
            </Route>
            <Route path="*" element={<PageNotFound />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
    </>
  );
}

export default App;

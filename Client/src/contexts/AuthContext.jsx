import { createContext, useContext, useReducer } from "react";
import { login } from "../services/AccountApi";
import { jwtDecode } from "jwt-decode";

const AuthContext = createContext();

function reducer(state, action) {
  switch (action.type) {
    case "login":
      localStorage.setItem("user", JSON.stringify(action.payload));
      return { ...state, user: action.payload };
    case "logout":
      // Clear the user from localStorage on logout
      localStorage.removeItem("user");
      return { ...state, user: null };
    default:
      throw new Error("Unknown action");
  }
}

function useAuth() {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error("AuthContext was used outside AuthProvider");
  }
  return context;
}

function AuthProvider({ children }) {
  const initialUser = JSON.parse(localStorage.getItem("user"));
  const [state, dispatch] = useReducer(reducer, { user: initialUser });

  async function handleLogin(email, password) {
    try {
      const response = await login(email, password);
      const user = jwtDecode(response);
      user.token = response;
      dispatch({ type: "login", payload: user });
    } catch (error) {
      console.log(error);
      throw new Error("Email or password incorrect");
    }
  }

  function handleLogout() {
    dispatch({ type: "logout" });
  }

  function isAuthenticated() {
    return state.user != null && state.user.token != null;
  }

  return (
    <AuthContext.Provider
      value={{ ...state, handleLogin, handleLogout, isAuthenticated }}
    >
      {children}
    </AuthContext.Provider>
  );
}

// eslint-disable-next-line react-refresh/only-export-components
export { AuthProvider, useAuth };

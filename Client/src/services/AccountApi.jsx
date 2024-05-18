import axios from "axios";
const ACCOUNT_API_URL = "http://localhost:8080/auth";

const login = async (email, password) => {
  try {
    const resp = await axios.post(
      `${ACCOUNT_API_URL}/generateToken`,
      { email, password },
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    return resp.data;
  } catch (error) {
    console.error(error?.response?.data);
    throw new Error(error?.response?.data);
  }
};
const register = async (email, password, phone, username) => {
  try {
    const resp = await axios.post(
      `${ACCOUNT_API_URL}/addNewUser`,
      { email, password, phone, username },
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    return resp.data;
  } catch (error) {
    console.error(error?.response?.data);
    throw new Error(error?.response?.data);
  }
};
export { login, register };

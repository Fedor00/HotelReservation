import axios from "axios";
const HOTEL_API_URL = "http://localhost:8080/hotel";

const getHotelsByRange = async (maxDistance, latitude, longitude, user) => {
  try {
    const resp = await axios.post(
      `${HOTEL_API_URL}/range`,
      { km: maxDistance, latitude, longitude },
      {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${user?.token}`,
        },
      }
    );
    return resp.data;
  } catch (error) {
    console.error(error?.response?.data);
    throw new Error(error?.response?.data);
  }
};
export { getHotelsByRange };

import axios from "axios";
const ROOM_API_URL = "http://localhost:8080/room";

const getAvailableRoomsByHotel = async (hotel, startDate, endDate, user) => {
  console.log(hotel, "fedfd");
  try {
    const resp = await axios.post(
      `${ROOM_API_URL}/available/hotel`,
      { id: hotel.id, startDate, endDate },
      {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${user?.token}`,
        },
      }
    );
    console.log(resp.data);
    return resp.data;
  } catch (error) {
    console.error(error?.response?.data);
    throw new Error(error?.response?.data);
  }
};
export { getAvailableRoomsByHotel };

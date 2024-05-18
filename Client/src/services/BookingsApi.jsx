import axios from "axios";
const BOOKING_API_URL = "http://localhost:8080/booking";

const getBookingsByUserId = async (user) => {
  try {
    const resp = await axios.get(`${BOOKING_API_URL}/user/${user?.userId}`, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${user?.token}`,
      },
    });
    return resp.data;
  } catch (error) {
    console.error(error?.response?.data);
    throw new Error(error?.response?.data);
  }
};
const reserveRoom = async (user, room, startDate, endDate) => {
  try {
    const resp = await axios.post(
      `${BOOKING_API_URL}/add`,
      { userId: user?.userId, roomId: room.id, startDate, endDate },

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
const cancelBookingApi = async (user, booking) => {
  try {
    const resp = await axios.delete(
      `${BOOKING_API_URL}/delete/${booking?.id}`,
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
export { getBookingsByUserId, reserveRoom, cancelBookingApi };

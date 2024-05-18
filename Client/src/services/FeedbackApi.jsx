import axios from "axios";
const FEEDBACK_API_URL = "http://localhost:8080/feedback";

const addFeedbackApi = async (user, comment, hotel) => {
  console.log({
    userId: user?.userId,
    hotelId: hotel.id,
    comment,
    date: new Date(),
  });
  try {
    const resp = await axios.post(
      `${FEEDBACK_API_URL}/add`,
      { userId: user?.userId, hotelId: hotel.id, comment, date: new Date() },

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
export { addFeedbackApi };

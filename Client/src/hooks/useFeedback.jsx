import { useAuth } from "@/contexts/AuthContext";
import { addFeedbackApi } from "@/services/FeedbackApi";
import { useState } from "react";

function useFeedback() {
  const { user } = useAuth();
  const [feedback, setFeedback] = useState([]);
  async function addFeedback(hotel, comment) {
    const data = await addFeedbackApi(user, comment, hotel);
    console.log(data);
    if (data) {
      setFeedback(data);
    }
  }

  return { addFeedback, feedback };
}

export default useFeedback;

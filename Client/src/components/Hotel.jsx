import {
  Card,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Button } from "./ui/button";
import { MessageCircle } from "lucide-react"; // Import the MessageCircle icon
import { useState } from "react";
import FeedbackModal from "./FeedbackModal";
import useFeedback from "@/hooks/useFeedback";

function Hotel({ hotel, onCheckRooms }) {
  const [openFeedback, setOpenFeedback] = useState(false);
  const { addFeedback } = useFeedback();
  const handleFeedback = (comment) => {
    addFeedback(hotel, comment);
    setOpenFeedback(false);
  };
  return (
    <div>
      <Card className="bg-stone-800 text-white m-1 ">
        <CardHeader>
          <CardTitle>{hotel.name}</CardTitle>
          <CardDescription>
            {hotel.distance.toFixed(1)} Km from you
          </CardDescription>
        </CardHeader>

        <CardFooter>
          <Button className="w-full" onClick={() => onCheckRooms(hotel)}>
            Check Rooms
          </Button>
          <Button className="w-full" onClick={() => setOpenFeedback(true)}>
            <MessageCircle size={24} />
          </Button>
        </CardFooter>
      </Card>
      <FeedbackModal
        open={openFeedback}
        setOpen={() => setOpenFeedback(false)}
        onFeedback={handleFeedback}
      />
    </div>
  );
}

export default Hotel;

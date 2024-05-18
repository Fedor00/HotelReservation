import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from "@/components/ui/accordion";
import { roomType } from "@/utils/roomUtils";
import { Button } from "./ui/button";
import { XIcon, Edit2 } from "lucide-react";

function Booking({ booking, cancelBooking, changeRoom }) {
  if (!booking) {
    return <p>No booking information available.</p>;
  }
  return (
    <div className="w-full justify-center items-center flex">
      <Accordion
        type="single"
        collapsible
        className="bg-stone-800 text-white w-[90%] rounded-lg"
      >
        <AccordionItem value="item-2" className="text-center ">
          <div className="flex items-center justify-center w-full">
            <AccordionTrigger className="flex-grow text-center">
              {booking.hotelName}
              {" | Room "}
              {booking.room.roomNumber}
            </AccordionTrigger>
            <Button
              onClick={() => cancelBooking(booking)}
              className="justify-self-end"
            >
              <XIcon size={10} />
            </Button>
            <Button onClick={() => changeRoom(booking)}>
              <Edit2 size={10} />
            </Button>
          </div>
          <AccordionContent>
            <div className="flex space-x-1 flex-auto justify-center">
              <p className="bg-stone-900 p-1 rounded-lg">
                {roomType[booking.room.type - 1]}
              </p>
              <p className="bg-stone-900 p-1 rounded-lg">
                Start: {booking.startDate}
              </p>
              <p className="bg-stone-900 p-1 rounded-lg">
                End: {booking.endDate}
              </p>
            </div>
          </AccordionContent>
        </AccordionItem>
      </Accordion>
    </div>
  );
}

export default Booking;

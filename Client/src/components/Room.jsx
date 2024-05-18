import {
  Card,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Button } from "./ui/button";
import { roomType } from "@/utils/roomUtils";

function Room({ room, bookRoom }) {
  console.log(room);
  console.log(room.type, "room type");
  return (
    <Card className="bg-stone-800 text-white m-1 ">
      <CardHeader>
        <CardTitle>{roomType[room.type - 1]}</CardTitle>
        <CardDescription>
          <p>Price: {room.price}</p>
          <p>Room Number: {room.roomNumber}</p>
        </CardDescription>
      </CardHeader>

      <CardFooter>
        <Button className="w-full" onClick={() => bookRoom(room)}>
          Book Room
        </Button>
      </CardFooter>
    </Card>
  );
}

export default Room;

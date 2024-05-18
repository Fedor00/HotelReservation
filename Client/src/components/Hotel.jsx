import {
  Card,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Button } from "./ui/button";

function Hotel({ hotel, onCheckRooms }) {
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
        </CardFooter>
      </Card>
    </div>
  );
}

export default Hotel;

import useRooms from "@/hooks/useRooms";
import Modal from "./Modal";
import Room from "./Room";
import { useState } from "react";
import { Button } from "./ui/button";
function Rooms({ hotel, isOpen, onClose, startDate, endDate }) {
  const { rooms, bookRoom } = useRooms(hotel ? hotel : [], startDate, endDate);
  const [roomType, setRoomType] = useState(1);
  const filteredRooms = rooms?.filter((room) => room.type === roomType);
  return (
    <div>
      <Modal isOpen={isOpen} onClose={onClose}>
        <div></div>
        <div className="flex items-center justify-center">
          <Button
            onClick={() => setRoomType(1)}
            className={`${
              roomType === 1 ? "bg-stone-700" : ""
            } hover:bg-stone-700`}
          >
            Single
          </Button>
          <Button
            onClick={() => setRoomType(2)}
            className={`${
              roomType === 2 ? "bg-stone-700" : ""
            } hover:bg-stone-700`}
          >
            Double
          </Button>
          <Button
            onClick={() => setRoomType(3)}
            className={`${
              roomType === 3 ? "bg-stone-700" : ""
            } hover:bg-stone-700`}
          >
            Suit
          </Button>
          <Button
            onClick={() => setRoomType(4)}
            className={`${
              roomType === 4 ? "bg-stone-700" : ""
            } hover:bg-stone-700`}
          >
            Matrimonial
          </Button>
        </div>
        <div className="max-h-[90vh] overflow-auto text-black font-bold">
          {filteredRooms.length === 0 && (
            <div className="flex items-center justify-center">
              <p>No rooms of this type available</p>
            </div>
          )}
          {filteredRooms.map((room) => (
            <Room key={room.id} room={room} bookRoom={bookRoom} />
          ))}
        </div>
      </Modal>
    </div>
  );
}

export default Rooms;

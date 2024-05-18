import { useAuth } from "@/contexts/AuthContext";
import { reserveRoom } from "@/services/BookingsApi";
import { getAvailableRoomsByHotel } from "@/services/RoomApi";
import { useEffect, useState } from "react";

function useRooms(hotel, startDate, endDate) {
  const [rooms, setRooms] = useState([]);
  const { user } = useAuth();
  useEffect(() => {
    const fetchRooms = async () => {
      const data = await getAvailableRoomsByHotel(
        hotel,
        startDate,
        endDate,
        user
      );
      if (data) setRooms(data);
    };
    if (hotel) fetchRooms();
  }, [endDate, hotel, startDate, user]);
  const areDatesEqual = (date1, date2) => {
    return (
      date1.getFullYear() === date2.getFullYear() &&
      date1.getMonth() === date2.getMonth() &&
      date1.getDate() === date2.getDate()
    );
  };
  const bookRoom = async (room) => {
    if (areDatesEqual(new Date(startDate), new Date(endDate))) {
      alert("Please select a valid date range");
      return;
    }
    const data = await reserveRoom(user, room, startDate, endDate);
    console.log(data);
    if (data) {
      alert("Room booked successfully");
      setRooms(rooms.filter((r) => r.id !== room.id)); // Assuming rooms have a unique 'id' property
    } else {
      alert("Room booking failed");
    }
  };
  return { rooms, bookRoom };
}

export default useRooms;

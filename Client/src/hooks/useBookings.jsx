import { useAuth } from "@/contexts/AuthContext";
import { getBookingsByUserId, cancelBookingApi } from "@/services/BookingsApi";
import { useEffect, useState } from "react";

function useBookings() {
  const [bookings, setBookings] = useState([]);
  const { user } = useAuth();
  useEffect(() => {
    const fetchBookings = async () => {
      console.log(user);
      const data = await getBookingsByUserId(user);
      if (data) setBookings(data);
    };
    if (user) fetchBookings();
  }, [user]);

  const cancelBooking = async (booking) => {
    const now = new Date();
    const startDate = new Date(booking.startDate);
    const twoHoursBefore = new Date(startDate.getTime() - 2 * 60 * 60 * 1000);

    if (now < twoHoursBefore) {
      await cancelBookingApi(user, booking);
      setBookings((prev) => prev.filter((b) => b.id !== booking.id));
    } else {
      alert("Cannot cancel booking less than 2 hours before start date");
    }
  };
  const changeRoom = async (bookings) => {
    console.log(bookings);
  };
  return { bookings, cancelBooking, changeRoom };
}

export default useBookings;

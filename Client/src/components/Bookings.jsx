import useBookings from "@/hooks/useBookings";
import Booking from "./Booking";

function Bookings() {
  const { bookings, changeRoom, cancelBooking } = useBookings();
  console.log(bookings);
  return (
    <div className="flex flex-col justify-center items-center">
      {bookings.map((booking) => {
        return (
          <Booking
            booking={booking}
            key={booking.id}
            cancelBooking={cancelBooking}
            changeRoom={changeRoom}
          />
        );
      })}
    </div>
  );
}

export default Bookings;

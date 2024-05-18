import HomeNavbar from "../components/HomeNavbar";
import HotelReservations from "@/components/HotelReservations";

function Homepage() {
  return (
    <div className="h-full">
      <HomeNavbar />
      <HotelReservations />
    </div>
  );
}

export default Homepage;

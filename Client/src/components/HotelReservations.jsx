import { useState } from "react";
import useHotels from "@/hooks/useHotels";
import Hotels from "./Hotels";
import Rooms from "./Rooms";
import { Button } from "./ui/button";
import FilterRangeAndDateModal from "./FilterRangeAndDateModal";

function HotelReservations() {
  const [maxDistance, setMaxDistance] = useState(10);
  const { hotels } = useHotels({ maxDistance });
  const [currentHotel, setCurrentHotel] = useState(null);
  const [showRooms, setShowRooms] = useState(false);
  const [from, setFrom] = useState(new Date());
  const [to, setTo] = useState(new Date(from.getTime() + 24 * 60 * 60 * 1000));
  const [openFilterOptions, setOpenFilterOptions] = useState(false);
  const onCheckRooms = (hotel) => {
    setShowRooms((s) => !s);
    setCurrentHotel(() => hotel);
  };
  const closeModal = () => {
    setShowRooms(false);
  };

  return (
    <div className="flex justify-center items-center w-full">
      <div className="flex flex-col items-center">
        <Button onClick={() => setOpenFilterOptions(true)} className="w-full">
          Filter range or date
        </Button>
        <Hotels hotels={hotels} onCheckRooms={onCheckRooms} />
        {hotels.length === 0 && <div>No hotels found.</div>}
        {showRooms && currentHotel && (
          <Rooms
            hotel={currentHotel}
            isOpen={showRooms}
            onClose={closeModal}
            startDate={from}
            endDate={to}
          />
        )}
      </div>
      <FilterRangeAndDateModal
        open={openFilterOptions}
        setOpen={setOpenFilterOptions}
        from={from}
        to={to}
        setFrom={setFrom}
        setTo={setTo}
        distance={maxDistance}
        setDistance={setMaxDistance}
      ></FilterRangeAndDateModal>
    </div>
  );
}

export default HotelReservations;

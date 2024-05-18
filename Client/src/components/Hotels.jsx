import Hotel from "./Hotel";

function Hotels({ hotels, onCheckRooms }) {
  return (
    <div>
      <div className="flex flex-col sm:flex-row ">
        {hotels.map((hotel) => {
          return (
            <Hotel hotel={hotel} key={hotel.id} onCheckRooms={onCheckRooms} />
          );
        })}
      </div>
    </div>
  );
}

export default Hotels;

import { useAuth } from "@/contexts/AuthContext";
import { getHotelsByRange } from "@/services/HotelsApi";
import { useEffect, useState } from "react";
import usePersistentGeolocation from "./useGeolocation";

function useHotels({ maxDistance }) {
  const [hotels, setHotels] = useState([]);
  const { user } = useAuth();
  const geolocation = usePersistentGeolocation();
  useEffect(() => {
    async function fetchHotels() {
      const hotels = await getHotelsByRange(
        maxDistance,
        geolocation.latitude,
        geolocation.longitude,
        user
      );
      setHotels(hotels);
    }
    if (
      geolocation?.latitude &&
      geolocation?.longitude &&
      user &&
      maxDistance > 0
    ) {
      fetchHotels();
    }
  }, [geolocation.latitude, geolocation.longitude, maxDistance, user]);

  return { hotels, geolocation };
}

export default useHotels;

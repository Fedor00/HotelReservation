import { useEffect, useState } from "react";
import { useGeolocation } from "react-use";

const usePersistentGeolocation = () => {
  const geolocation = useGeolocation();
  const [persistentGeo, setPersistentGeo] = useState(() => {
    const storedGeo = localStorage.getItem("geolocation");
    return storedGeo
      ? JSON.parse(storedGeo)
      : { latitude: null, longitude: null };
  });

  useEffect(() => {
    if (geolocation.latitude && geolocation.longitude) {
      localStorage.setItem("geolocation", JSON.stringify(geolocation));
      setPersistentGeo(geolocation);
    }
  }, [geolocation, geolocation.latitude, geolocation.longitude]);

  return persistentGeo;
};
export default usePersistentGeolocation;

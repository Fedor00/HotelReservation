package Fedor.Hotel._Reservation.service;

import org.springframework.stereotype.Service;

@Service
public class GeoService {
    private static final double EARTH_RADIUS = 6378137;
    private static final double B_OVER_A = 0.99664719;
    public static double metersPerDegreeLatitude(double latitude) {
        double phi = Math.toRadians(latitude);
        return 111132.92 - 559.82 * Math.cos(2 * phi) + 1.175 * Math.cos(4 * phi) - 0.0023 * Math.cos(6 * phi);
    }
    public static double metersPerDegreeLongitude(double latitude) {
        double phi = Math.toRadians(latitude);
        double beta = Math.atan(B_OVER_A * Math.tan(phi));
        return (Math.PI / 180) * EARTH_RADIUS * Math.cos(beta);
    }
    public static double distanceBetweenPoints(double lat1, double lon1, double lat2, double lon2) {
        double latDistance = Math.abs(lat1 - lat2) * metersPerDegreeLatitude((lat1 + lat2) / 2);
        double lonDistance = Math.abs(lon1 - lon2) * metersPerDegreeLongitude((lat1 + lat2) / 2);
        return Math.sqrt(latDistance * latDistance + lonDistance * lonDistance);
    }
    public static double distanceBetweenPointsHaversine(double lat1, double lon1, double lat2, double lon2) {
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double deltaPhi = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);

        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) +
                Math.cos(phi1) * Math.cos(phi2) *
                        Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}

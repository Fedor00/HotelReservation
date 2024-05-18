package Fedor.Hotel._Reservation.service;

import Fedor.Hotel._Reservation.Dto.HotelDto;
import Fedor.Hotel._Reservation.Dto.HotelsWithinKmRangeRequest;
import Fedor.Hotel._Reservation.entity.Hotel;
import Fedor.Hotel._Reservation.repository.BookingRepository;
import Fedor.Hotel._Reservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public List<HotelDto> getHotelsWithinKmRange(HotelsWithinKmRangeRequest request) {

        return hotelRepository.findAll().stream()
                .filter(hotel -> GeoService.distanceBetweenPoints(
                        request.getLatitude(), request.getLongitude(),
                        hotel.getLatitude(), hotel.getLongitude()) <= request.getKm() * 1000)
                .map(hotel -> new HotelDto(
                        hotel.getId(),
                        hotel.getName(),
                        GeoService.distanceBetweenPoints(
                                request.getLatitude(), request.getLongitude(),
                                hotel.getLatitude(), hotel.getLongitude())/1000
                ))
                .collect(Collectors.toList());
    }
}

package Fedor.Hotel._Reservation.data;
import Fedor.Hotel._Reservation.entity.Booking;
import Fedor.Hotel._Reservation.entity.Room;
import Fedor.Hotel._Reservation.repository.BookingRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Fedor.Hotel._Reservation.entity.Hotel;
import Fedor.Hotel._Reservation.repository.HotelRepository;
import Fedor.Hotel._Reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public void run(String... args) throws IOException {
        seedHotels();
        seedBookings();
    }
    public void seedHotels() throws IOException {
        if(roomRepository.count()==0){
            ObjectMapper mapper = new ObjectMapper();
            File file = new ClassPathResource("hotels.json").getFile();
            List<Hotel> hotels = mapper.readValue(file, new TypeReference<>() {
            });
            for (Hotel hotel : hotels) {
                hotelRepository.save(hotel);

                for (Room room : hotel.getRooms()) {
                    room.setHotel(hotel);
                    roomRepository.save(room);
                }
            }

        }
    }
    public void seedBookings() throws IOException {
        if(bookingRepository.count()==0){
            ObjectMapper mapper = new ObjectMapper();
            File file = new ClassPathResource("bookings.json").getFile();
            List<Booking> bookings = mapper.readValue(file, new TypeReference<>() {
            });
            for (Booking booking : bookings) {
                bookingRepository.save(booking);
                System.out.println(booking);
            }

        }
    }
}

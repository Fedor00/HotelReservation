package Fedor.Hotel._Reservation.service;

import Fedor.Hotel._Reservation.Dto.GetAvailableRoomsRequest;
import Fedor.Hotel._Reservation.entity.Booking;
import Fedor.Hotel._Reservation.entity.Room;
import Fedor.Hotel._Reservation.repository.BookingRepository;
import Fedor.Hotel._Reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;
    public List<Room> getRoomsByHotelId(Long id){
        return roomRepository.findAllByHotel_Id(id);

    }
    public List<Room> getAvailableRoomsByHotelId(GetAvailableRoomsRequest request){
        List<Room> rooms=roomRepository.findAllByHotel_Id(request.getId());
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            List<Booking> bookings = bookingRepository.findConfirmedBookingsByRoomAndDateRange(room.getId(), request.getStartDate(), request.getEndDate());
            if (bookings.isEmpty()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;

    }


}

package Fedor.Hotel._Reservation.service;

import Fedor.Hotel._Reservation.Dto.ReserveRoomRequest;
import Fedor.Hotel._Reservation.entity.Room;
import Fedor.Hotel._Reservation.entity.UserInfo;
import Fedor.Hotel._Reservation.repository.BookingRepository;
import Fedor.Hotel._Reservation.repository.RoomRepository;
import Fedor.Hotel._Reservation.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import Fedor.Hotel._Reservation.Dto.BookingDto;
import Fedor.Hotel._Reservation.entity.Booking;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<BookingDto> getBookingsByUserId(int userId){
        List<Booking> bookings = bookingRepository.findAllByUser_Id(userId);
        return bookings.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    public Booking save(ReserveRoomRequest request){
        UserInfo user = userInfoRepository.getReferenceById(request.getUserId());
        Room room = roomRepository.getReferenceById(request.getRoomId());

        if(user == null || room == null) return null;

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setStartDate(request.getStartDate());
        booking.setEndDate(request.getEndDate());
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

    public void delete(Long id){
        bookingRepository.deleteById(id);
    }
    private BookingDto convertToDto(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setId(booking.getId());
        dto.setStartDate(booking.getStartDate());
        dto.setEndDate(booking.getEndDate());
        dto.setRoom(booking.getRoom());
        dto.setHotelName(booking.getRoom().getHotel().getName());
        return dto;
    }

}

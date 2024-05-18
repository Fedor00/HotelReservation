package Fedor.Hotel._Reservation.controllers;

import Fedor.Hotel._Reservation.Dto.GetAvailableRoomsRequest;
import Fedor.Hotel._Reservation.Dto.HotelsWithinKmRangeRequest;
import Fedor.Hotel._Reservation.entity.Hotel;
import Fedor.Hotel._Reservation.entity.Room;
import Fedor.Hotel._Reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/hotel/{hotelId}")
    public List<Room> getRoomsByHotelId(@PathVariable Long hotelId) {
        return roomService.getRoomsByHotelId(hotelId);
    }

    @PostMapping("/available/hotel")
    public List<Room> getAvailableRoomsByHotelId(@RequestBody GetAvailableRoomsRequest request) {
        return roomService.getAvailableRoomsByHotelId(request);
    }

}

package Fedor.Hotel._Reservation.controllers;

import Fedor.Hotel._Reservation.Dto.BookingDto;
import Fedor.Hotel._Reservation.Dto.ReserveRoomRequest;
import Fedor.Hotel._Reservation.entity.Booking;
import Fedor.Hotel._Reservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDto>> GetBookingByUser(@PathVariable int userId){
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }
    @GetMapping("/user")
    public ResponseEntity<?> GetBookingByUsr(){
        return ResponseEntity.ok("hdgfsuigfyhuig");
    }
    @PostMapping("/add")
    public ResponseEntity<?> reserveRoom(@RequestBody ReserveRoomRequest request){
        return ResponseEntity.ok(bookingService.save(request));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> reserveRoom(@PathVariable Long id){
        bookingService.delete(id);
        return ResponseEntity.ok("Reservation canceled.");
    }



}

package Fedor.Hotel._Reservation.controllers;

import Fedor.Hotel._Reservation.Dto.HotelDto;
import Fedor.Hotel._Reservation.Dto.HotelsWithinKmRangeRequest;
import Fedor.Hotel._Reservation.entity.Hotel;
import Fedor.Hotel._Reservation.service.HotelService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> GetHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
    @PostMapping("/range")
    public ResponseEntity<List<HotelDto>> GetHotelsInRange(@RequestBody HotelsWithinKmRangeRequest hotelsWithinKmRangeRequest){
        return  ResponseEntity.ok(hotelService.getHotelsWithinKmRange(hotelsWithinKmRangeRequest));
    }



}

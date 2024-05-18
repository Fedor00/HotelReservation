package Fedor.Hotel._Reservation.Dto;

import Fedor.Hotel._Reservation.entity.Room;
import Fedor.Hotel._Reservation.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    private UserInfo user;
    private Room room;
    private Date startDate;
    private Date endDate;
    private String hotelName;
}

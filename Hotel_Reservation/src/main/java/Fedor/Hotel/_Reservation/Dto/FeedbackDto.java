package Fedor.Hotel._Reservation.Dto;

import Fedor.Hotel._Reservation.entity.Hotel;
import Fedor.Hotel._Reservation.entity.UserInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {
    private int userId;
    private Long hotelId;
    private String comment;
    private Date date;
}

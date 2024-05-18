package Fedor.Hotel._Reservation.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveRoomRequest {
    private int userId;
    private Long roomId;
    private Date startDate;
    private Date endDate;
}

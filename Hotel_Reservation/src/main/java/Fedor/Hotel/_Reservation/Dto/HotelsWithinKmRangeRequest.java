package Fedor.Hotel._Reservation.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelsWithinKmRangeRequest {
    private int km;
    private double latitude;
    private double longitude;
}

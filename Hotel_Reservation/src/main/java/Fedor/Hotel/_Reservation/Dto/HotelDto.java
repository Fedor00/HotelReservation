package Fedor.Hotel._Reservation.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDto {
    private Long id;
    private String name;
    private double distance;
}

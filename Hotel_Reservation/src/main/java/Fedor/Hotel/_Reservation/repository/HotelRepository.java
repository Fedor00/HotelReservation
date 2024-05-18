package Fedor.Hotel._Reservation.repository;

import Fedor.Hotel._Reservation.entity.Hotel;
import Fedor.Hotel._Reservation.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}

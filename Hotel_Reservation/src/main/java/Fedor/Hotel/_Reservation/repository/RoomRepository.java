package Fedor.Hotel._Reservation.repository;

import Fedor.Hotel._Reservation.entity.Room;
import Fedor.Hotel._Reservation.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByHotel_Id(Long id);


}

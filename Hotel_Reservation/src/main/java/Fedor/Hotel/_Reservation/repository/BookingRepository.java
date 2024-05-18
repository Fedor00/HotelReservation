package Fedor.Hotel._Reservation.repository;

import Fedor.Hotel._Reservation.entity.Booking;
import Fedor.Hotel._Reservation.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId AND b.status = 'CONFIRMED' " +
            "AND NOT (b.endDate <= :startDate OR b.startDate >= :endDate)")
    List<Booking> findConfirmedBookingsByRoomAndDateRange(@Param("roomId") Long roomId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    List<Booking> findAllByUser_Id(int userId);
}

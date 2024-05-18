package Fedor.Hotel._Reservation.repository;

import Fedor.Hotel._Reservation.entity.Feedback;
import Fedor.Hotel._Reservation.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}

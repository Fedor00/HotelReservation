package Fedor.Hotel._Reservation.repository;


import Fedor.Hotel._Reservation.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);
    Optional<UserInfo> findByEmail(String email);
}

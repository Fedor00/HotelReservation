package Fedor.Hotel._Reservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Feedback> feedbacks = new ArrayList<>();
}

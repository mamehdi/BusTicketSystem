package ir.maktabsharif.busticketsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String origin;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private LocalDate travelDate;
    @Column(nullable = false)
    private LocalTime travelTime;
    @Column(nullable = false)
    private String busNumber;
    @Column(nullable = false)
    private Integer capacity;
    @Column(nullable = false)
    private Integer availabeSeat;
    @OneToMany(mappedBy = "journey_id")
    List<Ticket> ticketList;
}

package ir.maktabsharif.busticketsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journey_id")
    private Journey journey;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journey_user_id")
    private User journeyUser;
}

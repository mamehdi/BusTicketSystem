package ir.maktabsharif.busticketsystem.model;

import ir.maktabsharif.busticketsystem.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private String role;
    @OneToMany(mappedBy = "journey_user_id")
    List<Ticket> tickets;

}

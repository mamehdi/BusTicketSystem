package ir.maktabsharif.busticketsystem.repository;

import ir.maktabsharif.busticketsystem.model.AppUser;
import ir.maktabsharif.busticketsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByJourneyAppUserOrderByTravelDateAsc(AppUser appUser);

    Optional<Ticket> findByIdAndJourneyAppUser(Long id, AppUser appUser);
}

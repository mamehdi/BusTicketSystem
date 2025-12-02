package ir.maktabsharif.busticketsystem.repository;

import ir.maktabsharif.busticketsystem.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface JourneyRepository extends JpaRepository  <Journey,Long> {
    List<Journey> findByoriginAndDestinationAndTravelDateOrderByTravelTimeAsc(
            String origin, String destination, LocalDate travelDate
    );
}

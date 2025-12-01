package ir.maktabsharif.busticketsystem.repository;

import ir.maktabsharif.busticketsystem.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JourneyRepository extends JpaRepository  <Journey,Long> {
    List<Journey> findByoriginAndDestinationAndTravelDateOrderByTravelTimeAsc(
            String origin, String destination, String travelDate
    );
}

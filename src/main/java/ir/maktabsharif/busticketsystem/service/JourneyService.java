package ir.maktabsharif.busticketsystem.service;

import ir.maktabsharif.busticketsystem.model.Journey;
import ir.maktabsharif.busticketsystem.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JourneyService {
    private final JourneyRepository journeyRepository;

    @Autowired
    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }


    public List<Journey> searchJourneys(String origin, String destination, LocalDate date) {
        return journeyRepository.findByoriginAndDestinationAndTravelDateOrderByTravelTimeAsc(
                origin,destination,date
        );
    }
    public Journey findById(Long id){
        return journeyRepository.findById(id).orElseThrow(()-> new RuntimeException("Journey not found"));
    }
    public Journey save(Journey journey){
        return journeyRepository.save(journey);
    }
}

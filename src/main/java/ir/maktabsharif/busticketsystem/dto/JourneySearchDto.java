package ir.maktabsharif.busticketsystem.dto;

import lombok.NonNull;


import java.time.LocalDate;

public record JourneySearchDto(String origin, String destination, LocalDate travelDate) {
    public JourneySearchDto(String origin, String destination, LocalDate travelDate) {
        this.origin = origin;
        this.destination = destination;
        this.travelDate = travelDate;
    }
}

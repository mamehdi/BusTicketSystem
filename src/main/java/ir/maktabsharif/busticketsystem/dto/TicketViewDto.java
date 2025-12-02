package ir.maktabsharif.busticketsystem.dto;

import ir.maktabsharif.busticketsystem.enums.Gender;

import java.time.LocalDate;
import java.time.LocalTime;

public record TicketViewDto(Long ticketId, String holderName, Gender gender, String origin,
                            String destination,LocalDate travelDate, LocalTime travelTime) {
    public TicketViewDto(Long ticketId, String holderName, Gender gender, String origin,
                         String destination, LocalDate travelDate, LocalTime travelTime) {
        this.ticketId = ticketId;
        this.holderName = holderName;
        this.gender = gender;
        this.origin = origin;
        this.destination = destination;
        this.travelDate = travelDate;
        this.travelTime = travelTime;
    }
}

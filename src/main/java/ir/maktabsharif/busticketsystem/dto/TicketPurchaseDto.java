package ir.maktabsharif.busticketsystem.dto;

import ir.maktabsharif.busticketsystem.enums.Gender;
import lombok.*;

public record TicketPurchaseDto(String firstName, String lastName, Gender gender) {
    public TicketPurchaseDto(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}

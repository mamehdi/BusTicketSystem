package ir.maktabsharif.busticketsystem.dto;

import ir.maktabsharif.busticketsystem.enums.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketPurchaseDto{
    private String firstName;

    private String lastName;

    private Gender gender;
}
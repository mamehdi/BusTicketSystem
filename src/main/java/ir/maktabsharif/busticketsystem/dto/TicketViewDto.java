package ir.maktabsharif.busticketsystem.dto;

import ir.maktabsharif.busticketsystem.enums.Gender;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketViewDto{
    private Long ticketId;
    private String holderName;
    private Gender gender;
    private String origin;
    private String destination;
    private LocalDate travelDate;
    private LocalTime travelTime;
}

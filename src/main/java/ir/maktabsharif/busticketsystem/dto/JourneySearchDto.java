package ir.maktabsharif.busticketsystem.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JourneySearchDto {
    private String origin;

    private String destination;

    private LocalDate travelDate;
}
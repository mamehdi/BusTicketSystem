package ir.maktabsharif.busticketsystem.mapper;

import ir.maktabsharif.busticketsystem.dto.TicketViewDto;
import ir.maktabsharif.busticketsystem.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public static TicketViewDto toDto(Ticket ticket) {
        return TicketViewDto.builder().ticketId(ticket.getId())
                .holderName(ticket.getJourneyAppUser().getFullName())
                .gender(ticket.getJourneyAppUser().getGender())
                .origin(ticket.getJourney().getOrigin())
                .destination(ticket.getJourney().getDestination())
                .travelDate(ticket.getJourney().getTravelDate())
                .travelTime(ticket.getJourney().getTravelTime()).build();
    }
}

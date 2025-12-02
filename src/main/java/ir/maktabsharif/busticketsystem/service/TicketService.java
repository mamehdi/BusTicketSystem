package ir.maktabsharif.busticketsystem.service;

import ir.maktabsharif.busticketsystem.model.AppUser;
import ir.maktabsharif.busticketsystem.model.Journey;
import ir.maktabsharif.busticketsystem.model.Ticket;
import ir.maktabsharif.busticketsystem.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final JourneyService journeyService;
    private final UserService userService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, JourneyService journeyService,
    UserService userService) {
        this.ticketRepository = ticketRepository;
        this.journeyService = journeyService;
        this.userService = userService;
    }
    public Ticket purchaseTicket(Long journeyId, Long ticketId,Long userId) {
        Journey journey =journeyService.findById(journeyId);
        Optional<AppUser> user=userService.findById(userId);
        if(!user.isPresent()){
            throw new RuntimeException("User not found");
        }
        if(journey.getAvailabeSeat()==0) {
            throw new RuntimeException("Journey has no available seat");
        }
        journey.setAvailabeSeat(journey.getAvailabeSeat()-1);
        journeyService.save(journey);
        Ticket ticket=Ticket.builder().journey(journey).journeyAppUser(user.get()).build();
        return ticketRepository.save(ticket);
    }
    public List<Ticket> findByUser(AppUser user) {
        return ticketRepository.findByJourneyAppUserOrderByTravelDateAsc(user);
    }
    public Ticket findByIdOrUser(Long id, AppUser user) {
        return ticketRepository.findByIdAndJourneyAppUser(id, user).orElseThrow(()->
                new RuntimeException("Ticket not found"));
    }
    @Transactional
    public void cancelTicket(Long ticketId,AppUser user) {
        Ticket ticket=findByIdOrUser(ticketId,user);
        Journey journey=ticket.getJourney();
        journey.setAvailabeSeat(journey.getAvailabeSeat()+1);
        journeyService.save(journey);
        ticketRepository.delete(ticket);
    }

}

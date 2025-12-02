package ir.maktabsharif.busticketsystem.control;

import ir.maktabsharif.busticketsystem.dto.TicketPurchaseDto;
import ir.maktabsharif.busticketsystem.dto.TicketViewDto;
import ir.maktabsharif.busticketsystem.mapper.TicketMapper;
import ir.maktabsharif.busticketsystem.model.AppUser;
import ir.maktabsharif.busticketsystem.model.Ticket;
import ir.maktabsharif.busticketsystem.service.TicketService;
import ir.maktabsharif.busticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final UserService userService;
    private final TicketMapper mapper;

    @Autowired
    public TicketController(TicketService ticketService, UserService userService, TicketMapper mapper) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/purchase/{journeyId}")
    public String purchaseForm(@PathVariable Long journeyId, Model model) {
        model.addAttribute("journeyId", journeyId);
        model.addAttribute("purchaseDto", new TicketPurchaseDto());
        return "purchase";
    }

    @PostMapping("/purchase/{journeyId}")
    public String doPurchase(@PathVariable Long journeyId,
                             @ModelAttribute("purchaseDto") TicketPurchaseDto dto,
                             @AuthenticationPrincipal User principal,
                             Model model) {
        AppUser user = userService.findByUsername(principal.getUsername()).orElseThrow();
        String title = switch (dto.getGender()) {
            case MALE -> "Mr. ";
            case FEMALE -> "Madam ";
            default -> "";
        };
        String fullHolder = title + dto.getFirstName() + " " + dto.getLastName();
        Ticket t = new Ticket();
        t = ticketService.purchaseTicket(journeyId,t.getId(), user.getId());
        model.addAttribute("ticketId", t.getId());
        return "success";
    }

    @GetMapping("/my")
    public String myTickets(@AuthenticationPrincipal User principal, Model model) {
        AppUser user = userService.findByUsername(principal.getUsername()).orElseThrow();
        List<TicketViewDto> list = ticketService.findByUser(user).stream()
                .map(TicketMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("tickets", list);
        return "my-tickets";
    }

    @GetMapping("/view/{ticketId}")
    public String viewTicket(@PathVariable Long ticketId,
                             @AuthenticationPrincipal User principal, Model model) {
        AppUser user = userService.findByUsername(principal.getUsername()).orElseThrow();
        Ticket t = ticketService.findByIdOrUser(ticketId, user);
        model.addAttribute("ticket", mapper.toDto(t));
        return "ticket-view";
    }

    @PostMapping("/cancel/{ticketId}")
    public String cancelTicket(@PathVariable Long ticketId, @AuthenticationPrincipal User principal, Model model) {
        AppUser user = userService.findByUsername(principal.getUsername()).orElseThrow();
        ticketService.cancelTicket(ticketId, user);
        model.addAttribute("message", "Ticket cancelled successfully");
        return "my-tickets";
    }

}

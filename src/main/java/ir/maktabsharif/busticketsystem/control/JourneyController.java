package ir.maktabsharif.busticketsystem.control;

import ir.maktabsharif.busticketsystem.dto.JourneySearchDto;
import ir.maktabsharif.busticketsystem.model.Journey;
import ir.maktabsharif.busticketsystem.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JourneyController {
    private final JourneyService journeyService;

    @Autowired
    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("searchDto", new JourneySearchDto());
        return "search";
    }

    @PostMapping("/search")
    public String doSearch(@ModelAttribute("searchDto") JourneySearchDto dto, Model model) {
        List<Journey> results = journeyService.searchJourneys(dto.getOrigin(), dto.getDestination(),
                dto.getTravelDate());
        model.addAttribute("results", results);
        return "results";
    }
}

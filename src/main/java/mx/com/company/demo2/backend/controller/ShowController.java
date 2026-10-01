package mx.com.company.demo2.backend.controller;

import lombok.RequiredArgsConstructor;
import mx.com.company.demo2.backend.dto.ShowSearchResponse;
import mx.com.company.demo2.backend.service.ShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping("/search")
    public List<ShowSearchResponse> searchShows(
            @RequestParam("search_query") String searchQuery) {
        return showService.searchShows(searchQuery);
    }

    @GetMapping("/{showId}")
    public Map<String, Object> getShowById(
            @PathVariable Long showId) {
        return showService.getShowById(showId);
    }
}
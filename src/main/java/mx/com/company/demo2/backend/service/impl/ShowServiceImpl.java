package mx.com.company.demo2.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mx.com.company.demo2.backend.client.TvMazeClient;
import mx.com.company.demo2.backend.document.ShowDocument;
import mx.com.company.demo2.backend.dto.CommentResponse;
import mx.com.company.demo2.backend.dto.ShowSearchResponse;
import mx.com.company.demo2.backend.dto.TvMazeSearchResponse;
import mx.com.company.demo2.backend.repository.ShowRepository;
import mx.com.company.demo2.backend.service.CommentService;
import mx.com.company.demo2.backend.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final TvMazeClient tvMazeClient;
    private final ShowRepository showRepository;
    private final CommentService commentService;

    @Override
    public List<ShowSearchResponse> searchShows(String query) {
        return tvMazeClient.searchShows(query)
                .stream()
                .map(this::mapToSearchResponse)
                .toList();
    }

    @Override
    public Map<String, Object> getShowById(Long showId) {
        Map<String, Object> show = showRepository.findById(showId)
                .map(ShowDocument::getData)
                .orElseGet(() -> getAndCacheShow(showId));

        Map<String, Object> response = new LinkedHashMap<>(show);
        response.put("comments", commentService.getCommentsByShowId(showId));

        return response;
    }

    private Map<String, Object> getAndCacheShow(Long showId) {
        Map<String, Object> show = tvMazeClient.getShowById(showId);

        showRepository.save(new ShowDocument(showId, show));

        return show;
    }

    private ShowSearchResponse mapToSearchResponse(
            TvMazeSearchResponse response) {

        var show = response.show();

        String channel = null;

        if (show.network() != null && show.network().name() != null) {
            channel = show.network().name();
        } else if (show.webchannel() != null) {
            channel = show.webchannel().name();
        }

        List<CommentResponse> comments =
                commentService.getCommentsByShowId(show.id());

        return new ShowSearchResponse(
                show.id(),
                show.name(),
                channel,
                show.summary(),
                show.genres(),
                comments
        );
    }
}
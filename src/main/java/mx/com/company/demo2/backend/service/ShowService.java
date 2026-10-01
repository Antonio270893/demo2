package mx.com.company.demo2.backend.service;

import mx.com.company.demo2.backend.dto.ShowSearchResponse;

import java.util.List;
import java.util.Map;

public interface ShowService {

    List<ShowSearchResponse> searchShows(String query);

    Map<String, Object> getShowById(Long showId);
}
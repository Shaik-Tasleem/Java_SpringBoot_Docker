package Apimovie;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TvMazeService {

    private final RestTemplate restTemplate = new RestTemplate();
    public List<TvShowDto> searchShows(String query) {
        String url = "https://api.tvmaze.com/search/shows?q=" + query;
        return restTemplate.getForObject(url, List.class);
    }
}
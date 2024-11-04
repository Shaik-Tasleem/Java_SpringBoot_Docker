package Apimovie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TvShowService {

    private final TvShowRepo tvShowRepository;

    @Autowired
    public TvShowService(TvShowRepo tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    public List<TvShowModel> getAllShows() {
        return tvShowRepository.findAll();
    }

    public Optional<TvShowModel> getShowById(Long id) {
        return tvShowRepository.findById(id);
    }

    public TvShowModel saveShow(TvShowModel show) {
        return tvShowRepository.save(show);
    }

    public void deleteShow(Long id) {
        tvShowRepository.deleteById(id);
    }
}

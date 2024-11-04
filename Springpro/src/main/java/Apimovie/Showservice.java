package Apimovie;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import java.util.List;

@Service
public class Showservice {
    @Autowired
    private ShowRepository showRepository;

    public List<Show> findAll() {
        return showRepository.findAll();
    }

    public Show findById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public Show save(Show show) {
        return showRepository.save(show);
    }

    public void delete(Long id) {
        showRepository.deleteById(id);
    }
}

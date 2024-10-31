package Apimovie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shows")
public class ShowController2 {
	@Autowired
    private  TvShowService tvShowService;
	@Autowired
    private  TvMazeService tvMazeService;
    
    @GetMapping("/test")
    public String testPage() {
        return "test";
    }
    @GetMapping
    public String listShows(Model model) {
        model.addAttribute("shows", tvShowService.getAllShows());
        return "listshow";  
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tvShow", new TvShowModel());
        return "addshow";
    }

    @PostMapping("/add")
    public String addShow(@ModelAttribute TvShowModel tvShow) {
        tvShowService.saveShow(tvShow);
        return "redirect:/shows";
    }

    @GetMapping("/{id}")
    public String viewShow(@PathVariable Long id, Model model) {
        tvShowService.getShowById(id).ifPresent(show -> model.addAttribute("tvShow", show));
        return "viewshow";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        tvShowService.getShowById(id).ifPresent(show -> model.addAttribute("tvShow", show));
        return "editshow";
    }

    @PostMapping("/{id}/edit")
    public String editShow(@PathVariable Long id, @ModelAttribute TvShowModel tvShow) {
        tvShow.setId(id);
        tvShowService.saveShow(tvShow);
        return "redirect:/shows";
    }

    @GetMapping("/{id}/delete")
    public String deleteShow(@PathVariable Long id) {
        tvShowService.deleteShow(id);
        return "redirect:/shows";
    }

    @PostMapping("/search")
    public String searchShows(@RequestParam String query, Model model) {
        model.addAttribute("searchResults", tvMazeService.searchShows(query));
        return "search";
    }
}
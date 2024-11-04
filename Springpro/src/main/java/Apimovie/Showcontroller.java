//package Apimovie;
// 
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.web.client.RestTemplate;
//
// 
//
//@Controller
//@RequestMapping("/shows")
//public class Showcontroller {
//    @Autowired
//    private Showservice showService;
//
//    private final String TVMAZE_API_URL = "https://api.tvmaze.com/search/shows?q=";
//
//    @GetMapping
//    public String listShows(Model model) {
//        model.addAttribute("shows", showService.findAll());
//        return "index";
//    }
//
//    @GetMapping("/add")
//    public String addShowForm() {
//        return "add-show";
//    }
//
//    @PostMapping("/add")
//    public String addShow(@RequestParam String title, Model model) {
//        RestTemplate restTemplate = new RestTemplate();
//        
//        // Fetch the response as an array of objects
//        Map<String, Object>[] results = restTemplate.getForObject(TVMAZE_API_URL + title, Map[].class);
//        
//        if (results != null && results.length > 0) {
//            // Extract the show object from the first result
//            Map<String, Object> showData = (Map<String, Object>) results[0].get("show");
//            
//            Show show = new Show();
//            show.setId(((Number) showData.get("id")).longValue()); // Handle id correctly
//            show.setTitle((String) showData.get("name"));
//            show.setReleaseYear(Integer.parseInt(((String) showData.get("premiered")).substring(0, 4))); // Extract year from date
//            show.setGenres(String.join(", ", (Iterable< CharSequence>) showData.get("genres"))); // Join genres into a string
//            show.setSynopsis((String) showData.get("summary")); // Use the summary
//
//            model.addAttribute("show", show);
//        } else {
//            model.addAttribute("error", "No shows found for the given title.");
//        }
//        
//        return "show-details"; // Display details for confirmation
//    }
//
//
//
//
//    @PostMapping("/confirm")
//    public String confirmAddShow(@ModelAttribute Show show) {
//        showService.save(show);
//        return "redirect:/shows";
//    }
//
//    @GetMapping("/{id}")
//    public String showDetails(@PathVariable Long id, Model model) {
//        model.addAttribute("show", showService.findById(id));
//        return "show-details";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editShowForm(@PathVariable Long id, Model model) {
//        model.addAttribute("show", showService.findById(id));
//        return "edit-show";
//    }
//
//    @PostMapping("/{id}/edit")
//    public String editShow(@PathVariable Long id, @ModelAttribute Show show) {
//        show.setId(id);
//        showService.save(show);
//        return "redirect:/shows";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String deleteShow(@PathVariable Long id) {
//        showService.delete(id);
//        return "redirect:/shows";
//    }
//}
//

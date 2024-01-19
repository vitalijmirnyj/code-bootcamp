package lt.techin.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private ArrayList<String> movies = new ArrayList<>(List.of("Toy Story", "A Bug's Life", "Toy Story 2", "Monsters Inc", "Finding Nemo"));

    @GetMapping("/movies")
    public ArrayList<String> getMovies() {
        return this.movies;
    }
}

package lt.techin.demo.controllers;

import lt.techin.demo.models.Actors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorsController {

    private ArrayList<Actors> actors = new ArrayList<>(List.of(new Actors(1L, "Male", (short) 49, "USA", "Leonardo", "Dicaprio")));

    @GetMapping("/actors")
    public ArrayList<Actors> getMovies() {
        return this.actors;
    }

    @GetMapping("/actors/{index}")
    public Actors getActors(@PathVariable int index) {
        return this.actors.get(index);
    }
}


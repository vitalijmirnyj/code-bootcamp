package lt.techin.demo.controllers;

import lt.techin.demo.models.Actors;
import lt.techin.demo.repositories.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorsController {

    private final ActorsRepository actorsRepository;

    @Autowired
    public ActorsController(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    @GetMapping("/actors")
    public List<Actors> getActors() {
        return this.actorsRepository.findAll();
    }

    @GetMapping("/actors/{index}")
    public Actors getActor(@PathVariable int index) {
        return null;
    }
}
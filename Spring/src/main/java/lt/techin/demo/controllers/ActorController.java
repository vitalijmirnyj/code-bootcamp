package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ActorController {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/actors")
    public List<Actor> getActors() {
        return this.actorRepository.findAll();
    }


    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable long id) {
        return this.actorRepository.findById(id).orElseThrow();

    }

    @PostMapping("/actors")
    public void insertActor(@RequestBody Actor actor) {
        this.actorRepository.save(actor);
    }

    @PutMapping("/actors/{id}")
    public void updateActor(@RequestBody Actor actor, @PathVariable long id) {
        Actor actorFromDb = this.actorRepository.findById(id).orElseThrow();
        actorFromDb.setGender(actor.getGender());
        actorFromDb.setAge(actor.getAge());
        actorFromDb.setNationality(actor.getNationality());
        actorFromDb.setName(actor.getName());
        actorFromDb.setSurname(actor.getSurname());
        this.actorRepository.save(actorFromDb);
    }
}
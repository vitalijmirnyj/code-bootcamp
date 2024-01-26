package lt.techin.demo.Services;


import lt.techin.demo.models.Actor;

import lt.techin.demo.repositories.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository actorRepository;


    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAllActors() {
        return this.actorRepository.findAll();
    }

    public Actor findActorById(long id) {
        return this.actorRepository.findById(id).orElseThrow();
    }

    public Actor saveActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    public void deleteActorById(long id) {
        this.actorRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return this.actorRepository.existsById(id);
    }
}

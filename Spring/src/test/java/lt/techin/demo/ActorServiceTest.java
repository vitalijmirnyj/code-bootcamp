package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.services.ActorService;
import lt.techin.demo.models.Actor;
import lt.techin.demo.repositories.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.NoSuchElementException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@ActiveProfiles("test")
public class ActorServiceTest {

    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorRepository actorRepository;

    @Test
    void findAllActors_saveActors_returned() {
        Actor savedActor = this.actorRepository.save(new Actor(1, "Male", (short) 55, "USA", "Tom", "Cruise"));
        Actor savedActor2 = this.actorRepository.save(new Actor(1, "Male", (short) 60, "USA", "Tom", "Hanks"));
        Actor foundActor = this.actorService.findActorById(savedActor.getId());
        then(foundActor).isEqualTo(savedActor);
        Actor foundActor2 = this.actorService.findActorById(savedActor2.getId());
        then(foundActor2).isEqualTo(savedActor2);
    }

    @Test
    void findActorById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(() -> this.actorService.findActorById(1));
        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void saveActor() {

        Actor savedActor = this.actorService.saveActor(new Actor(1, "Male", (short) 55, "USA", "Tom", "Cruise"));

        Actor foundActor = this.actorRepository.findById(savedActor.getId()).orElse(null);
        then(savedActor).isEqualTo(foundActor);

    }

    @Test
    void existsActorById_CheckIfExists_ReturnTrue() {
        Actor savedActor = this.actorRepository.save(new Actor(1, "Male", (short) 55, "USA", "Tom", "Cruise"));
        boolean existsActor = this.actorService.existsById(savedActor.getId());
        then(existsActor).isTrue();
    }

    @Test
    void deleteActorById_delete_cannotFind() {
        Actor savedActor = this.actorRepository.save(new Actor(1, "Male", (short) 55, "USA", "Tom", "Cruise"));
        this.actorService.deleteActorById(savedActor.getId());
        then(this.actorRepository.existsById(savedActor.getId())).isFalse();
    }


}
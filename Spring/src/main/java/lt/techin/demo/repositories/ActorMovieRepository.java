package lt.techin.demo.repositories;

import lt.techin.demo.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieRepository extends JpaRepository<Actor, Long> {
}

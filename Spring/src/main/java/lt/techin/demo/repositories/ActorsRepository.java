package lt.techin.demo.repositories;

import lt.techin.demo.models.Actors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorsRepository extends JpaRepository<Actors, Long> {
}
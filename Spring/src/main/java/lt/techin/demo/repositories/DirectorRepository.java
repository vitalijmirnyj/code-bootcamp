package lt.techin.demo.repositories;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}

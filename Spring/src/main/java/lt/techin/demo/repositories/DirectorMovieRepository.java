package lt.techin.demo.repositories;


import lt.techin.demo.models.DirectorMovie;
import lt.techin.demo.models.DirectorMovieId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorMovieRepository extends JpaRepository<DirectorMovie, DirectorMovieId> {

}


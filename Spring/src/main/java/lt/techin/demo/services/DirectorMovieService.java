package lt.techin.demo.services;

import lt.techin.demo.models.DirectorMovie;
import lt.techin.demo.models.DirectorMovieId;
import lt.techin.demo.models.Movie;
import lt.techin.demo.models.User;
import lt.techin.demo.repositories.DirectorMovieRepository;
import lt.techin.demo.repositories.MovieRepository;
import lt.techin.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorMovieService {

    private final DirectorMovieRepository directorMovieRepository;

    @Autowired
    public DirectorMovieService(DirectorMovieRepository directorMovieRepository) {
        this.directorMovieRepository = directorMovieRepository;
    }


    public List<DirectorMovie> findAllDirectorsMovies() {
        return this.directorMovieRepository.findAll();
    }

    public DirectorMovie findDirectorMovieById(DirectorMovieId directorMovieId) {
        return this.directorMovieRepository.findById(directorMovieId).orElseThrow();
    }

    public DirectorMovie saveDirectorMovie(DirectorMovie directorMovie) {
        return this.directorMovieRepository.save(directorMovie);
    }

    public void deleteDirectorMovieById(DirectorMovieId directorMovieId) {
        this.directorMovieRepository.deleteById(directorMovieId);
    }

    public boolean existsById(DirectorMovieId directorMovieId) {
        return this.directorMovieRepository.existsById(directorMovieId);
    }


}


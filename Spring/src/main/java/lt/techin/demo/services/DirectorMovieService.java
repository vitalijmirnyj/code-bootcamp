package lt.techin.demo.services;

import lt.techin.demo.models.DirectorMovie;
import lt.techin.demo.models.User;
import lt.techin.demo.repositories.DirectorMovieRepository;
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

    public DirectorMovie findDirectorMovieByDirectorIdAndMovieId(long directorId, long movieId) throws ChangeSetPersister.NotFoundException {
        return this.directorMovieRepository.findByDirectorIdAndMovieId(directorId, movieId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public DirectorMovie saveDirectorMovie(DirectorMovie directorMovie) {
        return this.directorMovieRepository.save(directorMovie);
    }

    public void deleteDirectorMovieById(long directorId, long movieId) {
        this.directorMovieRepository.deleteByDirectorIdAndMovieId(directorId, movieId);
    }

    public boolean existsDerictorMovieById(long directorId, long movieId) {
        return this.directorMovieRepository.existsById(directorId, movieId);
    }
}

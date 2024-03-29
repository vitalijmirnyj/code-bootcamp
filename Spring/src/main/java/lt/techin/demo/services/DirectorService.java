package lt.techin.demo.services;

import lt.techin.demo.models.Director;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.DirectorRepository;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> findAllDirectors() {
        return this.directorRepository.findAll();
    }

    public Director findDirectorById(long id) {
        return this.directorRepository.findById(id).orElseThrow();
    }

    public Director saveDirector(Director director) {
        return this.directorRepository.save(director);
    }

    public void deleteDirectorById(long id) {
        this.directorRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return this.directorRepository.existsById(id);
    }
}

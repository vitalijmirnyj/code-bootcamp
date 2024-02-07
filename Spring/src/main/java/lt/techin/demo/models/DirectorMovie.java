package lt.techin.demo.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Directors_movies")
public class DirectorMovie {

    @EmbeddedId
    private DirectorMovieId directorMovieId;

    private String role;

    public DirectorMovieId getDirectorMovieId() {
        return directorMovieId;
    }

    public void setDirectorMovieId(DirectorMovieId directorMovieId) {
        this.directorMovieId = directorMovieId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


}

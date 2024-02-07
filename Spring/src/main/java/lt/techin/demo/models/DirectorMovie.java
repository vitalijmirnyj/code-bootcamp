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


}

package lt.techin.demo.models;

import jakarta.persistence.*;


@Entity
@Table(name = "Actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String gender;
    private short age;
    private String nationality;
    private String name;

    private String surname;

    public Actor(long id, String gender, short age, String nationality, String name, String surname) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
        this.name = name;
        this.surname = surname;
    }

    public Actor() {

    }

    public long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public short getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}


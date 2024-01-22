package lt.techin.demo.models;

public class Actors {
    private long id;
    private String gender;
    private short age;
    private String nationality;
    private String name;

    private String surname;

    public Actors(long id, String gender, short age, String nationality, String name, String surname) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
        this.name = name;
        this.surname = surname;
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
}


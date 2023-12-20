
public class MainProgram {

    public static void main(String[] args) {
        Pet pet = new Pet("Lucy", "Labrador");
        Person person = new Person("Tom", pet);
        System.out.println(person);
    }
}

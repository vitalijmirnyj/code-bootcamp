
public class HealthStation {


    private int howManyWeighs = 0;

    public int weigh(Person person) {
        howManyWeighs = howManyWeighs + 1;
        return person.getWeight();

    }

    public void feed(Person person) {
        int weight = person.getWeight();
        person.setWeight(weight + 1);
    }

    public int weighings() {
        return howManyWeighs;
    }

}

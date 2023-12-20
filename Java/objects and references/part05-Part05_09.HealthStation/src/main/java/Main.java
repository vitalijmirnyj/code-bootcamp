
public class Main {

    public static void main(String[] args) {

        Person personTom = new Person("Tom", 25, 175, 7);
        Person personMatt = new Person("Matt", 35, 165, 85);

        HealthStation healthStation = new HealthStation();

        int weightOfTom = healthStation.weigh(personTom);
        System.out.println(personTom + "weight: " + weightOfTom + " kilos");

        int weightOfMatt = healthStation.weigh(personMatt);
        System.out.println(personMatt + "weight: " + weightOfMatt + " kilos");

        healthStation.feed(personTom);
        healthStation.feed(personTom);
        healthStation.feed(personTom);

        int weightOfTomAfterFeed = healthStation.weigh(personTom);
        System.out.println(personTom + "weight: " + weightOfTomAfterFeed + " kilos");

        int anotherWeighOfMatt = healthStation.weigh(personMatt);
        System.out.println(personMatt + "weight: " + anotherWeighOfMatt + " kilos");

        System.out.println("weighings performed: " + healthStation.weighings());
    }
}

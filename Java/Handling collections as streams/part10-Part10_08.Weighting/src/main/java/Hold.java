

import java.util.ArrayList;

public class Hold {

    private ArrayList<Suitcase> suitcases;
    private int maximumWeight;

    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeight() + suitcase.totalWeight() > maximumWeight) {
            return;
        }

        this.suitcases.add(suitcase);
    }

    public int totalWeight() {
        return suitcases.stream()
                .mapToInt(Suitcase::totalWeight)
                .sum();
    }

    public void printItems() {
        suitcases.stream()
                .map(person -> person.getItems())
                .forEach(name -> System.out.println(name));

    }

    @Override
    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }

        if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.totalWeight() + " kg)";
        }

        return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}
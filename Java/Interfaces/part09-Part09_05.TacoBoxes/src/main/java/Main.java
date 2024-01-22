
public class Main {

    public static void main(String[] args) {
        TripleTacoBox tripleTacoBox = new TripleTacoBox();

        int remainingTacos = tripleTacoBox.tacosRemaining();
        System.out.println("Remaining Tacos: " + remainingTacos);

        tripleTacoBox.eat();

        remainingTacos = tripleTacoBox.tacosRemaining();
        System.out.println("Remaining Tacos after eating: " + remainingTacos);
    }
}

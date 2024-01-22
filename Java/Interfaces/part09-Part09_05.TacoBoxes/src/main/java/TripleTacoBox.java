public class TripleTacoBox implements TacoBox {

    private int tacos = 3;

    public TripleTacoBox() {

    }

    @Override
    public int tacosRemaining() {
        return tacos;
    }

    @Override
    public void eat() {
        if (tacos > 0) {
            tacos = tacos - 1;
        } else {
            tacos = 0;
        }
    }
}


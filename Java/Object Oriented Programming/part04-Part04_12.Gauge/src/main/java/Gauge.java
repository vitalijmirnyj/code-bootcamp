public class Gauge {
    private int value;

    public Gauge() {

    }
    public void increase() {
        if (value < 5) {
            value = value + 1;
        } else {
            System.out.println("Limit is reached");
        }
    }
    public void decrease() {
        if (value > 0) {
            value = value - 1;
        } else {
            System.out.println("Cannot be negative value");
        }
    }
    public int value() {
        return value;
    }
    public boolean full() {
        if (value == 5) {
            return true;
        } else {
            return false;
        }
    }
}

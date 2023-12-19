public class Counter {
    private int number;

    public Counter(int startValue) {
        this.number = startValue;
    }

    public Counter() {
        this.number = 0;
    }

    public int value() {
        return this.number;
    }

    public void increase() {
        this.number += 1;
    }

    public void decrease() {
        this.number = this.number - 1;
    }

    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            this.number += increaseBy;
        }
    }

    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            this.number -= decreaseBy;
        }
    }

    @Override
    public String toString() {
        return "Balance is " + this.number;
    }
}


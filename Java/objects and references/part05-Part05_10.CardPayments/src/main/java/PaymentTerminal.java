public class PaymentTerminal {
    private double money = 1000;
    private int affordableMeals;
    private int heartyMeals;

    public PaymentTerminal() {

    }

    public double eatAffordably(double payment) {
        double moneyToReturn;

        if (payment < 2.50) {
            return payment;

        } else {
            moneyToReturn = payment - 2.50;
            money = money + payment - moneyToReturn;
            affordableMeals += 1;
            return moneyToReturn;
        }
    }

    public double eatHeartily(double payment) {
        double moneyToReturn;

        if (payment < 4.30) {
            return payment;

        } else {
            moneyToReturn = payment - 4.30;
            money = money + payment - moneyToReturn;
            heartyMeals += 1;
            return moneyToReturn;
        }
    }

    public boolean eatAffordably(PaymentCard card) {

        if (card.balance() < 2.50) {
            return false;

        } else {
            card.takeMoney(2.50);
            affordableMeals += 1;
            return true;
        }


    }

    public boolean eatHeartily(PaymentCard card) {

        if (card.balance() < 4.30) {
            return false;

        } else {
            card.takeMoney(4.30);
            heartyMeals += 1;
            return true;
        }

    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum > 0) {
            card.addMoney(sum);
            money += sum;
        }
    }

    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
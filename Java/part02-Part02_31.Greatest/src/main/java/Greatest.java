public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        int greatestNumber;

        if (number1 > number2) {
            greatestNumber = number1;
        } else {
            greatestNumber = number2;
        }

        if (greatestNumber > number3) {
            return greatestNumber;
        } else {
            greatestNumber = number3;
            return greatestNumber;
        }
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}

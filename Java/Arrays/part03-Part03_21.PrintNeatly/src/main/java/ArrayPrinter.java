
public class ArrayPrinter {

    public static void main(String[] args) {
        int[] array = {5, 1, 3, 4, 2};
        printNeatly(array);
    }

    public static void printNeatly(int[] array) {
        
        for (int i = 0; i <= array.length - 2; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }
}
import java.util.Scanner;
import java.util.ArrayList;

public class Items {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Item> arrayList = new ArrayList<>();

        System.out.println("Name:");
        while (true) {
            String input = scan.nextLine();
            Item item = new Item(input);
            arrayList.add(item);
            if (input == "") {
                break;
            }
        }
        for (int i = 0; i <= arrayList.size() - 1; i++) {
            Item object = arrayList.get(i);
            System.out.println(object);

        }

    }
}

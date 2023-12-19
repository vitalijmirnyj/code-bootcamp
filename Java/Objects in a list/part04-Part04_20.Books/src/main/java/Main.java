import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Book> arrayList = new ArrayList<>();

        while (true) {
            System.out.println("Title:");
            String input = scan.nextLine();

            if (input.isEmpty()) {
                break;
            }

            System.out.println("Pages:");
            int pagesInput = Integer.valueOf(scan.nextLine());

            System.out.println("Publication year:");
            int yearInput = Integer.valueOf(scan.nextLine());

            Book book = new Book(input, pagesInput, yearInput);
            arrayList.add(book);
        }

        System.out.println("What information will be printed?");
        String whatToPrint = scan.nextLine();

        for (int i = 0; i <= arrayList.size() - 1; i++) {

        if (whatToPrint.equals("everything")) {
            Book bookObject = arrayList.get(i);
            System.out.println(bookObject);

        } else if (whatToPrint.equals("name")) {
            Book bookObject = arrayList.get(i);
            System.out.println(bookObject.getTitle());
        }

            }
        }
    }


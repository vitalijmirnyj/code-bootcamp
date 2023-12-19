import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<TelevisionProgram> arrayList = new ArrayList<>();

        while (true) {
            System.out.println("Name:");
            String input = scan.nextLine();

            if (input.isEmpty()) {
                break;
            }

            System.out.println("Duration:");
            int inputNumber = Integer.valueOf(scan.nextLine());
            TelevisionProgram tvProgram = new TelevisionProgram(input, inputNumber);
            arrayList.add(tvProgram);
        }
        System.out.println("Program's maximum duration?");
        int maxDuration = Integer.valueOf(scan.nextLine());

        for (int i = 0; i <= arrayList.size() - 1; i++) {
            TelevisionProgram firstTvShow = arrayList.get(i);

            if (firstTvShow.getDuration() <= maxDuration) {
                System.out.println(firstTvShow);
            }
        }
    }
}

import java.util.Scanner;
import java.util.ArrayList;
public class PersonalInformationCollection {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<PersonalInformation> arrayList = new ArrayList<>();
while (true) {
    System.out.println("First name:");
    String input = scan.nextLine();
    if (input.isEmpty()) {
        break;
    }
    System.out.println("Last name:");
    String input2 = scan.nextLine();
    System.out.println("Identification number:");
    String idNumber = scan.nextLine();
    PersonalInformation personalInfo = new PersonalInformation(input, input2, idNumber);
    arrayList.add(personalInfo);

}
for (int i = 0; i <= arrayList.size() - 1; i++) {
    PersonalInformation person = arrayList.get(i);
    System.out.println(person.getFirstName() + " " + person.getLastName());
    System.out.println();
}
    }
}

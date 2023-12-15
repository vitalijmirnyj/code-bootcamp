
public class YourFirstAccount {

    public static void main(String[] args) {
    Account myAccount = new Account("Vitalijus", 100);

    myAccount.deposit(20);
      String myBalance = myAccount.toString();
        System.out.println(myBalance);
    }
}

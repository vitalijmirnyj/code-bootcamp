
public class YourFirstBankTransfer {

    public static void main(String[] args) {
      Account mathewsAccount = new Account("Matthews account", 1000);
      Account myAccount = new Account("My account", 0);
      mathewsAccount.withdrawal(100);
      myAccount.deposit(100);
        System.out.println(mathewsAccount);
        System.out.println(myAccount);

    }
}

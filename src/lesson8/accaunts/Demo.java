package lesson8.accaunts;

/**
 * Created by MM on 10.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("SomeBank", "Denis", 1000, 50);
        savingAccount.deposinMoney(100);

        System.out.println(savingAccount.moneyAmount);
        savingAccount.changeOfTheName("Oleg");
        System.out.println(savingAccount.ownerName);

        //----------------------------------

        CheckingAccount checkingAccount = new CheckingAccount("SomeBank", "Denis", 1000, 500);
        checkingAccount.changeOfTheName("Oleg");

        System.out.println(checkingAccount.ownerName);
    }
}

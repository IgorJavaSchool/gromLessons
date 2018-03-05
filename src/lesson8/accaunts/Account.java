package lesson8.accaunts;

/**
 * Created by MM on 10.12.2017.
 */
public class Account {
    String bankName;
    String ownerName;
    int moneyAmount;

    public Account(String bankName, String ownerName, int moneyAmount) {
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.moneyAmount = moneyAmount;
    }

    void deposinMoney(int amount){
        moneyAmount += amount;
    }

    void deposinMoney(){
        moneyAmount +=1000;
        System.out.println("Deposit was successful");
    }

    void changeOfTheName(String newOwnerName){
        ownerName = newOwnerName;
    }


}

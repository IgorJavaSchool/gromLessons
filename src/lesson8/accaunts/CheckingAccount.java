package lesson8.accaunts;

/**
 * Created by MM on 10.12.2017.
 */
public class CheckingAccount extends Account {
    int limitOfExpenses;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOfExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOfExpenses = limitOfExpenses;
    }

    void withdraw(int amount){
        if (amount > limitOfExpenses)
            return;
        moneyAmount -= amount;
    }


}

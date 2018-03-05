package lesson12;

/**
 * Created by MM on 14.12.2017.
 */
public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount) || !checkBalance(user, amount)) {
            return;
        }
        double balanceAfterWithdraw = user.getBalance() - amountWithCommission(user, amount);
        user.setBalance(balanceAfterWithdraw);
    }

    @Override
    public void fund(User user, int amount) {
        if (user.getBank().getLimitOfFunding() > amount)
        user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount) || !checkBalance(fromUser, amount))
            return;
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())
            return;
            withdraw(fromUser, amount);
            fund(toUser, amount);
    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());
    }

    /**
     * Checks limit from user. If the limit is less of the amount with commission.
     * @param user
     * @param amount
     * @return
     */
    private boolean checkWithdraw(User user, int amount){
        if (user.getBank().getLimitOfWithdrawal() < amountWithCommission(user, amount)) {
            printErrorWithdraw(user, amount);
            return false;
        }
        else return true;
    }

    /**
     * Checks balance from user. If the balance is less of the amount with commission.
     * @param user
     * @param amount
     * @return
     */
    private boolean checkBalance(User user, int amount){
        if (user.getBalance() < amountWithCommission(user, amount)){
            printErrorWithdraw(user, amount);
            return false;
        }
        else return true;
    }

    /**
     * Returns amount + commission.
     * @param user
     * @param amount
     * @return
     */
    private double amountWithCommission(User user, int amount){
        return amount + amount * user.getBank().getCommission(amount);
    }

    /**
     * Prints the error message, where the user can't withdraw his money.
     * @param user
     * @param amount
     */
    private void printErrorWithdraw(User user, int amount){
        System.err.println("Can't withdraw many " + amount + "for user " + user.toString());
    }
}

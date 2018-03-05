package lesson30.bankSystem;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by MM on 14.12.2017.
 */
public class UkrainianBankSystem implements BankSystem {
    private Random randomId = new Random();
    private Set<Transaction> transactions = new TreeSet<>();
    private boolean isWithdraw;
    private boolean isFund;

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount) || !checkBalance(user, amount)) {
            createAndSaveTransaction(TransactionType.WITHDRAWAL, 0, "Transaction withdraw is false");
            isWithdraw = false;
            return;
        }
        double balanceAfterWithdraw = user.getBalance() - amountWithCommission(user, amount);
        user.setBalance(balanceAfterWithdraw);
        createAndSaveTransaction(TransactionType.WITHDRAWAL, amount, "Transaction withdraw is tru");
        isWithdraw = true;

    }

    @Override
    public void fund(User user, int amount) {
        if (user.getBank().getLimitOfFunding() > amount) {
            user.setBalance(user.getBalance() + amount);
            createAndSaveTransaction(TransactionType.FUNDING, amount, "Transaction fund is tru");
            isFund = true;
        } else
            createAndSaveTransaction(TransactionType.FUNDING, 0, "Transaction fund is false");
        isFund = false;

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount) || !checkBalance(fromUser, amount)) {
            createAndSaveTransaction(TransactionType.TRANSFER, 0, "Transaction transfer is false");
            return;
        }
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            createAndSaveTransaction(TransactionType.TRANSFER, 0, "Transaction transfer is false");
            return;
        }
            withdraw(fromUser, amount);
        if (isWithdraw) {
            fund(toUser, amount);
        }
        if (isWithdraw && isFund) {
            createAndSaveTransaction(TransactionType.TRANSFER, amount, "Transaction transfer is false");
        } else
            createAndSaveTransaction(TransactionType.TRANSFER, 0, "Transaction transfer is false");

    }

    @Override
    public void paySalary(User user) {
        if (isFund) {
            fund(user, user.getSalary());
            createAndSaveTransaction(TransactionType.SALARY, user.getSalary(), "Transaction salary is true");
        } else
            createAndSaveTransaction(TransactionType.SALARY, 0, "Transaction salary is false");

    }

    public Set<Transaction> getTransactions() {
        return transactions;
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

    /**
     * Creates and adds a new transaction after each operation in mini db.
     * @param type
     * @param amount
     * @param description
     */
    private void createAndSaveTransaction(TransactionType type, int amount, String description){
        transactions.add(new Transaction(randomId.nextInt(), new Date(), null, type, amount, description));
    }

}

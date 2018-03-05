package lesson12;


/**
 * Created by MM on 14.12.2017.
 */
public interface BankSystem {

    void withdraw(User user, int amount);
    void fund(User user, int amount);
    void transferMoney(User fromUser, User toUser, int amount);
    void paySalary(User user);
}

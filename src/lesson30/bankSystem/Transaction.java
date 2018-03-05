package lesson30.bankSystem;

import java.util.Date;

/**
 * Created by MM on 24.12.2017.
 */
public class Transaction implements Comparable<Transaction> {
    private long id;
    private Date dateCreate;
    private Date dateConfirm;
    private TransactionType type;
    private int amount;
    private String description;

    public Transaction(long id, Date dateCreate, Date dateConfirm, TransactionType type, int amount, String description) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.dateConfirm = dateConfirm;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public int compareTo(Transaction o) {
        return o.dateCreate.compareTo(this.dateCreate);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", dateCreate= " + dateCreate +
                ", dateConfirm= " + dateConfirm +
                ", type=" + type +
                ", amount=" + amount +
                ", description= '" + description + '\'' +
                '}';
    }
}

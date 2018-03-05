package lesson30.bankSystem;

/**
 * Created by MM on 14.12.2017.
 */
public class USBank extends Bank {

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 1000 : 1200;
    }

    @Override
    public int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 10000 : Integer.MAX_VALUE;
    }

    @Override
    public double getMonthlyRate() {
        return getCurrency() == Currency.USD ? 0.01 : 0.02;
    }

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.05;
            else return 0.07;
        }
        else {
            if (getCurrency() == Currency.EUR) {
                if (amount <= 1000)
                    return 0.06;
                else return 0.08;
            }
        }
        return 0;
    }
}

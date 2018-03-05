package lesson5;

import java.util.Arrays;

/**
 * Created by MM on 20.11.2017.
 */
public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 8, 0};

        System.out.println(Arrays.toString(findClientsByBalances(names, balances, 500)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalances(names, balances)));
        depositMoney(names, balances, "Ann", 1000);
        System.out.println(Arrays.toString(balances));
        withdraw(names, balances, "Denis", -5);
        System.out.println(Arrays.toString(balances));

    }

    static String[] findClientsByBalances(String[] clients, int[] balances, int n) {
        int count = 0;
        for (int balance : balances) {
            if (balance >= n) {
                count++;
            }
        }
        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances){
            if (balance >= n){
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    static String[] findClientsWithNegativeBalances(String[] clients, int[] balances){
        int count = 0;
        for (int balance : balances) {
            if (balance < 0) {
                count++;
            }
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances){
            if (balance < 0){
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    static void depositMoney(String[] clients, int[] balances, String client, int money){
//        int clientIndex = findClientIndexByName(clients, client);

//        int moneyDeposit = calculateDepositAmountAfterComission(money);
        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterComission(money);
    }

    static int findClientIndexByName(String[] clients, String client){
        int clientIndex = 0;
        for (String cl : clients){
            if (cl.equals(client)){
                break;
            }
            clientIndex++;
        }

        return clientIndex;
    }

    static int calculateDepositAmountAfterComission(int money){
        return money <= 100 ? (int)(money - money * 0.02) : (int)(money - money * 0.01);
    }

    static void withdraw(String[] clients, int[] balances, String client, int amount){
        if (amount <= 0) return;
        int clientIndex = 0;
        for (String cl : clients){
            if (cl.equals(client)){
                break;
            }
            clientIndex++;
        }
        balances[clientIndex] = amount > balances[clientIndex] ? -1 : balances[clientIndex] - amount;
    }

}

package lesson5;

/**
 * Created by MM on 20.11.2017.
 */
public class WithdrawMoney {


//    static String[] findClientsByBalances(String[] clients, int[] balances, int n) {
//        int count = 0;
//        for (int balance : balances) {
//            if (balance >= n) {
//                count++;
//            }
//        }
//        String[] results = new String[count];
//
//        int index = 0;
//        int resIndex = 0;
//        for (int balance : balances){
//            if (balance >= n){
//                results[resIndex] = clients[index];
//                resIndex++;
//            }
//            index++;
//        }
//        return results;
//    }
//
//    static String[] findClientsWithNegativeBalances(String[] clients, int[] balances){
//        int count = 0;
//        for (int balance : balances) {
//            if (balance < 0) {
//                count++;
//            }
//        }
//
//        String[] results = new String[count];
//
//        int index = 0;
//        int resIndex = 0;
//        for (int balance : balances){
//            if (balance < 0){
//                results[resIndex] = clients[index];
//                resIndex++;
//            }
//            index++;
//        }
//        return results;
//    }
//
//    static void depositMoney(String[] clients, int[] balances, String client, int money){
////        int clientIndex = findClientIndexByName(clients, client);
//
////        int moneyDeposit = calculateDepositAmountAfterComission(money);
//        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterComission(money);
//    }
//
//    static int findClientIndexByName(String[] clients, String client){
//        int clientIndex = 0;
//        for (String cl : clients){
//            if (cl.equals(client)){
//                break;
//            }
//            clientIndex++;
//        }
//
//        return clientIndex;
//    }
//
//    static int calculateDepositAmountAfterComission(int money){
//        return money <= 100 ? (int)(money - money * 0.02) : (int)(money - money * 0.01);
//    }

    public int withdraw(String[] clients, int[] balances, String client, int amount){
        if (clients == null || balances == null || client == null)
            return -1;

        if (amount < 0) return -1;

        if (balances.length < 1)
            return -1;

        int clientIndex = 0;
        for (String cl : clients){
            if (cl == null)
                return -1;
            if (cl.equals(client)){
                break;
            }
            clientIndex++;
        }
        if (amount > balances[clientIndex]){
            return -1;
        } else return balances[clientIndex] = balances[clientIndex] - amount;
    }
}

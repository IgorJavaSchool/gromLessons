package lesson5;

import java.util.Arrays;

/**
 * Created by MM on 15.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * Tests two methods. Sort to up and sort to down.
         */

        SortArrays sortArrays = new SortArrays();
        int[] sortUp = {1,2,3,-1,8,5,6,3,2,1};
        int[] sortDown = {9,6,3,2,1,1,2,3,1};
        int[] sortEmpty = new int[]{};
        int[] sortNull = null;
        System.out.println("Tests two methods. Sort to up and sort to down.");
        System.out.println(Arrays.toString(sortArrays.sortAscending(sortUp)));
        System.out.println(Arrays.toString(sortArrays.sortAscending(sortDown)));
        System.out.println(Arrays.toString(sortArrays.sortDescending(sortUp)));
        System.out.println(Arrays.toString(sortArrays.sortDescending(sortDown)));
        System.out.println(Arrays.toString(sortArrays.sortDescending(sortEmpty)));
        System.out.println(Arrays.toString(sortArrays.sortDescending(sortNull)));
        System.out.println(Arrays.toString(sortArrays.sortAscending(sortEmpty)));
        System.out.println(Arrays.toString(sortArrays.sortAscending(sortNull)));
        System.out.println();



        /**
         *Tests method withdraw.
         */
        WithdrawMoney withdrawMoney = new WithdrawMoney();
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 8, 0};

        String[] namesWithNull = {"Jack", null, "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balancesEmpty = new int[]{};

        System.out.println("Tests method withdraw.");
        System.out.println(Arrays.toString(balances));
        System.out.println(withdrawMoney.withdraw(names, balances, "Denis", 1000));
        System.out.println(Arrays.toString(balances));

        System.out.println(Arrays.toString(balances));
        System.out.println(withdrawMoney.withdraw(names, balances, "Denis", 10000));
        System.out.println(Arrays.toString(balances));

        System.out.println(Arrays.toString(balances));
        System.out.println(withdrawMoney.withdraw(names, balances, "Denis", -2));
        System.out.println(Arrays.toString(balances));


        System.out.println(Arrays.toString(balances));
        System.out.println(withdrawMoney.withdraw(names, balances, null, 10000));
        System.out.println(Arrays.toString(balances));

        System.out.println(Arrays.toString(balances));
        System.out.println(withdrawMoney.withdraw(namesWithNull, balances, "Denis", 10000));
        System.out.println(Arrays.toString(balances));

        System.out.println(Arrays.toString(balances));
        System.out.println(withdrawMoney.withdraw(names, null, "Denis", 10000));
        System.out.println(Arrays.toString(balances));

        System.out.println(Arrays.toString(balances));
        System.out.println(withdrawMoney.withdraw(names, balancesEmpty, "Denis", 10000));
        System.out.println(Arrays.toString(balances));
        System.out.println();


        /**
         * Tests method uniqueCount.
         */
        CounterUnique counterUnique = new CounterUnique();
        int[] arraysTrue = new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        int[] arraysNull = null;
        int[] arraysEmpty = new int[]{};
        int[] arraysOne = new int[]{1};
        int[] arraysTwo = new int[]{1, 1};
        int[] arraysNegative = new int[]{-1, 1, 2};
        System.out.println("Tests method uniqueCount.");
        System.out.println(counterUnique.uniqueCount(arraysTrue));
        System.out.println(counterUnique.uniqueCount(arraysNull));
        System.out.println(counterUnique.uniqueCount(arraysEmpty));
        System.out.println(counterUnique.uniqueCount(arraysOne));
        System.out.println(counterUnique.uniqueCount(arraysTwo));
        System.out.println(counterUnique.uniqueCount(arraysNegative));
        System.out.println();
    }
}

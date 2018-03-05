package lesson32.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Solution {

    /**
     * Reads message from console.
     * @throws IOException
     */
    public void readNumbers() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberAttempts = 3;
        while (numberAttempts > 0){
            System.out.println("Write 10 numbers");
            String[] numbersLine = reader.readLine().split(" ");

            if (numbersLine.length == 10 && checkMoreHundred(numbersLine)){
                int sum = 0;
                for (String decimal : numbersLine) {
                    sum += Integer.valueOf(decimal);
                }
                System.out.println("Sum numbers is " + sum);
                break;
            } else {
                numberAttempts--;
                if (numberAttempts > 0){
                    System.out.println("Your numbers are wrong. You have " + numberAttempts + " attempts to try again");
                } else System.out.println("Your numbers are wrong. Number of attempts exceeded");
            }
        }
        reader.close();
    }

    /**
     * Checks elements array, and return false if value not decimal and if value more 100.
     * @param numbersLine
     * @return
     */
    private boolean checkMoreHundred(String[] numbersLine){
        for (String decimal : numbersLine) {
            try {
                if (Integer.valueOf(decimal) > 100){
                    return false;
                }
            } catch (NumberFormatException n){
                return false;
            }
        }
        return true;
    }
}

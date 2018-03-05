package lesson32.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class ReadFromKeyboard {
    public static String name;
    public static boolean valid;
    public static Scanner scanner = new Scanner(System.in);
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) {
        readKeyboardWithScanner();
        readKeyboardWithIOStream();
        scanner.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void readKeyboardWithScanner() {
        valid = false;
        while (!valid){
            System.out.println("Please enter your name");
            name = scanner.nextLine();
            valid = printName(name);
        }
    }
    public static void readKeyboardWithIOStream() {
        valid = false;
        while (!valid){
            System.out.println("Please enter your name");
            try {
                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            valid = printName(name);
        }
    }

    public static boolean printName(String name){
        if (name.matches("[a-zA-Zа-яА-Я]+")){
            System.out.println("Hello " + name);
            return true;
        } else System.out.println("Name is not correct!");
        return false;
    }

}

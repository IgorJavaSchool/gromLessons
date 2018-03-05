package lesson4;

/**
 * Created by MM on 15.12.2017.
 */
public class Demo {
    public static void main(String[] args) {

        /**
         * Tests method concat.
         */
        Concatination concatination = new Concatination();

        System.out.println(concatination.concat("aa", "bb", "CC"));
        System.out.println(concatination.concat("aa", null, null));
        System.out.println(concatination.concat(null, "bb", null));
        System.out.println(concatination.concat(null, null, "CC"));
        System.out.println(concatination.concat(null, null, null));


        /**
         * Tests method finDivCount
         */
        QuantityFinder quantityFinder = new QuantityFinder();

        System.out.println(quantityFinder.findDivCount((short)15,(short)21,2));
        System.out.println(quantityFinder.findDivCount((short)-2,(short)21,2));
        System.out.println(quantityFinder.findDivCount((short)15,(short)21,-2));
        System.out.println(quantityFinder.findDivCount((short)15,(short)21,2));


        /**
         * Tests method compareSums
         */
        checkSum CheckSum = new checkSum();
        System.out.println(CheckSum.compareSums(-2147483647, 2147483647, 3, 2));
        System.out.println(CheckSum.compareSums(1, 900000000, -147483647, 2147483647));
        System.out.println(CheckSum.compareSums(1, 900000000, 3, 2));
    }
}

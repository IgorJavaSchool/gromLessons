package lesson8.arithmetica;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        int[] array = new int[] {99,98,97,2};
        int[] array1 = new int[] {101,98,97,-1};
        int[] array2 = new int[] {2147483647,2147483646};
        int[] array3 = new int[] {0,0,0,0};
        int[] array4 = new int[] {1};
        int[] array5 = null;

        /**
         * Tests wto methods.
         */
        System.out.println(adder.check(array));
        System.out.println(adder.check(array1));
        System.out.println(adder.check(array2));
        System.out.println(adder.check(array3));
        System.out.println(adder.check(array4));
        System.out.println(adder.check(array5));
        System.out.println(adder.add(1, 2));
        System.out.println(adder.add(2147483647,2147483646));


    }
}

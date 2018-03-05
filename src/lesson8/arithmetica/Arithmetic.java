package lesson8.arithmetica;

public class Arithmetic {

    public boolean check(int[] array){
        if (array == null || array.length < 1) {
            System.err.println("there are no values to compare");
            return false;
        }
        int max = array[0];
        int min = array[0];
        for (int number : array){
            if (max < number)
                max = number;
            else
            if (min > number)
                min = number;
        }

        long sum = (long)max + (long)min;
        return sum > (long)100;
    }
}

package lesson5;


/**
 * Created by MM on 20.11.2017.
 */
public class SortArrays {

    public int[] sortAscending(int[] array){
        if (array == null)
            return new int[]{};
        int cash;
        int[] arrayUp = array;
        for (int i = 0; i < arrayUp.length; i++) {
            for (int j = 0; j < arrayUp.length; j++) {
                if (arrayUp[i] < arrayUp[j]){
                    cash = arrayUp[i];
                    arrayUp[i] = arrayUp[j];
                    arrayUp[j] = cash;
                }
            }
        }
        return arrayUp;
    }
    public int[] sortDescending(int[] array){
        if (array == null)
            return new int[]{};
        int cash;
        int[] arrayDoun = array;
        for (int i = 0; i < arrayDoun.length; i++) {
            for (int j = 0; j < arrayDoun.length; j++) {
                if (arrayDoun[i] > arrayDoun[j]){
                    cash = arrayDoun[i];
                    arrayDoun[i] = arrayDoun[j];
                    arrayDoun[j] = cash;
                }
            }
        }
        return arrayDoun;
    }
}

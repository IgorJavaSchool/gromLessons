package lesson5;

/**
 * Created by MM on 20.11.2017.
 */
public class ArraysPractice {
    public static void main(String[] args) {
        int[] array = {10,0,-5,56,0};
        System.out.println(maxElement(array));
        System.out.println(nCount(array, 0));
    }
    public static int maxElement(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public static int nCount(int[] array, int n){
        int coont = 0;
        for (int el : array){
            if (el == n){
                coont++;
            }
        }
        return coont;
    }
}

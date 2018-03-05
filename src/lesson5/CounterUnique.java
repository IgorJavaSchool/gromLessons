package lesson5;

/**
 * Created by MM on 20.11.2017.
 */
public class CounterUnique {

            	    public int uniqueCount(int[] array) {
                        if (array == null || array.length < 1)
                            return 0;

                        int[] arrayList = new int[0];
                        int[] result;
                        boolean check;
                        int count = 0;
                        for (int i = 0; i < array.length; i++) {
                            check = false;
                            for (int j = 0; j < arrayList.length; j++) {
                                if (array[i] == arrayList[j]) {
                                    check = true;
                                }
                            }
                            if (!check) {
                                result = new int[arrayList.length + 1];
                                for (int j = 0; j < arrayList.length; j++) {
                                    result[j] = arrayList[j];
                                }
                                arrayList = result;
                                arrayList[count] = array[i];
                                count++;
                            }
                        }
                        return arrayList.length;
                    }
    }


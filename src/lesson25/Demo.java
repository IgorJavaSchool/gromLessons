package lesson25;


import java.util.Arrays;

/**
 * Created by MM on 19.12.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        String name = "NAME";
        Integer integer = 352;
        Character character = 'C';
        /**
         * Test #1
         */
        GeneralDao generalDao = new GeneralDao();
        System.out.println("Test #1");
        for (int i = 0; i < 5; i++) {
            generalDao.save(name);
        }
        System.out.println(Arrays.toString(generalDao.getAll()));

        /**
         * Test #2
         */
        generalDao = new GeneralDao();
        System.out.println("Test #2");
        for (int i = 0; i < 10; i++) {
            generalDao.save(integer);
        }
        System.out.println(Arrays.toString(generalDao.getAll()));

        /**
         * Test #3
         */
        generalDao = new GeneralDao();
        System.out.println("Test #3");
        for (int i = 0; i < 10; i++) {
            generalDao.save(character);
        }
        System.out.println(Arrays.toString(generalDao.getAll()));

        /**
         * Test #4
         */
        generalDao = new GeneralDao();
        System.out.println("Test #4");
        for (int i = 0; i < 11; i++) {
            generalDao.save(character);
        }
        System.out.println(Arrays.toString(generalDao.getAll()));
    }
}


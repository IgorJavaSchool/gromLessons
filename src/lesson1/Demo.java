package lesson1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by MM on 22.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Abc abc = new Abc(5, 10);
        try {
            Field aNew = abc.getClass().getDeclaredField("a");
            Field bNew = abc.getClass().getDeclaredField("b");
            aNew.setAccessible(true);
            setAbsolutelyAccessible(bNew);
            bNew.setInt(abc, 2500);
            aNew.setInt(abc, 1500);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(abc.getA());
        System.out.println(abc.getB());


//        for (Field field : fields){
//            if (field.getName().equals("a"))
//                try {
//                    field.setInt(abc, 15);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            else if (field.getName().equals("b"))
//                try {
//                    field.setInt(abc, 25);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//        }
//
//        System.out.println(abc.getA());
//        System.out.println(abc.getB());
    }

    private static void setAbsolutelyAccessible(Field field) {
        try {
            field.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // ignored exceptions
        }
    }


}

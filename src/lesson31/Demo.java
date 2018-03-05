package lesson31;

/**
 * Created by MM on 14.01.2018.
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countSymbols("45654545"));
        System.out.println(solution.countSymbols("dfddffddfghg"));
        System.out.println(solution.countSymbols("фыфыолвоаралывдыоарп"));
        System.out.println(solution.countSymbols("lkjklj:jiji"));
        System.out.println(solution.countSymbols(null));
        System.out.println(solution.countSymbols(" "));

        System.out.println();

        System.out.println(solution.words("Жили-были три китайца: Як, Як-цедрак, Як-цедрак-цедрак-цедрони." +
                " Жили-были три китайки: Цыпа, Цыпа-дрыпа, Цыпа-дрыпа-дрымпампони.Все они переженились: " +
                "Як на Цыпе, Як-цедрак на Цыпе-дрыпе,Як-цедрак-цедрак-цедрони на Цыпе-дрыпе-дрымпампони." +
                "И у них родились дети. У Яка с Цыпой — Шах, у Яка-цедрака с Цыпой-дрыпой — Шах-шарах, " +
                "у Яка-цедрака-цедрака-цедрони с Цыпой-дрыпой-дрымпампони — Шах-шарах-шарах-широни."));

        System.out.println(solution.words("qwerty qwerty Qw"));
        System.out.println(solution.words("000 444 555"));
        System.out.println(solution.words(" "));
        System.out.println(solution.words(null));
    }
}

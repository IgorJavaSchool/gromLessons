package lesson12;

/**
 * Created by MM on 15.12.2017.
 */
public class Main {
    public static void main(String[] args) {
        Bank bankGermany = new EUBank(1, "Germany", Currency.EUR, 100, 1400, 4, 4445552224444l);
        Bank bankPoland  = new EUBank(2, "Poland", Currency.USD, 50, 1100, 3, 1000000000l);
        Bank bankUSA     = new USBank(3, "USA", Currency.USD, 200, 2100, 5, 4445552224444l);
        Bank bankItaly     = new USBank(3, "Italy", Currency.EUR, 200, 2100, 5, 4445552224444l);
        Bank bankChina   = new ChinaBank(4, "China", Currency.USD, 300, 5000, 5, 99445552224444l);

        User userDenis = new User(1001, "Denis", 12000, 11, "GMD", 1500, bankGermany);
        User userDenis2 = new User(1011, "Denis2", 12000, 11, "GMD2", 1500, bankPoland);
        User userTom = new User(1002, "TOM", 45000, 10, "Google", 1200, bankPoland);
        User userTom2 = new User(1012, "TOM2", 45000, 10, "Google2", 1200, bankChina);
        User userAndrey = new User(1003, "Andrey", 28000, 6, "Microsoft", 1450, bankItaly);
        User userAndrey2 = new User(1013, "Andrey2", 28000, 6, "Microsoft2", 1450, bankItaly);
        User userAndrey3 = new User(1023, "Andrey3", 100, 6, "Microsoft2", 1450, bankItaly);
        User userPoll = new User(1004, "Poll", 600, 38, "Yahoo", 850, bankChina);
        User userPoll2 = new User(1014, "Poll2", 600, 38, "Yahoo2", 850, bankGermany);

        BankSystem bankSystem = new UkrainianBankSystem();

        /**
         * Тестируем снятие баланса с USBank.
         * Если в USD то лимит 1000
         */
//
//        bankSystem.withdraw(userAndrey, 990);
//        System.out.println(userAndrey.getBalance());
//        bankSystem.withdraw(userAndrey, 900);
//        System.out.println(userAndrey.getBalance());
//        bankSystem.withdraw(userAndrey3, 900);
//        System.out.println(userAndrey3.getBalance());
//
//        /**
//         * Тестируем снятие баланса с USBank.
//         * Если в EUR то лимит 1200
//         */
//
//        bankSystem.withdraw(userAndrey2, 1150);
//        System.out.println(userAndrey2.getBalance());
//        bankSystem.withdraw(userAndrey2, 900);
//        System.out.println(userAndrey2.getBalance());


        /**
         * Тестируем снятие баланса с EUBank.
         * Если в USD то лимит 2000
         */

        bankSystem.withdraw(userDenis2, 1950);
        System.out.println(userDenis2.getBalance());
        bankSystem.withdraw(userDenis2, 1800);
        System.out.println(userDenis2.getBalance());

        /**
         * Тестируем снятие баланса с EUBank.
         * Если в EUR то лимит 2200
         */

        bankSystem.withdraw(userDenis, 2150);
        System.out.println(userDenis.getBalance());
        bankSystem.withdraw(userDenis, 1900);
        System.out.println(userDenis.getBalance());

        /**
         * Тестируем снятие баланса с ChinaBank.
         * Если в USD то лимит 2000
         * Если в EUR то лимит 2200
         */

        /**
         * Тестируем зачисление на баланс в USBank.
         * Если в USD то безлимит
         * Если в EUR то лимит 10000
         */

        /**
         * Тестируем зачисление на баланс в EUBank.
         * Если в USD то лимит 10000
         * Если в EUR то лимит 20000
         */

        /**
         * Тестируем зачисление на баланс в ChinaBank.
         * Если в USD то лимит 10000
         * Если в EUR то лимит 5000
         */

        /**
         * Тестируем ежемесячный процент по ставке в USBank.
         * Если в USD то 1%
         * Если в EUR то 2%
         */

        /**
         * Тестируем ежемесячный процент по ставке в EUBank.
         * Если в USD то 0%
         * Если в EUR то 1%
         */

        /**
         * Тестируем ежемесячный процент по ставке в ChinaBank.
         * Если в USD то 1%
         * Если в EUR то 0%
         */

        /**
         * Тестируем комиссию за снятие денег в USBank.
         * Если в USD то 5% при условии что сумма меньше 1000 инче 7%
         * Если в EUR то 6% при условии что сумма меньше 1000 инче 8%
         */

        /**
         * Тестируем комиссию за снятие денег в EUBank.
         * Если в USD то 5% при условии что сумма меньше 1000 инче 7%
         * Если в EUR то 2% при условии что сумма меньше 1000 инче 4%
         */

        /**
         * Тестируем комиссию за снятие денег в ChinaBank.
         * Если в USD то 3% при условии что сумма меньше 1000 инче 5%
         * Если в EUR то 10% при условии что сумма меньше 1000 инче 11%
         */
    }
}

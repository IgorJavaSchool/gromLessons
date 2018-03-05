package lesson11.hotel;

import java.util.Date;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Demo {
    public static void main(String[] args) {

        Room room1 = new Room(1, -1, -1, new Date(), "Hilton1", "Odessa");
        Room room2 = new Room(2, 0, 0, new Date(), "Hilton1", "Odessa");
        Room room3 = new Room(3, 50, 1, new Date(), "Hilton1", "Odessa");       // Is Correct.
        Room room4 = new Room(4, 99, 2, new Date(), "Hilton1", "Odessa");
        Room room5 = new Room(5, 150, 3, new Date(), "Kempinski3", "Odessa");   // Is Not Correct
        Room room6 = new Room(6, 200, 4, new Date(), "Hilton1", "Валенсия");    // Is Not Correct
        Room room7 = new Room(7, 1, 1, new Date(), "Hilton1", "Odessa");        // IS Correct
        Room room8 = new Room(8, 450, 6, new Date(), "Hilton7", "Бергамо");
        Room room9 = new Room(9, 75, 1, new Date(), "Hilton1", "Odessa");       // Is Correct.

        Room room10 = new Room(10, 400, 6, new Date(), "Kempinski6", "Верона");
        Room room11 = new Room(11, 450, 7, null, "Hilton7", "Бергамо");
        Room room12 = new Room(12, 500, 10, new Date(), "AquaMarin7", "Болонья");
        Room room13 = new Room(13, 450, 8, new Date(), "Hilton7", "Бергамо");
        Room room14 = new Room(14, 450, 8, new Date(), "Hilton7", "Брешиа");
        Room room15 = new Room(15, 450, 7, new Date(), "AquaMarin9", "Венеция");
        Room room16 = new Room(16, 400, 6, new Date(), "Kempinski6", "Верона");
        Room room17 = new Room(17, 750, 15, new Date(), "Hilton11", "Виченца");
        Room room18 = new Room(18, 800, 16, new Date(), "AquaMarin11", "Генуя");

        Room room19 = new Room(19, 75, 1, new Date(), "Hilton1", "Odessa");       // Is Correct.
        Room room20 = new Room(20, 75, 1, null, "Hilton1", "Odessa");       // Is Correct.
        Room room21= new Room(21, 75, 1, new Date(), null, "Odessa");       // Is Correct.
        Room room22 = new Room(22, 75, 1, new Date(), "Hilton1", null);       // Is Correct.


        Room[] rooms = new Room[]{room1,room2,room3, room4,room5,room6,room7,room8, room9,room10, room11, room12,
                room13, room14, room15, room16, room17, room18, room19, room20, room21, room22};

        API bookingComAPI = new BookingComAPI(rooms);

        API tripAdvisorAPI = new TripAdvisorAPI(rooms);

        API googleAPI = new GoogleAPI(rooms);


        API[] apisB = new API[]{bookingComAPI};
        API[] apisT = new API[]{tripAdvisorAPI};
        API[] apisG = new API[]{googleAPI};
        API[] apisAll = new API[]{bookingComAPI, tripAdvisorAPI, googleAPI};

        Controller controllerB = new Controller(apisB);
        Controller controllerT = new Controller(apisT);
        Controller controllerG = new Controller(apisG);
        Controller controllerAll = new Controller(apisAll);
        Room[] roomsController;

        /**
         * Tests tookingComAPI
         */
        roomsController = controllerB.requestRooms(99, 1, "Odessa", "Hilton1");
        System.out.println("Tests tookingComAPI");
        for (Room room : roomsController){
            System.out.println(room.getId());
        }
        System.out.println();

        /**
         * Tests tripAdvisorAPI
         */
        roomsController = controllerT.requestRooms(450, 7, "Бергамо", "Hilton7");
        System.out.println("Tests tripAdvisorAPI");
        for (Room room : roomsController){
            System.out.println(room.getId());
        }
        System.out.println();

        /**
         * Tests googleAPI
         */
        roomsController = controllerG.requestRooms(400, 6,"Верона", "Kempinski6");
        System.out.println("Tests googleAPI");
        for (Room room : roomsController){
            System.out.println(room.getId());
        }
        System.out.println();

        /**
         * Tests AllAPI
         */
        roomsController = controllerAll.requestRooms(99, 1, "Odessa", "Hilton1");
        System.out.println("Tests AllAPI");
        for (Room room : roomsController){
            System.out.println(room.getId());
        }
        System.out.println();


        /**
         * Tests method check
         */
        API bookingComAPICheck = new BookingComAPI(new Room[]{room1,room2,room3, room4,room5,room6,room7,room8, room9});

        API tripAdvisorAPICheck = new TripAdvisorAPI(new Room[]{room10, room11, room12,
                room13, room14, room15, room16, room17, room18, room19, room20, room21, room22});

        Room[] roomsCheck = controllerAll.check(bookingComAPICheck, tripAdvisorAPICheck);
        System.out.println("Tests method check");
        for (Room room : roomsCheck){
            System.out.println(room.getId());
        }
    }
}

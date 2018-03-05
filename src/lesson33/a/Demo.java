package lesson33.a;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Demo {

    public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.readeFile("D:\\test\\123.txt");
        readWriteFile.writeFile("D:\\test\\1234.txt", "wwwww");
        readWriteFile.writeFile("D:\\test\\1234.txt", "PPPPP");
    }
}

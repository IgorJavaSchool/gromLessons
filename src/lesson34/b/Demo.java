package lesson34.b;


/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Demo {
    public static void main(String[] args) {
        new Solution().copyFileContent("D:\\test\\1.txt", "D:\\test\\2.txt");
        new Solution().copyFileContentApacheIO("D:\\test\\2.txt", "D:\\test\\3.txt");
    }
}

package lesson34.a;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.copyFileContent("D:\\test\\12345.txt", "D:\\test\\123456.txt");
        solution.transferFileContent("D:\\test\\1234.txt", "D:\\test\\123456.txt");
        solution.transferSentences("D:\\test\\1.txt", "D:\\test\\2.txt", "yesterday");
    }
}

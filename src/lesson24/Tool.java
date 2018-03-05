package lesson24;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Tool {
    private String name;
    private int weight;
    private int length;

    public Tool(String name, int weight, int length) {
        this.name = name;
        this.weight = weight;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", length=" + length +
                '}';
    }
}

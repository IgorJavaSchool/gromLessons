package lesson24;

/**
 * Created by MM on 19.12.2017.
 */
public class ToolDao {
    Tool[] tools = new Tool[5];

    public Tool save(Tool tool){
        for (int i = 0; i < tools.length; i++) {
            if (tools[i] == null){
                tools[i] = tool;
                return tools[i];
            }
        }
        return null;
    }
}

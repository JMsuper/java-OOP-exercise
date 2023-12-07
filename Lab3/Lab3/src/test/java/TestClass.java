import org.example.ListItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestClass {

    @Test
    public void toStringTestOneDepth(){
        ListItem listItem = new ListItem("test");
        assertEquals(String.format("* test%s", System.lineSeparator()),listItem.toString());
    }

    @Test
    public void toStringTestTwoDepth(){
        ListItem listItem1 = new ListItem("test");
        ListItem listItem2 = new ListItem("test",'-');
        ListItem listItem3 = new ListItem("test",'-');
        listItem1.addSublistItem(listItem2);
        listItem1.addSublistItem(listItem3);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* test%s",System.lineSeparator()));
        sb.append(String.format("    - test%s",System.lineSeparator()));
        sb.append(String.format("    - test%s",System.lineSeparator()));
        assertEquals(sb.toString(),listItem1.toString());
    }

    @Test
    public void toStringTestThreeDepth(){
        ListItem listItem1 = new ListItem("test");
        ListItem listItem2 = new ListItem("test",'-');
        ListItem listItem3 = new ListItem("test",'>');
        listItem2.addSublistItem(listItem3);
        listItem1.addSublistItem(listItem2);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* test%s",System.lineSeparator()));
        sb.append(String.format("    - test%s",System.lineSeparator()));
        sb.append(String.format("        > test%s",System.lineSeparator()));
        assertEquals(sb.toString(),listItem1.toString());
    }
}

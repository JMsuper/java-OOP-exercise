package pattern.builder.example.documentation;

import java.util.LinkedList;

public class HtmlTableBuilder extends TableBuilder{
    private final StringBuilder stringBuilder = new StringBuilder();
    private LinkedList<String> rowItems = new LinkedList<>();


    @Override
    public TableBuilder addHeadingRow() {
        if(rowItems.isEmpty()) return this;

        stringBuilder.append("<tr>");
        rowItems.forEach(item -> stringBuilder.append("<th>" + item + "</th>"));
        stringBuilder.append("</tr>")
                .append(lineSeparator);

        rowItems.clear();
        return this;
    }

    @Override
    public TableBuilder addRow() {
        if(rowItems.isEmpty()) return this;

        stringBuilder.append("<tr>");
        rowItems.forEach(item -> stringBuilder.append("<td>" + item + "</td>"));
        stringBuilder.append("</tr>")
                .append(lineSeparator);

        rowItems.clear();
        return this;
    }

    @Override
    public TableBuilder addColumn(String column) {
        if(rowItems == null){
            rowItems = new LinkedList<>();
        }
        rowItems.addLast(column);
        return this;
    }

    public String toHtmlDocument(){

        return "<table>" + lineSeparator + stringBuilder.toString() + "</table>";
    }

}

package pattern.builder.example.documentation;

import java.util.LinkedList;

public class MarkdownTableBuilder extends TableBuilder{
    private final StringBuilder stringBuilder = new StringBuilder();
    private LinkedList<String> rowItems = new LinkedList<>();

    @Override
    public TableBuilder addHeadingRow() {
        for (String item : rowItems){
            stringBuilder.append("|").append(item);
        }
        stringBuilder.append("|").append(lineSeparator);

        for(int i = 0; i < rowItems.size(); i++){
            stringBuilder.append("|").append("---");
        }
        stringBuilder.append("|").append(lineSeparator);
        rowItems.clear();
        return this;
    }

    @Override
    public TableBuilder addRow() {
        for (String item : rowItems){
            stringBuilder.append("|").append(item);
        }
        stringBuilder.append("|");

        stringBuilder.append(lineSeparator);
        rowItems.clear();
        return this;
    }

    @Override
    public TableBuilder addColumn(String column) {
        if (rowItems == null) rowItems = new LinkedList<>();

        rowItems.add(column);
        return this;
    }

    public String toMarkDownText(){
        return stringBuilder.toString();
    }
}

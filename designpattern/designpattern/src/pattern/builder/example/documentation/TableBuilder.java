package pattern.builder.example.documentation;

public abstract class TableBuilder {
    protected static final String lineSeparator = System.lineSeparator();
    public abstract TableBuilder addHeadingRow();
    public abstract TableBuilder addRow();
    public abstract TableBuilder addColumn(String column);
}

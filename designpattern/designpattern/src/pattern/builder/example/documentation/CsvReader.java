package pattern.builder.example.documentation;

import java.io.*;

public class CsvReader {
    private String csvText;

    public CsvReader(String csvPath){
        this.csvText = getTextFromPath(csvPath);
    }

    private String getTextFromPath(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String st;
            while ((st = br.readLine()) != null) {
                sb.append(st).append(System.lineSeparator());
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeTo(TableBuilder tableBuilder){
        String[] lines = csvText.split(System.lineSeparator());
        String[] columns = lines[0].split(",");

        for (int i = 0; i < columns.length; i++){
            tableBuilder.addColumn(columns[i]);
        }

        tableBuilder.addHeadingRow();

        for (int i = 1; i < lines.length; i++){
            String[] tokens = lines[i].split(",");

            for(int j = 0; j < tokens.length; j++){
                tableBuilder.addColumn(tokens[j]);
            }

            tableBuilder.addRow();
        }
    }
}


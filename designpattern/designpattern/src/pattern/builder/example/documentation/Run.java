package pattern.builder.example.documentation;

import pattern.Runnable;

import javax.swing.text.html.HTMLDocument;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Run implements Runnable {
    @Override
    public void run() {
        Path path = Paths.get("resource","test.csv");
        CsvReader csvReader = new CsvReader(path.toString());
        {
            HtmlTableBuilder builder = new HtmlTableBuilder();

            csvReader.writeTo(builder);
            String html = builder.toHtmlDocument();
            System.out.println(html);
        }
        {
            MarkdownTableBuilder builder = new MarkdownTableBuilder();

            csvReader.writeTo(builder);
            String mdText = builder.toMarkDownText();
            System.out.println(mdText);
        }

    }
}

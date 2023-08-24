package webdriver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvUtil {
    public static void writeItemsToCsv(List<Item> items, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT
                     .withHeader("Title", "Description", "URL", "Price"))) {
            for (Item item : items) {
                csvPrinter.printRecord(item.getTitle(), item.getDescription(), item.getUrl(), item.getPrice());
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

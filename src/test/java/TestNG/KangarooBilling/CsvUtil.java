package TestNG.KangarooBilling;

import java.io.FileWriter;
import java.io.IOException;

public class CsvUtil {

    private static final String FILE_NAME = "TestResults.csv";
    //C:\Users\Admin\IdeaProjects\Corporate

    public static void writeResult(String testName, String status) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.append(testName).append(",").append(status).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

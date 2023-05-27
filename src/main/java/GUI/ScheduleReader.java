package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The ScheduleReader class provides a static method to read a course schedule from a file.
 */
public class ScheduleReader {
    /**
     * Reads the course schedule from the specified file.
     *
     * @param filePath The path of the file containing the course schedule.
     * @return A list of strings representing the course schedule.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<String> readSchedule(String filePath) throws IOException {
        List<String> schedule = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                schedule.add(line);
            }
        }

        return schedule;
    }
}


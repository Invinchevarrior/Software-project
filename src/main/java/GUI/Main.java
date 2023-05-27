package GUI;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
/**
 * The Main class is the entry point of the application.
 * It reads a schedule from a file, creates a graphical user interface (GUI),
 * and displays the schedule using the GUI.
 */
public class Main {
    /**
     * The main method is the starting point of the application.
     * It reads a schedule from a file, creates a GUI, and displays the schedule using the GUI.
     *
     * @param args command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        try {
            List<String> schedule = ScheduleReader.readSchedule("Schedule.txt");
            SwingUtilities.invokeLater(() -> new ScheduleGUI(schedule));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

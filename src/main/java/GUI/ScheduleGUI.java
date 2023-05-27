package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
/**
 * The ScheduleGUI class represents a graphical user interface (GUI) for displaying a course schedule.
 * It creates a window with labels to show the schedule data.
 */
public class ScheduleGUI {
    private JFrame frame;
    private JLabel[] scheduleLabels;
    /**
     * Constructs a ScheduleGUI object.
     * It creates a window with labels to display the course schedule.
     *
     * @param schedule The list of strings representing the course schedule.
     */
    public ScheduleGUI(List<String> schedule) {
        frame = new JFrame("Course Schedule");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        scheduleLabels = new JLabel[10 * 5]; // 10 rows * 5 columns
        frame.setLayout(new GridLayout(10, 5));

        int index = 0;
        for (String item : schedule) {
            JLabel label = new JLabel(item, SwingConstants.CENTER);
            scheduleLabels[index] = label;
            frame.add(label);
            index++;
        }

        frame.setVisible(true);
    }
    /**
     * The main method is the entry point of the application.
     * It reads the course schedule from a file, creates a ScheduleGUI object,
     * and displays the schedule using the GUI.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try {
            List<String> schedule = ScheduleReader.readSchedule("src/schedule.txt");
            SwingUtilities.invokeLater(() -> {
                new ScheduleGUI(schedule);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



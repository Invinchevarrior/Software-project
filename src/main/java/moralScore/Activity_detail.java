package moralScore;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
/**
 * Represents the main activity detail window of the Moral Score System.
 * This window provides options to view club information, volunteer information,
 * calculate moral scores, and navigate back to the previous window.
 */
public class Activity_detail extends JFrame implements ActionListener {
    /**
     * Constructs the Activity_detail window.
     * Sets up the window properties and adds buttons for different actions.
     * Also sets up action listeners for each button.
     */
    public Activity_detail() {
        setTitle("Moral Score System");
        setSize(800, 650);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 1, 80, 80)); // 3 rows, 2 columns, 80 pixels gap

        JButton clubsBtn = new JButton("Club Information");
        JButton volunteersBtn = new JButton("Volunteer Information");
        JButton scoresBtn = new JButton("Calculate Moral Score");
        JButton backBtn = new JButton("Back");

        add(clubsBtn);
        add(volunteersBtn);
        add(scoresBtn);
        add(backBtn);

        volunteersBtn.addActionListener(e -> {
            new volunteer_detail();
        });

        clubsBtn.addActionListener(e -> {
            new club_detail();
        });

        scoresBtn.addActionListener(e -> {
            new calMoral();
        });
        backBtn.addActionListener(e -> {
            setVisible(false);
        });

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    /**
     * The entry point of the application.
     * Creates an instance of Activity_detail window to start the program.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args){
        new Activity_detail();
    }
    
}

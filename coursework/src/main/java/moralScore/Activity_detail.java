package moralScore;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Activity_detail extends JFrame implements ActionListener {
    public Activity_detail() {
        setTitle("Moral Score System");
        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
            // TODO: 实现modules按钮的功能
            new volunteer_detail();
        });

        clubsBtn.addActionListener(e -> {
            // TODO: 实现modules按钮的功能
            new club_detail();
        });

        scoresBtn.addActionListener(e -> {
            // TODO: 实现modules按钮的功能
            new calMoral();
        });
        backBtn.addActionListener(e -> {
            // TODO: 实现modules按钮的功能
            setVisible(false);
        });

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args){
        new Activity_detail();
    }
    
}

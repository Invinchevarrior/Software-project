package GUI;

import CourseMark.Main;
import java.util.Locale;
import achieve.StdAchieveGUI;
//import moralScore.Main;
import moralScore.Activity_detail;
import skills.Skill_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 * The page2 class represents the second page of the GUI application.
 * It displays an image, along with several buttons for different functionalities.
 * Users can interact with the buttons to perform various actions.
 */
public class page2 extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private JLabel label;
    private ImageIcon imageIcon;
    private Image image;
    private int x, y;
//    private int width, height;
    private int mouseX, mouseY;
    private boolean isDragging;
    private JButton modulesBtn, skillsBtn, achievementBtn, rolesBtn,homeBtn;
    private static final long serialVersionUID = 1L;
    private JScrollPane scrollPane;
    private int width = 800;
    private int height = 600;
    private int imageWidth;
    private int imageHeight;
    /**
     * Constructs a page2 object.
     * It sets up the GUI components, including an image, buttons, and their respective actions.
     */
    public page2() {
        super("My GUI");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);

        try {
            image = ImageIO.read(new File("books.png"));
            imageIcon = new ImageIcon(image);
            label = new JLabel(imageIcon);
            label.setBounds(20, 20, 550, 510);
            label.addMouseListener(this);

            panel.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }

        modulesBtn = new JButton("modules and marks");
        modulesBtn.setBounds(630, 50, 150, 50);
        panel.add(modulesBtn);

        skillsBtn = new JButton("skills");
        skillsBtn.setBounds(630, 120, 150, 50);
        panel.add(skillsBtn);

        achievementBtn = new JButton("achievement");
        achievementBtn.setBounds(630, 190, 150, 50);
        panel.add(achievementBtn);

        rolesBtn = new JButton("roles undertaken");
        rolesBtn.setBounds(630, 260, 150, 50);
        panel.add(rolesBtn);

        homeBtn = new JButton("HOME");
        homeBtn.setBounds(630, 330, 150, 50);
        panel.add(homeBtn);

        modulesBtn.addActionListener(e -> {
            new Main();
        });
        skillsBtn.addActionListener(e -> {

            try {
                new Skill_GUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        achievementBtn.addActionListener(e -> {

            try {
                new StdAchieveGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        rolesBtn.addActionListener(e -> {

            new Activity_detail();
        });
        homeBtn.addActionListener(e -> {

            new GUI_1();
            setVisible(false);
        });



        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        List<String> schedule = null;
        try {
            schedule = ScheduleReader.readSchedule("Schedule.txt");
            List<String> finalSchedule = schedule;
            SwingUtilities.invokeLater(() -> new ScheduleGUI(finalSchedule));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new page2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

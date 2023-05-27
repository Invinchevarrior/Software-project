package carried_Plan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import CourseMark.CourseManager;
import CourseMark.Course;

import java.awt.*;
import java.util.ArrayList;
/**
 * The plan_Detail class represents a JFrame that displays a to-do list table.
 * It retrieves course data from the CourseManager and populates the table with the course information.
 */
public class plan_Detail extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JButton addBtn;
    private CourseManager courseManager;
    private JPanel buttonPanel = new JPanel();
    /**
     * Constructs a new plan_Detail JFrame.
     * It initializes the table and retrieves course data from the CourseManager.
     * The retrieved data is used to populate the table.
     */
    public plan_Detail() {
        super("To-do List Table");
        String[][] datas = {};
        String[] titles = {"Name", "Teacher", "Location", "Semester", "School", "Credit", "Hour"};

        courseManager = new CourseManager();
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);

        ArrayList<Course> courses = courseManager.getCourses();

        for (Course course : courses) {
            model.addRow(new String[] { course.getName(), course.getTeacher(), course.getLocation(), course.getSemester(), course.getSchool(), String.valueOf(course.getCredit()), String.valueOf(course.getHours())});
        }

        add(new JScrollPane(table), BorderLayout.CENTER);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {

            setVisible(false);
            
        });
        buttonPanel.add(backButton);

        setVisible(true);
    }
    /**
     * The main method creates an instance of the plan_Detail class to start the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        new plan_Detail();
    }
}

package CourseMark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    private JFrame frame;
    private JList<String> courseList;
    private CourseManager courseManager;
    private DefaultListModel<String> courseListModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main window = new Main();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        courseManager = new CourseManager();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setVisible(true);

        courseListModel = new DefaultListModel<>();
        courseList = new JList<>(courseListModel);
        JScrollPane scrollPane = new JScrollPane(courseList);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton addButton = new JButton("Add course");
        addButton.addActionListener(e -> {
            Course course = new Course("", "", "", "", "", "", 0, 0, 0,0,false);
            CourseDialog dialog = new CourseDialog(frame, course);
            dialog.setVisible(true);

            if (dialog.isConfirmed()) {
                courseManager.addCourse(course);
                courseListModel.addElement(course.getName());
            }
        });

        JButton editButton = new JButton("Edit course");
        editButton.addActionListener(e -> {
            int selectedIndex = courseList.getSelectedIndex();
            if (selectedIndex != -1) {
                Course course = courseManager.getCourses().get(selectedIndex);
                CourseDialog dialog = new CourseDialog(frame, course);
                dialog.setVisible(true);

                if (dialog.isConfirmed()) {
                    courseManager.updateCourse(selectedIndex, course);
                    courseListModel.set(selectedIndex, course.getName());
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a course first.");
            }
        });

        JButton analyzeButton = new JButton("Grade analysis");
        analyzeButton.addActionListener(e -> {
            ArrayList<Course> courses = courseManager.getCourses();
            int count = courses.size();
            float totalMark = 0;
            int totalCredit = 0;
            float totalGPA = 0;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            for (Course course : courses) {
                totalMark += course.getMark() * course.getCredit();
                totalCredit += course.getCredit();
            }

            totalGPA = totalMark / totalCredit / 20 - 1;

            JOptionPane.showMessageDialog(frame, "Average Grade：" + decimalFormat.format(totalMark / totalCredit) + "\n" +
                    "GPA：" + decimalFormat.format(totalGPA));
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(analyzeButton);

        // 初始化课程列表
        for (Course course : courseManager.getCourses()) {
            courseListModel.addElement(course.getName());
        }
    }
}
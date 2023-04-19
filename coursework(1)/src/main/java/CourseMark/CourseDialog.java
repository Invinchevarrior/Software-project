package CourseMark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CourseDialog extends JDialog {
    private Course course;
    private JTextField[] textFields;
    private JLabel passedLabel;
    private boolean confirmed;

    public CourseDialog(JFrame owner, Course course) {
        super(owner, "课程信息", true);
        this.course = course;
        this.confirmed = false;

        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(owner);

        String[] labels = {"课程名称", "老师", "地点", "时间", "学期", "学校", "学分", "课时", "成绩","课程绩点"};
        JPanel inputPanel = new JPanel(new GridLayout(labels.length + 1, 2));
        textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            inputPanel.add(new JLabel(labels[i]));
            textFields[i] = new JTextField();
            inputPanel.add(textFields[i]);
        }

        inputPanel.add(new JLabel("是否及格"));
        passedLabel = new JLabel();
        inputPanel.add(passedLabel);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("保存");
        saveButton.addActionListener(e -> {
            saveCourseInfo();
            confirmed = true;
            dispose();
        });

        JButton cancelButton = new JButton("取消");
        cancelButton.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize text fields and check box with course information
        textFields[0].setText(course.getName());
        textFields[1].setText(course.getTeacher());
        textFields[2].setText(course.getLocation());
        textFields[3].setText(course.getTime());
        textFields[4].setText(course.getSemester());
        textFields[5].setText(course.getSchool());
        textFields[6].setText(String.valueOf(course.getCredit()));
        textFields[7].setText(String.valueOf(course.getHours()));
        textFields[8].setText(String.valueOf(course.getMark()));
        textFields[9].setText(String.valueOf(course.getGPA()));
        boolean isPassed = course.getMark() >= 60;
        passedLabel.setText(isPassed ? "及格" : "不及格");
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    private void saveCourseInfo() {
        course.setName(textFields[0].getText());
        course.setTeacher(textFields[1].getText());
        course.setLocation(textFields[2].getText());
        course.setTime(textFields[3].getText());
        course.setSemester(textFields[4].getText());
        course.setSchool(textFields[5].getText());
        course.setCredit(Integer.parseInt(textFields[6].getText()));
        course.setHours(Integer.parseInt(textFields[7].getText()));
        course.setMark(Float.parseFloat(textFields[8].getText()));
        course.setGPA(Float.parseFloat(textFields[9].getText()));
        boolean isPassed = course.getMark() >= 60;
        course.setPassed(isPassed);
        passedLabel.setText(isPassed ? "及格" : "不及格");
    }
}

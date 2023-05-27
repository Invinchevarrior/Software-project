package CourseMark;

import javax.swing.*;
import java.awt.*;
/**
 * CourseDialog is a custom dialog that allows users to view and edit course information.
 * It extends JDialog and provides a graphical interface for displaying and modifying course details.
 */
public class CourseDialog extends JDialog {
    private Course course;
    private JTextField[] textFields;
    private JLabel passedLabel;
    private boolean confirmed;
    /**
     * Constructs a CourseDialog object.
     *
     * @param owner  the JFrame owner of the dialog
     * @param course the Course object to be displayed and edited
     */
    public CourseDialog(JFrame owner, Course course) {
        super(owner, "Course information", true);
        this.course = course;
        this.confirmed = false;

        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(owner);

        String[] labels = {"Course name", "Teacher", "Location", "Time", "Semester", "School", "Credit", "Class period", "Grade","Course GPA"};
        JPanel inputPanel = new JPanel(new GridLayout(labels.length + 1, 2));
        textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            inputPanel.add(new JLabel(labels[i]));
            textFields[i] = new JTextField();
            inputPanel.add(textFields[i]);
        }

        inputPanel.add(new JLabel("Pass or not"));
        passedLabel = new JLabel();
        inputPanel.add(passedLabel);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            saveCourseInfo();
            confirmed = true;
            dispose();
        });

        JButton cancelButton = new JButton("Cancel");
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
        passedLabel.setText(isPassed ? "Pass" : "Not pass");
    }
    /**
     * Checks if the dialog was confirmed (Save button was clicked).
     *
     * @return true if the dialog was confirmed, false otherwise
     */
    public boolean isConfirmed() {
        return confirmed;
    }
    /**
     * Saves the modified course information.
     * Retrieves the values from the text fields and updates the corresponding Course object.
     * Also updates the pass label based on the mark value.
     */
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
        passedLabel.setText(isPassed ? "Pass" : "Not pass");
    }
}

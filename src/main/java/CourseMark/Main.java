package CourseMark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The Main class is the entry point of the CourseMark application.
 * It creates the main GUI window, handles user interactions, and manages course data.
 */
public class Main {
    private JFrame frame;
    private JList<String> courseList;
    private CourseManager courseManager;
    private DefaultListModel<String> courseListModel;
    /**
     * The main method that launches the CourseMark application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main window = new Main();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * Constructs a Main object.
     * Sets the default locale to English and initializes the course manager.
     * Initializes the GUI components by calling the initialize() method.
     */
    public Main() {
        Locale.setDefault(Locale.ENGLISH);
        courseManager = new CourseManager();
        initialize();
    }
    /**
     * Pads a string with spaces to achieve the specified width and alignment.
     *
     * @param s         the string to pad
     * @param width     the desired width of the padded string
     * @param alignment the alignment of the padded string (SwingConstants.LEFT, SwingConstants.RIGHT, or SwingConstants.CENTER)
     * @return the padded string
     */
    private String padString(String s, int width, int alignment) {
        if (s.length() >= width) {
            return s;
        }

        int padding = width - s.length();
        StringBuilder paddedString = new StringBuilder(s);

        switch (alignment) {
            case SwingConstants.LEFT:
                for (int i = 0; i < padding; i++) {
                    paddedString.append(" ");
                }
                break;

            case SwingConstants.RIGHT:
                for (int i = 0; i < padding; i++) {
                    paddedString.insert(0, " ");
                }
                break;

            case SwingConstants.CENTER:
                int leftPadding = padding / 2;
                int rightPadding = padding - leftPadding;

                for (int i = 0; i < leftPadding; i++) {
                    paddedString.insert(0, " ");
                }

                for (int i = 0; i < rightPadding; i++) {
                    paddedString.append(" ");
                }
                break;
        }

        return paddedString.toString();
    }
    /**
     * Initializes the main GUI window and its components.
     * Adds event listeners to handle user interactions.
     * Populates the course list with existing courses.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(600, 400, 450, 300);

        frame.getContentPane().setLayout(new BorderLayout(0, 0));

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

            JOptionPane.showMessageDialog(frame, "Average Grade:" + decimalFormat.format(totalMark / totalCredit) + "\n" +
                    "GPA:" + decimalFormat.format(totalGPA));
        });

        JButton transcriptButton = new JButton("Transcript");
        transcriptButton.addActionListener(e -> {
            ArrayList<Course> courses = courseManager.getCourses();
            int courseNameWidth = 20;
            int teacherWidth = 20;
            int locationWidth = 20;
            int semesterWidth = 20;
            int schoolWidth = 20;
            int creditWidth = 15;
            int coursedurationWidth = 20;
            int markWidth = 10;
            int gpaWidth = 10;
            int isPassWidth = 10;

            StringBuilder transcript = new StringBuilder();
            transcript.append(padString("Course name", courseNameWidth, SwingConstants.CENTER))
                    .append(padString("Teacher", teacherWidth, SwingConstants.CENTER))
                    .append(padString("Classroom location", locationWidth, SwingConstants.CENTER))
                    .append(padString("Teaching Semester", semesterWidth, SwingConstants.CENTER))
                    .append(padString("Teaching School", schoolWidth, SwingConstants.CENTER))
                    .append(padString("Credit", creditWidth, SwingConstants.CENTER))
                    .append(padString("Course duration", coursedurationWidth, SwingConstants.CENTER))
                    .append(padString("Mark", markWidth, SwingConstants.CENTER))
                    .append(padString("GPA", gpaWidth, SwingConstants.CENTER))
                    .append(padString("Pass", isPassWidth, SwingConstants.CENTER))
                    .append("\n");

            for (Course course : courses) {
                transcript.append(padString(course.getName(), courseNameWidth, SwingConstants.CENTER))
                        .append(padString(course.getTeacher(), teacherWidth, SwingConstants.CENTER))
                        .append(padString(course.getLocation(), locationWidth, SwingConstants.CENTER))
                        .append(padString(course.getSemester(), semesterWidth, SwingConstants.CENTER))
                        .append(padString(course.getSchool(), schoolWidth, SwingConstants.CENTER))
                        .append(padString(String.valueOf(course.getCredit()), creditWidth, SwingConstants.CENTER))
                        .append(padString(String.valueOf(course.getHours()), coursedurationWidth, SwingConstants.CENTER))
                        .append(padString(String.valueOf(course.getMark()), markWidth, SwingConstants.CENTER))
                        .append(padString(String.valueOf(course.getGPA()), gpaWidth, SwingConstants.CENTER))
                        .append(padString(String.valueOf(course.isPass()), isPassWidth, SwingConstants.CENTER))
                        .append("\n");
            }

            JTextArea textArea = new JTextArea(transcript.toString());
            textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
            textArea.setEditable(false);

            JScrollPane transcriptScrollPane = new JScrollPane(textArea);
            transcriptScrollPane.setPreferredSize(new Dimension(frame.getWidth()*3, frame.getHeight()*3));
            transcriptScrollPane.setBorder(BorderFactory.createLoweredSoftBevelBorder());

            JDialog transcriptDialog = new JDialog(frame, "Transcript");
            transcriptDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            transcriptDialog.add(transcriptScrollPane);
            transcriptDialog.pack();
            transcriptDialog.setVisible(true);
        });

        buttonPanel.add(transcriptButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(analyzeButton);

        // initialization of courses
        for (Course course : courseManager.getCourses()) {
            courseListModel.addElement(course.getName());
        }
    }
}
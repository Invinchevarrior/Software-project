package CourseMark;

import java.io.*;
import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private final String FILENAME = "courses.txt";
    public CourseManager() {
        courses = new ArrayList<>();
        loadCourses();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
        saveCourses();
    }

    public void updateCourse(int index, Course course) {
        courses.set(index, course);
        saveCourses();
    }


    private void loadCourses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 11) {
                    String name = parts[0].substring(parts[0].indexOf(":") + 2);
                    String teacher = parts[1].substring(parts[1].indexOf(":") + 2);
                    String location = parts[2].substring(parts[2].indexOf(":") + 2);
                    String time = parts[3].substring(parts[3].indexOf(":") + 2);
                    String semester = parts[4].substring(parts[4].indexOf(":") + 2);
                    String school = parts[5].substring(parts[5].indexOf(":") + 2);
                    int credits = Integer.parseInt(parts[6].substring(parts[6].indexOf(":") + 2));
                    int hours = Integer.parseInt(parts[7].substring(parts[7].indexOf(":") + 2));
                    float mark = Float.parseFloat(parts[8].substring(parts[8].indexOf(":") + 2));
                    float gpa = Float.parseFloat(parts[9].substring(parts[9].indexOf(":") + 2));
                    boolean passed = Boolean.parseBoolean(parts[10].substring(parts[10].indexOf(":") + 2));
                    courses.add(new Course(name,teacher,location,time,semester,school,credits,hours,mark,gpa,passed));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCourses() {
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (Course course : courses) {
                writer.println(course.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


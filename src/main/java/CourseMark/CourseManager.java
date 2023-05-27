package CourseMark;

import java.io.*;
import java.util.ArrayList;
/**
 * CourseManager is responsible for managing courses, including adding, updating, and saving course information.
 * It extends the manager class.
 */
public class CourseManager extends manager{
    private ArrayList<Course> courses;
    private final String FILENAME = "courses.txt";
    /**
     * Constructs a CourseManager object.
     * Initializes the courses ArrayList and loads courses from the file.
     */
    public CourseManager() {
        courses = new ArrayList<>();
        loadCourses();
    }

    @Override
    public void addCourse() {
        super.addCourse();
    }

    @Override
    public void updateCourse() {
        super.updateCourse();
    }
    /**
     * Retrieves the list of courses.
     *
     * @return the ArrayList of courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }
    /**
     * Adds a new course to the list.
     * Updates the course list and saves the changes to the file.
     *
     * @param course the Course object to be added
     */
    public void addCourse(Course course) {
        courses.add(course);
        saveCourses();
    }
    /**
     * Updates an existing course in the list at the specified index.
     * Updates the course list and saves the changes to the file.
     *
     * @param index  the index of the course to be updated
     * @param course the updated Course object
     */
    public void updateCourse(int index, Course course) {
        courses.set(index, course);
        saveCourses();
    }

    /**
     * Loads courses from the file and adds them to the course list.
     * Each line in the file represents a course and is parsed to create a Course object.
     * The loaded courses are added to the courses ArrayList.
     * File format: "Course name, Teacher, Location, Time, Semester, School, Credit, Class period, Grade, Course GPA, Passed"
     */
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
    /**
     * Saves the list of courses to the file.
     * Each course is written as a line in the file using the Course object's toString() method.
     */
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


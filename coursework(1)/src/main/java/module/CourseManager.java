package module;
import java.io.*;
import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private final String FILENAME = "courses.text";

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
        File file = new File(FILENAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                courses = (ArrayList<Course>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveCourses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

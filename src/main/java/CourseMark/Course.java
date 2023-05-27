package CourseMark;

import java.io.Serializable;

/**
 * The Course class represents a course taken by a student.
 * It contains information about the course such as name, teacher, location, time, semester, school,
 * credit, hours, mark, GPA, and pass status.
 * The class also provides methods to access and modify the course information.
 */
public class Course implements Serializable {

    private String name;
    private String teacher;
    private String location;
    private String time;
    private String semester;
    private String school;
    private int credit;
    private int hours;
    private float mark;
    private boolean passed;
    private float gpa;

    /**
     * Constructs a Course object with the specified parameters.
     *
     * @param name     the name of the course
     * @param teacher  the teacher of the course
     * @param location the location of the course
     * @param time     the time of the course
     * @param semester the semester when the course is taught
     * @param school   the school offering the course
     * @param credit   the credit hours of the course
     * @param hours    the duration of the course in hours
     * @param mark     the mark obtained in the course
     * @param gpa      the GPA calculated based on the mark
     * @param passed   the pass status of the course
     */
    public Course(String name, String teacher, String location, String time, String semester, String school,
                  int credit, int hours, float mark, float gpa, boolean passed) {
        this.name = name;
        this.teacher = teacher;
        this.location = location;
        this.time = time;
        this.semester = semester;
        this.school = school;
        this.credit = credit;
        this.hours = hours;
        this.mark = mark;
        this.gpa = gpa;
        this.passed = passed;
        calculateGPA();
    }

    /**
     * Returns the name of the course.
     *
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course.
     *
     * @param name the name of the course
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the teacher of the course.
     *
     * @return the teacher of the course
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * Sets the teacher of the course.
     *
     * @param teacher the teacher of the course
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * Returns the location of the course.
     *
     * @return the location of the course
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the course.
     *
     * @param location the location of the course
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the time of the course.
     *
     * @return the time of the course
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the course.
     *
     * @param time the time of the course
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the semester when the course is taught.
     *
     * @return the semester when the course is taught
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester when the course is taught.
     *
     * @param semester the semester when the course is taught
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Returns the school offering the course.
     *
     * @return the school offering the course
     */
    public String getSchool() {
        return school;
    }

    /**
     * Sets the school offering the course.
     *
     * @param school the school offering the course
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Returns the credit hours of the course.
     *
     * @return the credit hours of the course
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Sets the credit hours of the course.
     *
     * @param credit the credit hours of the course
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * Returns the duration of the course in hours.
     *
     * @return the duration of the course in hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Sets the duration of the course in hours.
     *
     * @param hours the duration of the course in hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Returns the mark obtained in the course.
     *
     * @return the mark obtained in the course
     */
    public float getMark() {
        return mark;
    }

    /**
     * Sets the mark obtained in the course and recalculates the GPA.
     *
     * @param mark the mark obtained in the course
     */
    public void setMark(float mark) {
        this.mark = mark;
        calculateGPA();
    }

    /**
     * Returns the pass status of the course.
     *
     * @return true if the course is passed, false otherwise
     */
    public boolean isPass() {
        return passed;
    }

    /**
     * Sets the pass status of the course and recalculates the GPA.
     *
     * @param passed the pass status of the course
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
        calculateGPA();
    }

    /**
     * Returns the GPA calculated based on the mark obtained in the course.
     *
     * @return the GPA calculated based on the mark
     */
    public float getGPA() {
        return gpa;
    }

    /**
     * Sets the GPA of the course.
     *
     * @param gpa the GPA of the course
     */
    public void setGPA(float gpa) {
        this.gpa = gpa;
    }

    /**
     * Calculates the GPA based on the mark obtained in the course.
     * The GPA is determined according to the standard grading scale.
     */
    private void calculateGPA() {
        if (mark >= 90.0f) {
            gpa = 4.0f;
        } else if (mark >= 85.0f) {
            gpa = 3.7f;
        } else if (mark >= 82.0f) {
            gpa = 3.3f;
        } else if (mark >= 78.0f) {
            gpa = 3.0f;
        } else if (mark >= 75.0f) {
            gpa = 2.7f;
        } else if (mark >= 72.0f) {
            gpa = 2.3f;
        } else if (mark >= 68.0f) {
            gpa = 2.0f;
        } else if (mark >= 64.0f) {
            gpa = 1.5f;
        } else if (mark >= 60.0f) {
            gpa = 1.0f;
        } else {
            gpa = 0.0f;
        }
    }

    /**
     * Returns a string representation of the Course object.
     *
     * @return a string representation of the Course object
     */
    @Override
    public String toString() {
        return String.format("Course name: %s, Teacher: %s, Classroom location: %s, Lesson time: %s, " +
                        "Teaching Semester: %s, Teaching School: %s, Course Credit: %d, Course Duration: %d, " +
                        "Course mark: %.2f, Course GPA: %.2f, Passed: %b", name, teacher, location, time,
                semester, school, credit, hours, mark, gpa, passed);
    }
}



package CourseMark;

import java.io.Serializable;

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

    public Course(String name, String teacher, String location, String time, String semester, String school, int credit, int hours, float mark, float gpa,boolean passed) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
        calculateGPA();
    }
    public boolean isPass() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
        calculateGPA();
    }
    public float getGPA() {
        return gpa;
    }

    public void setGPA(float gpa) {
        this.gpa = gpa;
    }

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

    @Override
    public String toString() {
        return String.format("Course name: %s, Teacher: %s, Classroom location: %s, lesson time: %s, Teaching Semester: %s, Teaching School: %s, Course Credit: %d, Course Duration: %d, course mark: %.2f, course gpa: %.2f, passed: %b", name, teacher, location, time, semester, school, credit, hours, mark,gpa, passed);
    }

}


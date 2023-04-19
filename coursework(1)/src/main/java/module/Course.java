package module;

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
    private boolean passed;

    public Course(String name, String teacher, String location, String time, String semester, String school, int credit, int hours, boolean passed) {
        this.name = name;
        this.teacher = teacher;
        this.location = location;
        this.time = time;
        this.semester = semester;
        this.school = school;
        this.credit = credit;
        this.hours = hours;
        this.passed = passed;
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

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}

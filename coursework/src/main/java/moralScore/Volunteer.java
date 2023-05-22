package moralScore;

import java.io.Serializable;
public class Volunteer implements Serializable {
    private String name;
    private String time;
    private String semester;
    private int credit;
    private int hours;
    private int volunteer_rank;
    private boolean verified;

    public Volunteer(String name, String time, String semester, int credit, int hours, int volunteer_rank, boolean verified) {
        this.name = name;
        this.time = time;
        this.semester = semester;
        this.credit = credit;
        this.hours = hours;
        this.volunteer_rank = volunteer_rank;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getvolunteer_rank() {
        return volunteer_rank;
    }

    public void setvolunteer_rank(int volunteer_rank) {
        this.volunteer_rank = volunteer_rank;
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

    public boolean isverified() {
        return verified;
    }

    public void setverified(boolean verified) {
        this.verified = verified;
    }
}

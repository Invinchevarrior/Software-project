package moralScore;

import java.io.Serializable;

/**
 * The Volunteer class represents a volunteer activity.
 * It stores information about the volunteer's name, time, semester, credit, hours, rank, and verification status.
 */
public class Volunteer implements Serializable {
    private String name;
    private String time;
    private String semester;
    private int credit;
    private int hours;
    private int volunteer_rank;
    private boolean verified;

    /**
     * Constructs a Volunteer object with the specified details.
     *
     * @param name           the name of the volunteer
     * @param time           the time of the volunteer activity
     * @param semester       the semester in which the volunteer activity took place
     * @param credit         the credit earned for the volunteer activity
     * @param hours          the number of hours spent on the volunteer activity
     * @param volunteer_rank the rank of the volunteer activity
     * @param verified       the verification status of the volunteer activity
     */
    public Volunteer(String name, String time, String semester, int credit, int hours, int volunteer_rank, boolean verified) {
        this.name = name;
        this.time = time;
        this.semester = semester;
        this.credit = credit;
        this.hours = hours;
        this.volunteer_rank = volunteer_rank;
        this.verified = verified;
    }

    /**
     * Returns the name of the volunteer.
     *
     * @return the name of the volunteer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the volunteer.
     *
     * @param name the name of the volunteer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the rank of the volunteer activity.
     *
     * @return the rank of the volunteer activity
     */
    public int getvolunteer_rank() {
        return volunteer_rank;
    }

    /**
     * Sets the rank of the volunteer activity.
     *
     * @param volunteer_rank the rank of the volunteer activity
     */
    public void setvolunteer_rank(int volunteer_rank) {
        this.volunteer_rank = volunteer_rank;
    }

    /**
     * Returns the time of the volunteer activity.
     *
     * @return the time of the volunteer activity
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the volunteer activity.
     *
     * @param time the time of the volunteer activity
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the semester in which the volunteer activity took place.
     *
     * @return the semester of the volunteer activity
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester in which the volunteer activity took place.
     *
     * @param semester the semester of the volunteer activity
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Returns the credit earned for the volunteer activity.
     *
     * @return the credit earned for the volunteer activity
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Sets the credit earned for the volunteer activity.
     *
     * @param credit the credit earned for the volunteer activity
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * Returns the number of hours spent on the volunteer activity.
     *
     * @return the number of hours spent on the volunteer activity
     */
    public int getHours() {
        return hours;
    }

    /**
     * Sets the number of hours spent on the volunteer activity.
     *
     * @param hours the number of hours spent on the volunteer activity
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Returns the verification status of the volunteer activity.
     *
     * @return the verification status of the volunteer activity
     */
    public boolean isverified() {
        return verified;
    }

    /**
     * Sets the verification status of the volunteer activity.
     *
     * @param verified the verification status of the volunteer activity
     */
    public void setverified(boolean verified) {
        this.verified = verified;
    }
}

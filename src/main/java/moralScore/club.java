package moralScore;

import java.io.Serializable;
/**
 * Represents a club in the Moral Score System.
 * A club has a name, role, semester, credit, hours, role rank, and verification status.
 */
public class club implements Serializable {
    private String name_Club;
    private String name_Role;
    private String semester;
    private int credit;
    private int hours;
    private int role_rank;
    private boolean verified;
    /**
     * Constructs a club object with the specified properties.
     *
     * @param name_Club  The name of the club.
     * @param name_Role  The name of the role.
     * @param semester   The semester associated with the club.
     * @param credit     The credit earned for the club.
     * @param hours      The number of hours spent in the club.
     * @param role_rank  The rank associated with the role.
     * @param verified   The verification status of the club.
     */
    public club(String name_Club, String name_Role, String semester, int credit, int hours, int role_rank, boolean verified) {
        this.name_Club = name_Club;
        this.name_Role = name_Role;
        this.semester = semester;
        this.credit = credit;
        this.hours = hours;
        this.role_rank = role_rank;
        this.verified = verified;
    }
    /**
     * Retrieves the role rank associated with the club.
     *
     * @return The role rank of the club.
     */
    public int get_rolerank() {
        return role_rank;
    }
    /**
     * Sets the role rank of the club.
     *
     * @param role_rank The role rank to set for the club.
     */
    public void set_rolerank(int role_rank) {
        this.role_rank = role_rank;
    }
    /**
     * Retrieves the name of the club.
     *
     * @return The name of the club.
     */
    public String getname_Club() {
        return name_Club;
    }
    /**
     * Sets the name of the club.
     *
     * @param name_Club The name to set for the club.
     */
    public void setname_Club(String name_Club) {
        this.name_Club = name_Club;
    }
    /**
     * Retrieves the name of the role.
     *
     * @return The name of the role.
     */
    public String getname_Role() {
        return name_Role;
    }
    /**
     * Sets the name of the role.
     *
     * @param name_Role The name to set for the role.
     */

    public void setname_Role(String name_Role) {
        this.name_Role = name_Role;
    }
    /**
     * Retrieves the semester associated with the club.
     *
     * @return The semester of the club.
     */
    public String getSemester() {
        return semester;
    }
    /**
     * Sets the semester for the club.
     *
     * @param semester The semester to set for the club.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }
    /**
     * Retrieves the credit earned for the club.
     *
     * @return The credit earned for the club.
     */
    public int getCredit() {
        return credit;
    }
    /**
     * Sets the credit earned for the club.
     *
     * @param credit The credit to set for the club.
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }
    /**
     * Retrieves the number of hours spent in the club.
     *
     * @return The number of hours spent in the club.
     */
    public int getHours() {
        return hours;
    }
    /**
     * Sets the number of hours spent in the club.
     *
     * @param hours The number of hours to set for the club.
     */
    public void setHours(int hours) {
        this.hours = hours;
    }
    /**
     * Checks if the club is verified.
     *
     * @return true if the club is verified, false otherwise.
     */
    public boolean isverified() {
        return verified;
    }
    /**
     * Sets the verification status of the club.
     *
     * @param passed The verification status to set for the club.
     */
    public void setverified(boolean passed) {
        this.verified = passed;
    }
}

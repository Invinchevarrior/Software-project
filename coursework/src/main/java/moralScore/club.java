package moralScore;

import java.io.Serializable;
public class club implements Serializable {
    private String name_Club;
    private String name_Role;
    private String semester;
    private int credit;
    private int hours;
    private int role_rank;
    private boolean verified;

    public club(String name_Club, String name_Role, String semester, int credit, int hours, int role_rank, boolean verified) {
        this.name_Club = name_Club;
        this.name_Role = name_Role;
        this.semester = semester;
        this.credit = credit;
        this.hours = hours;
        this.role_rank = role_rank;
        this.verified = verified;
    }

    public int get_rolerank() {
        return role_rank;
    }

    public void set_rolerank(int role_rank) {
        this.role_rank = role_rank;
    }

    public String getname_Club() {
        return name_Club;
    }

    public void setname_Club(String name_Club) {
        this.name_Club = name_Club;
    }

    public String getname_Role() {
        return name_Role;
    }

    public void setname_Role(String name_Role) {
        this.name_Role = name_Role;
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

    public void setverified(boolean passed) {
        this.verified = passed;
    }
}

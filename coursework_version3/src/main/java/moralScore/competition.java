package moralScore;

import java.io.Serializable;
public class competition implements Serializable {
    private String name_Competition;
    private String prize;
    private String semester;
    private int credit;
    private boolean verified;

    public competition(String name_Competition, String prize, String semester, int credit, int hours, boolean verified) {
        this.name_Competition = name_Competition;
        this.prize = prize;
        this.semester = semester;
        this.credit = credit;
        this.verified = verified;
    }

    public String getname_Competition() {
        return name_Competition;
    }

    public void setname_Competition(String name_Competition) {
        this.name_Competition = name_Competition;
    }

    public String getprize() {
        return prize;
    }

    public void setprize(String prize) {
        this.prize = prize;
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

    public boolean isverified() {
        return verified;
    }

    public void setverified(boolean passed) {
        this.verified = passed;
    }
}


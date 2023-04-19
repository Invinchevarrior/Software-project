package moralScore;
import java.io.*;
import java.util.ArrayList;

public class volunteerManager {
    private ArrayList<Volunteer> volunteers;
    private final String FILENAME = "volunteers.text";

    public volunteerManager() {
        volunteers = new ArrayList<>();
        loadVolunteers();
    }

    public ArrayList<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
        saveVolunteers();
    }

    public void updateVolunteer(int index, Volunteer volunteer) {
        volunteers.set(index, volunteer);
        saveVolunteers();
    }

    private void loadVolunteers() {
        File file = new File(FILENAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                volunteers = (ArrayList<Volunteer>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveVolunteers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(volunteers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


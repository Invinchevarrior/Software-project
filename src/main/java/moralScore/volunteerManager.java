package moralScore;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
/**
 * The volunteerManager class manages the collection of Volunteer objects.
 * It provides functionality to add, remove, and update volunteers, as well as load and save the data to a file.
 */
public class volunteerManager {
    private ArrayList<Volunteer> volunteers;
    private final String FILENAME = "volunteers.text";
    /**
     * Constructs a volunteerManager object.
     * Initializes the volunteers list and loads the volunteers from a file.
     */
    public volunteerManager() {
        volunteers = new ArrayList<>();
        loadVolunteers();
    }
    /**
     * Retrieves the list of volunteers.
     *
     * @return the ArrayList of Volunteer objects
     */
    public ArrayList<Volunteer> getVolunteers() {
        return volunteers;
    }
    /**
     * Removes a volunteer from the list and saves the updated list to a file.
     *
     * @param volunteer the Volunteer object to be removed
     */
    public void removevolunteer(Volunteer volunteer) {
        volunteers.remove(volunteer);
        saveVolunteers();
    }
    /**
     * Adds a volunteer to the list and saves the updated list to a file.
     *
     * @param volunteer the Volunteer object to be added
     */
    public void add(Volunteer volunteer) {
        volunteers.add(volunteer);
        saveVolunteers();
    }
    /**
     * Updates a volunteer in the list at the specified index and saves the updated list to a file.
     *
     * @param index     the index of the volunteer to be updated
     * @param volunteer the updated Volunteer object
     */
    public void updateVolunteer(int index, Volunteer volunteer) {
        volunteers.set(index, volunteer);
        saveVolunteers();
    }
    /**
     * Loads the volunteers from a file.
     * If the file exists, the volunteers are deserialized and assigned to the volunteers list.
     * If the file doesn't exist, the list remains empty.
     */
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
    /**
     * Saves the volunteers to a file.
     * The volunteers list is serialized and written to the file.
     */
    private void saveVolunteers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(volunteers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    

   
    


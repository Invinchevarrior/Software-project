package moralScore;
import java.io.*;
import java.util.ArrayList;
/**
 * Manages the operations and persistence of club objects.
 */
public class clubManager {
    private ArrayList<club> clubs;
    private final String FILENAME = "clubs.text";
    /**
     * Constructs a new instance of the clubManager class.
     */
    public clubManager() {
        clubs = new ArrayList<>();
        loadclubs();
    }
    /**
     * Removes the specified club from the list of clubs.
     *
     * @param club The club to be removed.
     */
    public void removeclub(club club) {
        clubs.remove(club);
        saveclubs();
    }
    /**
     * Adds the specified club to the list of clubs.
     *
     * @param club The club to be added.
     */
    public void addclub(club club) {
        clubs.add(club);
        saveclubs();
    }
    /**
     * Updates the club at the specified index with the new club information.
     *
     * @param index The index of the club to be updated.
     * @param club  The updated club object.
     */
    public void updateclub(int index, club club) {
        clubs.set(index, club);
        saveclubs();
    }

    private void loadclubs() {
        File file = new File(FILENAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                clubs = (ArrayList<club>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveclubs() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(clubs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the list of clubs.
     *
     * @return The list of clubs.
     */
    public ArrayList<club> getclubs() {
        return clubs;
    }
}


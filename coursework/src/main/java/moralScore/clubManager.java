package moralScore;
import java.io.*;
import java.util.ArrayList;

public class clubManager {
    private ArrayList<club> clubs;
    private final String FILENAME = "clubs.text";

    public clubManager() {
        clubs = new ArrayList<>();
        loadclubs();
    }

    public ArrayList<club> getclubs() {
        return clubs;
    }

    public void addclub(club club) {
        clubs.add(club);
        saveclubs();
    }

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
}


package achieve;

import java.io.*;
import java.util.*;

public class std_Achieve {
    private Map<String, List<String>> achievements; // declare a map to store achievements by username
    

    public std_Achieve() {
        achievements = new HashMap<>(); // initialize the map in the constructor
    }

    public void addAchievement(String username, String achievement) {
        if (achievements.containsKey(username)) { // check if the username already has achievements
            List<String> userAchievements = achievements.get(username); // get the existing list of achievements
            userAchievements.add(achievement); // add the new achievement to the existing list
        } else {
            List<String> userAchievements = new ArrayList<>(); // if there's no such a user, create a new list for the user's achievements
            userAchievements.add(achievement); // add the new achievement to the list
            achievements.put(username, userAchievements); // add new user and achievements to the map
        }
    }

    public void removeAchievement(String username, String achievement) {
        if (achievements.containsKey(username)) { // check if the user exists 
            List<String> userAchievements = achievements.get(username); // get the list of achievements for the user
            userAchievements.remove(achievement); // remove the specified achievement from the list
        }
    }

    public void modifyAchievement(String username, String oldAchievement, String newAchievement) {
        if (achievements.containsKey(username)) { // check if the username has any achievements
            List<String> userAchievements = achievements.get(username); // get the list of achievements for the user
            int index = userAchievements.indexOf(oldAchievement); // find the index of the old achievement in the list
            if (index != -1) { // if the old achievement was found in the list
                userAchievements.set(index, newAchievement); // replace it with the new achievement
            }
        }
    }

    public List<String> getAchievements(String username) {
        if (achievements.containsKey(username)) { // check if the username has any achievements
            return achievements.get(username); // return the list of achievements for the user
        } else {
            return new ArrayList<String>(); // return an empty list if the user has no achievements
        }
    }
    
    public Set<String> getAllUsernames() {
        return achievements.keySet(); // return the set of all usernames in the achievements map
    }

    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) { // write data to a file in a safe and efficient manner
            for (Map.Entry<String, List<String>> entry : achievements.entrySet()) { // iterate over the map entries
            	// a new variable "entry" of type Map.Entry<String, List<String>> which represents a single key-value pair in the map.
                String username = entry.getKey(); // get the username
                List<String> userAchievements = entry.getValue(); // get the list of achievements
                writer.println(username); // write the username to the file
                for (String achievement : userAchievements) { // iterate over the user's achievements
                    writer.println("\t"+achievement); // write each achievement to the file, indented with a tab
                }
            }
        }
    }


    public void loadFromFile(String fileName) throws IOException {
        // Create a BufferedReader to read from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String currentUsername = null;
            List<String> currentUserAchievements = null;
            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                // Ignore empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                // If the line starts with a tab, it's an achievement for the current user
                if (line.startsWith("\t")) {
                    // Add the achievement to the current user's list of achievements
                    if (currentUserAchievements != null) {
                        currentUserAchievements.add(line.trim());
                    }
                } else {
                    // If the line doesn't start with a tab, it's a new user
                    // Save the previous user's achievements (if any) to the map
                    if (currentUsername != null) {
                        achievements.put(currentUsername, currentUserAchievements);
                    }
                    // Set the current user to the new username and create a new list of achievements
                    currentUsername = line.trim();
                    currentUserAchievements = new ArrayList<>();
                }
            }
            // Save the last user's achievements (if any) to the map
            if (currentUsername != null) {
                achievements.put(currentUsername, currentUserAchievements);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        // Create a new instance of std_Achieve
        std_Achieve stdAchieve = new std_Achieve();
        // Load achievements from the file
        stdAchieve.loadFromFile("achievements.txt");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (add, remove, modify, list, save, exit):");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("add")) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter achievement:");
                String achievement = scanner.nextLine();
                stdAchieve.addAchievement(username, achievement);
            } else if (command.equalsIgnoreCase("remove")) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter achievement:");
                String achievement = scanner.nextLine();
                stdAchieve.removeAchievement(username, achievement);
            } else if (command.equalsIgnoreCase("modify")) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter old achievement:");
                String oldAchievement = scanner.nextLine();
                System.out.println("Enter new achievement:");
                String newAchievement = scanner.nextLine();
                stdAchieve.modifyAchievement(username, oldAchievement, newAchievement);
            } else if (command.equalsIgnoreCase("list")) {
                System.out.println("Enter username:");
                String username = "Yuqi Feng";
                //String username = scanner.nextLine();
                List<String> achievements = stdAchieve.getAchievements(username);
                System.out.println(username + " has the following achievements:");
                for (String achievement : achievements) {
                    System.out.println("\t" + achievement);
                }
            } else if (command.equalsIgnoreCase("save")) {
                stdAchieve.saveToFile("achievements.txt");
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid command, please try again.");
            }
        }

        scanner.close();
    }

}


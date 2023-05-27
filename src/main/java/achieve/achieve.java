package achieve;

/**
 * The achieve class is an abstract class that provides methods to manage achievements.
 * Subclasses can extend this class to implement specific achievement management functionalities.
 */
public abstract class achieve {

    /**
     * Adds an achievement for the specified username.
     *
     * @param username   the username of the user
     * @param achievement   the achievement to be added
     */
    public void addAchievement(String username, String achievement){

    }

    /**
     * Removes an achievement for the specified username.
     *
     * @param username   the username of the user
     * @param achievement   the achievement to be removed
     */
    public void removeAchievement(String username, String achievement){

    }

    /**
     * Modifies an existing achievement for the specified username.
     *
     * @param username         the username of the user
     * @param oldAchievement   the old achievement to be modified
     * @param newAchievement   the new achievement to replace the old achievement
     */
    public void modifyAchievement(String username, String oldAchievement, String newAchievement){

    }
}

package moralScore;

/**
 * The detail interface represents the operations related to details or information.
 */
public interface detail {

    /**
     * Initializes the detail.
     * This method can be overridden in implementing classes to perform initialization tasks.
     */
    default void initialize() {
        // Default implementation does nothing
    }

    /**
     * Saves the detail to a file.
     * This method can be overridden in implementing classes to define the specific saving logic.
     */
    default void saveToFile() {
        // Default implementation does nothing
    }
}
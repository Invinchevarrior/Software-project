package moralScore;

/**
 * The Dialog interface represents a dialog component.
 */
public interface Dialog {

    /**
     * Saves the information from the dialog.
     * This method can be overridden in implementing classes to define the specific saving logic.
     */
    default void saveInfo() {
        // Default implementation does nothing
    }
}

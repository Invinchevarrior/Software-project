package moralScore;
import javax.swing.*;
import java.awt.*;
/**
 * The volunteerDialog class represents a dialog for entering and editing volunteer work information.
 * It extends JDialog and implements the Dialog interface.
 */
public class volunteerDialog extends JDialog implements Dialog{
    private Volunteer volunteer;
    private JTextField[] textFields;
    private JCheckBox passedCheckBox;
    private boolean confirmed;
    /**
     * Constructs a volunteerDialog object.
     *
     * @param owner     the JFrame that owns this dialog
     * @param volunteer the Volunteer object to be edited or filled with information
     */
    public volunteerDialog(JFrame owner, Volunteer volunteer) {
        super(owner, "volunteer work information", true);
        this.volunteer = volunteer;
        this.confirmed = false;

        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(owner);

        String[] labels = {"name", "time", "semester", "volunteer_rank", "credit", "hours"};
        JPanel inputPanel = new JPanel(new GridLayout(labels.length + 1, 2));
        textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            inputPanel.add(new JLabel(labels[i]));
            textFields[i] = new JTextField();
            inputPanel.add(textFields[i]);
        }

        inputPanel.add(new JLabel("verified/not-verified"));
        passedCheckBox = new JCheckBox();
        inputPanel.add(passedCheckBox);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("save");
        saveButton.addActionListener(e -> {
            saveInfo();
            confirmed = true;
            dispose();
        });

        JButton cancelButton = new JButton("cancel");
        cancelButton.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize text fields and check box with course information
        textFields[0].setText(volunteer.getName());
        textFields[1].setText(volunteer.getTime());
        textFields[2].setText(volunteer.getSemester());
        textFields[3].setText(String.valueOf(volunteer.getvolunteer_rank()));
        textFields[4].setText(String.valueOf(volunteer.getCredit()));
        textFields[5].setText(String.valueOf(volunteer.getHours()));
        passedCheckBox.setSelected(volunteer.isverified());
    }
    /**
     * Checks if the dialog was confirmed (save button was clicked).
     *
     * @return true if the dialog was confirmed, false otherwise
     */
    public boolean isConfirmed() {
        return confirmed;
    }
    /**
     * Saves the entered information to the Volunteer object.
     */
    public void saveInfo() {
        volunteer.setName(textFields[0].getText());
        volunteer.setTime(textFields[1].getText());
        volunteer.setSemester(textFields[2].getText());
        volunteer.setvolunteer_rank(Integer.parseInt(textFields[3].getText()));
        volunteer.setCredit(Integer.parseInt(textFields[4].getText()));
        volunteer.setHours(Integer.parseInt(textFields[5].getText()));
        volunteer.setverified(passedCheckBox.isSelected());
    }
}


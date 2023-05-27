package moralScore;
import javax.swing.*;
import java.awt.*;
/**
 * Represents a dialog for entering and editing club role information.
 */
public class clubDialog extends JDialog implements Dialog{
    private club club;
    private JTextField[] textFields;
    private JCheckBox passedCheckBox;
    private boolean confirmed;
    /**
     * Constructs a new instance of the clubDialog class.
     *
     * @param owner The owner frame of the dialog.
     * @param club  The club object to be edited or added.
     */
    public clubDialog(JFrame owner, club club) {
        super(owner, "club role information", true);
        this.club = club;
        this.confirmed = false;

        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(owner);

        String[] labels = {"name_club", "name_role", "role_rank", "semester", "credit", "hours"};
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
        textFields[0].setText(club.getname_Club());
        textFields[1].setText(club.getname_Role());
        textFields[2].setText(String.valueOf(club.get_rolerank()));
        textFields[3].setText(club.getSemester());
        textFields[4].setText(String.valueOf(club.getCredit()));
        textFields[5].setText(String.valueOf(club.getHours()));
        passedCheckBox.setSelected(club.isverified());
    }
    /**
     * Checks if the dialog was confirmed (Save button was clicked).
     *
     * @return true if the dialog was confirmed, false otherwise.
     */
    public boolean isConfirmed() {
        return confirmed;
    }
    /**
     * Saves the entered club information to the club object.
     */
    public void saveInfo() {
        club.setname_Club(textFields[0].getText());
        club.setname_Role(textFields[1].getText());
        club.set_rolerank(Integer.parseInt(textFields[2].getText()));
        club.setSemester(textFields[2].getText());
        club.setCredit(Integer.parseInt(textFields[3].getText()));
        club.setHours(Integer.parseInt(textFields[4].getText()));
        club.setverified(passedCheckBox.isSelected());
    }
}



package moralScore;
import javax.swing.*;
import java.awt.*;

public class volunteerDialog extends JDialog {
    private Volunteer volunteer;
    private JTextField[] textFields;
    private JCheckBox passedCheckBox;
    private boolean confirmed;

    public volunteerDialog(JFrame owner, Volunteer volunteer) {
        super(owner, "volunteer work information", true);
        this.volunteer = volunteer;
        this.confirmed = false;

        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(owner);

        String[] labels = {"name", "time", "semester", "credit", "hours"};
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
            saveVolunteerInfo();
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
        textFields[3].setText(String.valueOf(volunteer.getCredit()));
        textFields[4].setText(String.valueOf(volunteer.getHours()));
        passedCheckBox.setSelected(volunteer.isverified());
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    private void saveVolunteerInfo() {
        volunteer.setName(textFields[0].getText());
        volunteer.setTime(textFields[1].getText());
        volunteer.setSemester(textFields[2].getText());
        volunteer.setCredit(Integer.parseInt(textFields[3].getText()));
        volunteer.setHours(Integer.parseInt(textFields[4].getText()));
        volunteer.setverified(passedCheckBox.isSelected());
    }
}


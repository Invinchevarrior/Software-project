package moralScore;
import javax.swing.*;
import java.awt.*;

public class clubDialog extends JDialog {
    private club club;
    private JTextField[] textFields;
    private JCheckBox passedCheckBox;
    private boolean confirmed;

    public clubDialog(JFrame owner, club club) {
        super(owner, "club role information", true);
        this.club = club;
        this.confirmed = false;

        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(owner);

        String[] labels = {"name_club", "name_role", "semester", "credit", "hours"};
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
            saveClubInfo();
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
        textFields[2].setText(club.getSemester());
        textFields[3].setText(String.valueOf(club.getCredit()));
        textFields[4].setText(String.valueOf(club.getHours()));
        passedCheckBox.setSelected(club.isverified());
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    private void saveClubInfo() {
        club.setname_Club(textFields[0].getText());
        club.setname_Role(textFields[1].getText());
        club.setSemester(textFields[2].getText());
        club.setCredit(Integer.parseInt(textFields[3].getText()));
        club.setHours(Integer.parseInt(textFields[4].getText()));
        club.setverified(passedCheckBox.isSelected());
    }
}



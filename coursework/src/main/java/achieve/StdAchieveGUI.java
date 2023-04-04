package achieve;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StdAchieveGUI extends JFrame implements ActionListener {
    private std_Achieve stdAchieve;
    private JTextField usernameField, achievementField, oldAchievementField, newAchievementField,removeAchievementField;  //define area for texts
    private JTextArea achievementsTextArea;
    
    public StdAchieveGUI() throws IOException {
        super("StdAchieve");
        stdAchieve = new std_Achieve();
        stdAchieve.loadFromFile("achievements.txt");  //load information from file
        
        // Create the input fields and buttons
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        inputPanel.add(new JLabel("Username:"), gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);
        usernameField = new JTextField(20);
        inputPanel.add(usernameField, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        inputPanel.add(new JLabel("Achievement:"), gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);
        achievementField = new JTextField(20);
        inputPanel.add(achievementField, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 5, 0);
        JButton addButton = new JButton("Add Achievement");
        addButton.addActionListener(this);
        inputPanel.add(addButton, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        inputPanel.add(new JLabel("Old Achievement:"), gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);
        oldAchievementField = new JTextField(20);
        inputPanel.add(oldAchievementField, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        inputPanel.add(new JLabel("New Achievement:"), gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);
        newAchievementField = new JTextField(20);
        inputPanel.add(newAchievementField, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 5, 0);
        JButton modifyButton = new JButton("Modify Achievement");
        modifyButton.addActionListener(this);
        inputPanel.add(modifyButton, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        inputPanel.add(new JLabel("Remove Achievement:"), gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);
        removeAchievementField = new JTextField(20);
        inputPanel.add(removeAchievementField, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 5, 0);
        JButton removeButton = new JButton("Remove Achievement");
        removeButton.addActionListener(this);
        inputPanel.add(removeButton, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        JButton listButton = new JButton("List Achievements");
        listButton.addActionListener(this);
        inputPanel.add(listButton, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);
        achievementsTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(achievementsTextArea);
        inputPanel.add(scrollPane, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 5, 0);
        JButton saveButton = new JButton("Save to File");
        saveButton.addActionListener(this);
        inputPanel.add(saveButton, gbc);
        
        // Add the input panel to the frame
        add(inputPanel, BorderLayout.NORTH);
        
        // Set the size and make the frame visible
        pack();
        setVisible(true);
     // List all achievements by default

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Add Achievement")) {
            String username = usernameField.getText();
            String achievement = achievementField.getText();
            stdAchieve.addAchievement(username, achievement);
        } else if (command.equals("Modify Achievement")) {
            String username = usernameField.getText();
            String oldAchievement = oldAchievementField.getText();
            String newAchievement = newAchievementField.getText();
            stdAchieve.modifyAchievement(username, oldAchievement, newAchievement);
        } else if (command.equals("List Achievements")) {
            String username = usernameField.getText();
            List<String> achievements = stdAchieve.getAchievements(username);
            achievementsTextArea.setText("");
            for (String achievement : achievements) {
                achievementsTextArea.append(achievement + "\n");
            }
        } else if(command.equals("Remove Achievement")){
        	String username = usernameField.getText();
        	String achievement = removeAchievementField.getText();
        	List<String> achievements = stdAchieve.getAchievements(username);
        	stdAchieve.removeAchievement(username, achievement);
        } else if (command.equals("Save to File")) {
            try {
                stdAchieve.saveToFile("achievements.txt");
            } catch (IOException ex) {
                System.err.println("Error saving to file: " + ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new StdAchieveGUI();
    }
}

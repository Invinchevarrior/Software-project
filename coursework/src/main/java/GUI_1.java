import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_1 extends JFrame implements ActionListener {
    private JLabel welcomeLabel, usernameLabel, passwordLabel;
    private JTextField usernameField, passwordField;
    private JButton loginButton;
    private ImageIcon background;

    public GUI_1() {
        // Set window properties
        setTitle("Learning System");
        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image
        background = new ImageIcon("image(1).jpg");
        setContentPane(new JLabel(background));

        // Set layout
        setLayout(null);

        // Add welcome label
        welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        welcomeLabel.setForeground(Color.CYAN);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setBounds(0, 0, getWidth(), getHeight() / 3);
        add(welcomeLabel);

        // Add username label and field
        usernameLabel = new JLabel("username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        usernameLabel.setForeground(Color.ORANGE);
        usernameLabel.setBounds(getWidth() / 4, getHeight() / 2, 150, 40);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(getWidth() / 4 + 150, getHeight() / 2, 250, 40);
        add(usernameField);

        // Add password label and field
        passwordLabel = new JLabel("password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        passwordLabel.setForeground(Color.BLUE);
        passwordLabel.setBounds(getWidth() / 4, getHeight() / 2 + 70, 150, 40);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(getWidth() / 4 + 150, getHeight() / 2 + 70, 250, 40);
        add(passwordField);

        // Add login button
        loginButton = new JButton("Login");
        loginButton.setBounds(getWidth() / 2 - 50, getHeight() / 2 + 140, 100, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        // Add text area for displaying login status
        JTextArea loginStatus = new JTextArea();
        loginStatus.setBounds(getWidth() / 2 - 150, getHeight() / 2 + 200, 350, 50);
        loginStatus.setFont(new Font("Arial", Font.PLAIN, 32));
        loginStatus.setEditable(false);
        add(loginStatus);
        // Add Help and About buttons
        JButton helpButton = new JButton("Help");
        helpButton.setBounds(getWidth() - 200, 20, 80, 30);
        add(helpButton);

        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(getWidth() - 100, 20, 80, 30);
        add(aboutButton);

        // Add action listener for Help button
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create new window for Help
                JFrame helpFrame = new JFrame("Help");
                helpFrame.setSize(400, 320);
                helpFrame.setLocationRelativeTo(null);

                // Add Text for Help content
                JTextArea helpText = new JTextArea();
                helpText.setBounds(getWidth() / 2 - 150, getHeight() / 2 + 200, 350, 50);
                helpText.setFont(new Font("Arial", Font.PLAIN, 32));
                helpText.setEditable(false);
                helpText.setText("This is a learning system for recording your learning situation. You can choose every option to know your information from different aspects such as marks,modules,skills and so on.");
                helpText.setLineWrap(true);
                helpFrame.add(helpText);


                // Make Help window visible
                helpFrame.setVisible(true);
            }
        });

        // Add action listener for About button
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create new window for About
                JFrame aboutFrame = new JFrame("About");
                aboutFrame.setSize(400, 320);
                aboutFrame.setLocationRelativeTo(null);

                // Add Text for About content
                JTextArea aboutText = new JTextArea();
                aboutText.setBounds(getWidth() / 2 - 150, getHeight() / 2 + 200, 350, 50);
                aboutText.setFont(new Font("Arial", Font.PLAIN, 32));
                aboutText.setEditable(false);
                aboutText.setText("This is a learning system for recording your learning situation. If you have any question, please contact with us by the email 123456@bupt.edu.cn");
                aboutText.setLineWrap(true);
                aboutFrame.add(aboutText);

                // Make About window visible
                aboutFrame.setVisible(true);
            }
        });


        // Add action listener for login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                if (username.equals("Yuqi Feng")) { // Check if username is correct
                    if (password.equals("123456")) { // Check if password is correct
                        loginStatus.setText("Successfully log in!");
                        new page2();
                    } else {
                        loginStatus.setText("Wrong password");
                    }
                } else {
                    loginStatus.setText("Wrong username");
                }
            }
        });

        // Make window visible
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args){
        new GUI_1();
    }

}

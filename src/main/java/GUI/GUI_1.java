package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
/**
 * This class represents a graphical user interface (GUI) for a Learning System login.
 * It provides a login interface with username and password fields, a login button, and options for Help and About.
 * The GUI_1 class extends JFrame and implements the ActionListener interface for event handling.
 *
 * The GUI consists of a background image, a welcome label, username and password labels with corresponding input fields,
 * a login button, and a text area for displaying login status. It also includes Help and About buttons, which open
 * separate windows to display help and about information.
 *
 * The login button performs authentication by checking the entered username and password. If the credentials are correct,
 * a "Successfully log in!" message is displayed, and a new page (page2) is opened. Otherwise, appropriate error messages
 * are shown for incorrect username or password.
 *
 * The Help button opens a new window with information about the learning system and its functionalities.
 *
 * The About button opens a new window with information about the learning system and a contact email.
 *
 * The GUI_1 class includes the main method to create an instance of the GUI and make it visible.
 *
 * Note: This code assumes the presence of an image file "image(1).jpg" in the same directory as the code.
 *
 * @author Group 23
 * @version 1.0
 * @since 2023-5-1
 */
public class GUI_1 extends JFrame implements ActionListener {
    private JLabel welcomeLabel, usernameLabel, passwordLabel;
    private JTextField usernameField, passwordField;
    private JButton loginButton;
    private ImageIcon background;
    /**
     * Constructs an instance of the GUI_1 class.
     * Initializes the window properties, sets the background image, and defines the layout.
     * Adds the welcome label, username and password labels with input fields, login button, and login status text area.
     * Also adds Help and About buttons with corresponding action listeners.
     * Finally, makes the window visible.
     */
    public GUI_1() {
        // Set window properties
        setTitle("Learning System");
        setSize(800, 688);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
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
            /**
             * Invoked when the Help button is clicked.
             * Opens a new window with information about the learning system and its functionalities.
             */
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
            /**
             * Invoked when the About button is clicked.
             * Opens a new window with information about the learning system and a contact email.
             */
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
            /**
             * Invoked when the login button is clicked.
             * Performs authentication by checking the entered username and password.
             * Displays appropriate login status messages.
             * Opens a new page (page2) if the credentials are correct.
             */
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                if (username.equals("Peter")) { // Check if username is correct
                    if (password.equals("123456")) { // Check if password is correct
                        loginStatus.setText("Successfully log in!");
                        Locale.setDefault(Locale.ENGLISH);
                        new page2();
                        setVisible(false);
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
    /**
     * Implementation of the actionPerformed method from the ActionListener interface.
     * No action is performed in this method.
     *
     * @param e the ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    /**
     * The entry point of the program.
     * Creates an instance of the GUI_1 class to display the login interface.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        new GUI_1();
    }

}

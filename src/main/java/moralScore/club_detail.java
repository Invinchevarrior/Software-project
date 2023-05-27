package moralScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Represents the club details user interface for the Moral Score System.
 * It allows users to view, add, edit, and delete club roles.
 */
public class club_detail implements detail {
    private JFrame frame;
    private JList<String> clubList;
    private clubManager clubManager;
    private DefaultListModel<String> clubListModel;
    /**
     * The main method to launch the club detail application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                club_detail window = new club_detail();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * Constructs a new instance of the club_detail class.
     */
    public club_detail() {
        clubManager = new clubManager();
        initialize();
    }

    /**
     * Initializes the club detail user interface.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Volunteer Activity_detail");
        frame.setBounds(100, 100, 900, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setVisible(true);

        clubListModel = new DefaultListModel<>();
        clubList = new JList<>(clubListModel);

        JScrollPane scrollPane1 = new JScrollPane(clubList);
        frame.getContentPane().add(scrollPane1, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton addButton2 = new JButton("Add club roles");
        addButton2.addActionListener(e2 -> {
            club club = new club("", "", "", 0, 0, 0, false);
            clubDialog dialog2 = new clubDialog(frame, club);
            dialog2.setVisible(true);

            if (dialog2.isConfirmed()) {
                clubManager.addclub(club);
                clubListModel.addElement("Name: " + club.getname_Club() +"              Roles undertaken: "+ club.getname_Role()  +"              RolesRank: "+ club.get_rolerank()+"              Credit: "+ club.getCredit() + "              Semester: "+ club.getSemester() + "              Hours: " + club.getHours()+"              Verified: " + club.isverified());
            }
        });


        JButton editButton2 = new JButton("Edit role undertaken");
        editButton2.addActionListener(e4 -> {
            int selectedIndex2 = clubList.getSelectedIndex();
            
            if (selectedIndex2 != -1 ) {

                club club = clubManager.getclubs().get(selectedIndex2);
                clubDialog dialog2 = new clubDialog(frame, club);
                dialog2.setVisible(true);

                if (dialog2.isConfirmed()) {
                    clubManager.updateclub(selectedIndex2, club);
                    clubListModel.set(selectedIndex2, "Name: " + club.getname_Club() +"              Roles undertaken: "+ club.getname_Role()  +"              RolesRank: "+ club.get_rolerank()+"              Credit: "+ club.getCredit() + "              Semester: "+ club.getSemester() + "              Hours: " + club.getHours()+"              Verified: " + club.isverified());
                }

            } else {
                JOptionPane.showMessageDialog(frame, "Please select one to edit");
            }
        });

        JButton deleteButton = new JButton("Delete role undertaken");
        deleteButton.addActionListener(e4 -> {
            int selectedIndex2 = clubList.getSelectedIndex();
            
            if (selectedIndex2 != -1 ) {
                club club = clubManager.getclubs().get(selectedIndex2);
                clubManager.removeclub(club);
                clubListModel.removeElementAt(selectedIndex2);

            } else {
                JOptionPane.showMessageDialog(frame, "Please select one to delete");
            }
        });

        JButton printButton = new JButton("Save and print");
        printButton.addActionListener(e -> {
            try {
                saveToFile("Save_club.txt");
            } catch (IOException e5) {
                // TODO Auto-generated catch block
                e5.printStackTrace();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {

            frame.setVisible(false);
            
        });

        buttonPanel.add(printButton);

        buttonPanel.add(addButton2);

        buttonPanel.add(editButton2);

        buttonPanel.add(deleteButton);

        buttonPanel.add(backButton);

        // initialize the list with some data

        for (club club : clubManager.getclubs()) {
            clubListModel.addElement("Name: " + club.getname_Club() +"              Roles undertaken: "+ club.getname_Role()  +"              RolesRank: "+ club.get_rolerank()+"              Credit: "+ club.getCredit() + "              Semester: "+ club.getSemester() + "              Hours: " + club.getHours()+"              Verified: " + club.isverified());
        }

    }
    /**
     * Saves the club details to a file.
     *
     * @param fileName The name of the file to save the club details to.
     * @throws IOException If an I/O error occurs while saving the file.
     */
    public void saveToFile(String fileName) throws IOException {
        detail.super.saveToFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) { // write data to a file in a safe and efficient manner

            for (club club : clubManager.getclubs()) {
                    writer.println("\t"+"Name: " + club.getname_Club() +"              Roles undertaken: "+ club.getname_Role()  +"              RolesRank: "+ club.get_rolerank()+"              Credit: "+ club.getCredit() + "              Semester: "+ club.getSemester() + "              Hours: " + club.getHours()+"              Verified: " + club.isverified()); // write each achievement to the file, indented with a tab
                }
            }
        }


}

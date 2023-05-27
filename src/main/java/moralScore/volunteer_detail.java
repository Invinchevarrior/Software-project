package moralScore;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * The volunteer_detail class represents the graphical user interface for managing volunteer activities.
 * It allows adding, editing, and deleting volunteer activities, as well as saving and printing the data.
 */
public class volunteer_detail implements detail{
    private JFrame frame;
    private JList<String> volunteerList;
    private volunteerManager volunteerManager;
    private DefaultListModel<String> volunteerListModel;
    /**
     * The main entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                volunteer_detail window = new volunteer_detail();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * Constructs a volunteer_detail object.
     */
    public volunteer_detail() {
        volunteerManager = new volunteerManager();
        initialize();
    }

    /**
     * Initializes the graphical user interface.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Volunteer Activity_detail");
        frame.setBounds(100, 100, 900, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setVisible(true);

        volunteerListModel = new DefaultListModel<>();
        volunteerList = new JList<>(volunteerListModel);
      
        JScrollPane scrollPane1 = new JScrollPane(volunteerList);

        frame.getContentPane().add(scrollPane1, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton addButton1 = new JButton("Add volunteer works");
        addButton1.addActionListener(e1 -> {
            Volunteer volunteer = new Volunteer("", "", "", 0, 0, 0, false);
            volunteerDialog dialog1 = new volunteerDialog(frame, volunteer);
            dialog1.setVisible(true);

            if (dialog1.isConfirmed()) {
                volunteerManager.add(volunteer);
                volunteerListModel.addElement("Name: "  + volunteer.getName() +"              Volunteer_rank: "+ volunteer.getvolunteer_rank()+"              Time: "+ volunteer.getTime()+"              Semester: " + volunteer.getSemester() + "              Credit: "+ volunteer.getCredit() + "              Hours: " + volunteer.getHours()+ "              Verified: "+ volunteer.isverified());
            }
        });
        JButton editButton1 = new JButton("Edit volunteer work");
        editButton1.addActionListener(e3 -> {
            int selectedIndex1 = volunteerList.getSelectedIndex();
            

            if (selectedIndex1 != -1 ) {
                Volunteer volunteer = volunteerManager.getVolunteers().get(selectedIndex1);
                volunteerDialog dialog1 = new volunteerDialog(frame, volunteer);
                dialog1.setVisible(true);

                if (dialog1.isConfirmed()) {
                    volunteerManager.updateVolunteer(selectedIndex1, volunteer);
                    volunteerListModel.set(selectedIndex1, "Name: "  + volunteer.getName() +"              Volunteer_rank: "+ volunteer.getvolunteer_rank()+"              Time: "+ volunteer.getTime()+"              Semester: " + volunteer.getSemester() + "              Credit: "+ volunteer.getCredit() + "              Hours: " + volunteer.getHours()+ "              Verified: "+ volunteer.isverified());
                }


            } else {
                JOptionPane.showMessageDialog(frame, "Please select one to edit");
            }
        });

        JButton deleteButton = new JButton("Delete volunteer work");
        deleteButton.addActionListener(e4 -> {
            int selectedIndex2 = volunteerList.getSelectedIndex();
            
            if (selectedIndex2 != -1 ) {
                Volunteer volunteer = volunteerManager.getVolunteers().get(selectedIndex2);
                volunteerManager.removevolunteer(volunteer);
                volunteerListModel.removeElementAt(selectedIndex2);

            } else {
                JOptionPane.showMessageDialog(frame, "Please select one to delete");
            }
        });


        JButton printButton = new JButton("Save and print");
        printButton.addActionListener(e -> {
            try {
                saveToFile("Save_volunteer.txt");
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

        buttonPanel.add(addButton1);

        buttonPanel.add(editButton1);

        buttonPanel.add(deleteButton);

        buttonPanel.add(backButton);


        // initialize the list with some data
        for (Volunteer volunteer : volunteerManager.getVolunteers()) {
            volunteerListModel.addElement("Name: "  + volunteer.getName() +"              Volunteer_rank: "+ volunteer.getvolunteer_rank()+"              Time: "+ volunteer.getTime()+"              Semester: " + volunteer.getSemester() + "              Credit: "+ volunteer.getCredit() + "              Hours: " + volunteer.getHours()+ "              Verified: "+ volunteer.isverified());
        }

    }

    /**
     * Saves the volunteer activities to a file with the given file name.
     *
     * @param fileName the name of the file to save the volunteer activities to
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void saveToFile(String fileName) throws IOException {
        detail.super.saveToFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) { // write data to a file in a safe and efficient manner
            for (Volunteer volunteer : volunteerManager.getVolunteers()) {
                    writer.println("\t"+ "Name: "  + volunteer.getName() +"              Volunteer_rank: "+ volunteer.getvolunteer_rank()+"              Time: "+ volunteer.getTime()+"              Semester: " + volunteer.getSemester() + "              Credit: "+ volunteer.getCredit() + "              Hours: " + volunteer.getHours()+ "              Verified: "+ volunteer.isverified()); // write each achievement to the file, indented with a tab
                }
            }
        }
}

package moralScore;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class volunteer_detail {
    private JFrame frame;
    private JList<String> volunteerList;
    private volunteerManager volunteerManager;
    private DefaultListModel<String> volunteerListModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                volunteer_detail window = new volunteer_detail();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public volunteer_detail() {
        volunteerManager = new volunteerManager();
        initialize();
    }

    private void initialize() {
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
                volunteerManager.addVolunteer(volunteer);
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

                // club club = clubManager.getclubs().get(selectedIndex2);
                // clubDialog dialog2 = new clubDialog(frame, club);
                // dialog2.setVisible(true);

                if (dialog1.isConfirmed()) {
                    volunteerManager.updateVolunteer(selectedIndex1, volunteer);
                    volunteerListModel.set(selectedIndex1, "Name: "  + volunteer.getName() +"              Volunteer_rank: "+ volunteer.getvolunteer_rank()+"              Time: "+ volunteer.getTime()+"              Semester: " + volunteer.getSemester() + "              Credit: "+ volunteer.getCredit() + "              Hours: " + volunteer.getHours()+ "              Verified: "+ volunteer.isverified());
                }

                // if (dialog2.isConfirmed()) {
                //     clubManager.updateclub(selectedIndex2, club);
                //     clubListModel.set(selectedIndex2, club.getname_Club() +"          Roles undertaken:"+ club.getname_Role()  +"                Credit:"+ club.getCredit() + "                        Hours:" + club.getHours());
                // }

            } else {
                JOptionPane.showMessageDialog(frame, "Please select one to edit");
            }
        });

        JButton deleteButton = new JButton("Delete volunteer work");
        deleteButton.addActionListener(e4 -> {
            int selectedIndex2 = volunteerList.getSelectedIndex();
            
            if (selectedIndex2 != -1 ) {
                // Volunteer volunteer = volunteerManager.getVolunteers().get(selectedIndex1);
                // volunteerDialog dialog1 = new volunteerDialog(frame, volunteer);
                // dialog1.setVisible(true);

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


        // 初始化课程列表
        for (Volunteer volunteer : volunteerManager.getVolunteers()) {
            volunteerListModel.addElement("Name: "  + volunteer.getName() +"              Volunteer_rank: "+ volunteer.getvolunteer_rank()+"              Time: "+ volunteer.getTime()+"              Semester: " + volunteer.getSemester() + "              Credit: "+ volunteer.getCredit() + "              Hours: " + volunteer.getHours()+ "              Verified: "+ volunteer.isverified());
        }

    }

    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) { // write data to a file in a safe and efficient manner
            for (Volunteer volunteer : volunteerManager.getVolunteers()) { 
                // // iterate over the map entries
                // // a new variable "entry" of type Map.Entry<String, List<String>> which represents a single key-value pair in the map.
                // String username = entry.getKey(); // get the username
                // ArrayList<String> userAchievements = entry.getValue(); // get the list of achievements
                // writer.println(username); // write the username to the file
                // for (String achievement : userAchievements) { // iterate over the user's achievements
                    writer.println("\t"+ "Name: "  + volunteer.getName() +"              Volunteer_rank: "+ volunteer.getvolunteer_rank()+"              Time: "+ volunteer.getTime()+"              Semester: " + volunteer.getSemester() + "              Credit: "+ volunteer.getCredit() + "              Hours: " + volunteer.getHours()+ "              Verified: "+ volunteer.isverified()); // write each achievement to the file, indented with a tab
                }
            }
        }


}

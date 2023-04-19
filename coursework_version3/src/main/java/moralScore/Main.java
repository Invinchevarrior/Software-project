package moralScore;
import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame;
    private JList<String> volunteerList;
    private volunteerManager volunteerManager;
    private DefaultListModel<String> volunteerListModel;

    private JList<String> clubList;
    private clubManager clubManager;
    private DefaultListModel<String> clubListModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main window = new Main();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        volunteerManager = new volunteerManager();
        clubManager = new clubManager();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setVisible(true);

        volunteerListModel = new DefaultListModel<>();
        volunteerList = new JList<>(volunteerListModel);

        
        clubListModel = new DefaultListModel<>();
        clubList = new JList<>(clubListModel);

        JScrollPane scrollPane1 = new JScrollPane(volunteerList);
        JScrollPane scrollPane2 = new JScrollPane(clubList);
        frame.getContentPane().add(scrollPane1, BorderLayout.CENTER);
        frame.getContentPane().add(scrollPane2, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton addButton1 = new JButton("Add volunteer works");
        addButton1.addActionListener(e1 -> {
            Volunteer volunteer = new Volunteer("", "", "", 0, 0, false);
            volunteerDialog dialog1 = new volunteerDialog(frame, volunteer);
            dialog1.setVisible(true);

            if (dialog1.isConfirmed()) {
                volunteerManager.addVolunteer(volunteer);
                volunteerListModel.addElement(volunteer.getName() +  "                                 Credit:"+ volunteer.getCredit() + "                                      Hours:" + volunteer.getHours());
            }
        });

        JButton addButton2 = new JButton("Add club roles");
        addButton2.addActionListener(e2 -> {
            club club = new club("", "", "", 0, 0, false);
            clubDialog dialog2 = new clubDialog(frame, club);
            dialog2.setVisible(true);

            if (dialog2.isConfirmed()) {
                clubManager.addclub(club);
                clubListModel.addElement(club.getname_Club() +"          Roles undertaken:"+ club.getname_Role()  +"                Credit:"+ club.getCredit() + "                        Hours:" + club.getHours());
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
                    volunteerListModel.set(selectedIndex1, volunteer.getName() +  "                                 Credit:"+ volunteer.getCredit() + "                                      Hours:" + volunteer.getHours());
                }

                // if (dialog2.isConfirmed()) {
                //     clubManager.updateclub(selectedIndex2, club);
                //     clubListModel.set(selectedIndex2, club.getname_Club() +"          Roles undertaken:"+ club.getname_Role()  +"                Credit:"+ club.getCredit() + "                        Hours:" + club.getHours());
                // }

            } else {
                JOptionPane.showMessageDialog(frame, "Please select one to edit");
            }
        });

        JButton editButton2 = new JButton("Edit role undertaken");
        editButton2.addActionListener(e4 -> {
            int selectedIndex2 = clubList.getSelectedIndex();


            if (selectedIndex2 != -1 ) {
                // Volunteer volunteer = volunteerManager.getVolunteers().get(selectedIndex1);
                // volunteerDialog dialog1 = new volunteerDialog(frame, volunteer);
                // dialog1.setVisible(true);

                club club = clubManager.getclubs().get(selectedIndex2);
                clubDialog dialog2 = new clubDialog(frame, club);
                dialog2.setVisible(true);

                if (dialog2.isConfirmed()) {
                    clubManager.updateclub(selectedIndex2, club);
                    clubListModel.set(selectedIndex2, club.getname_Club() +"          Roles undertaken:"+ club.getname_Role()  +"                Credit:"+ club.getCredit() + "                        Hours:" + club.getHours());
                }

                // if (dialog2.isConfirmed()) {
                //     clubManager.updateclub(selectedIndex2, club);
                //     clubListModel.set(selectedIndex2, club.getname_Club() +"          Roles undertaken:"+ club.getname_Role()  +"                Credit:"+ club.getCredit() + "                        Hours:" + club.getHours());
                // }

            } else {
                JOptionPane.showMessageDialog(frame, "Please select one to edit");
            }
        });


        buttonPanel.add(addButton1);
        buttonPanel.add(addButton2);
        buttonPanel.add(editButton1);
        buttonPanel.add(editButton2);

        // 初始化课程列表
        for (Volunteer volunteer : volunteerManager.getVolunteers()) {
            volunteerListModel.addElement(volunteer.getName() +  "                                 Credit:"+ volunteer.getCredit() + "                                      Hours:" + volunteer.getHours());
        }

        for (club club : clubManager.getclubs()) {
            clubListModel.addElement(club.getname_Club() +"          Roles undertaken:"+ club.getname_Role()  +"                Credit:"+ club.getCredit() + "                        Hours:" + club.getHours());
        }

    }
}

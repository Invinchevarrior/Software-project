import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import skills.Skill_GUI;
import achieve.*;
import moralScore.Main;


public class RecordList extends JFrame implements ActionListener {
    public RecordList() {
        // Set JFrame properties
        setTitle("Learning System");
        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Create panel
//        JPanel panel = new JPanel();

        // add panel to frame
//        add(panel);

        // set the layout as 3*2
//         setLayout(new GridLayout(3, 2));
        //set background image
        setContentPane(new JLabel(new ImageIcon("image(1).jpg")));
        setLayout(new GridLayout(3, 2, 80, 80)); // 3 rows, 2 columns, 80 pixels gap

        // 创建6个按钮
        JButton modulesBtn = new JButton("modules");
        JButton skillsBtn = new JButton("skills");
        JButton marksBtn = new JButton("marks");
        JButton achievementBtn = new JButton("achievement");
        JButton rolesBtn = new JButton("roles undertaken");
        JButton homeBtn = new JButton("HOME");


        // 将按钮添加到面板
        add(modulesBtn);
        add(skillsBtn);
        add(marksBtn);
        add(achievementBtn);
        add(rolesBtn);
        add(homeBtn);

        // 设置每个按钮的功能

        // modules按钮的功能
        modulesBtn.addActionListener(e -> {
            // TODO: 实现modules按钮的功能
            new module.Main();
        });

        // skills按钮的功能
        skillsBtn.addActionListener(e -> {
            // TODO: 实现skills按钮的功能

            Skill_GUI demo = null;
            try {
                demo = new Skill_GUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // marks按钮的功能
        marksBtn.addActionListener(e -> {
            // TODO: 实现marks按钮的功能
            new CourseMark.Main();
        });

        // achievement按钮的功能
        achievementBtn.addActionListener(e -> {
            // TODO: 实现achievement按钮的功能
            try {
                new StdAchieveGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // roles undertaken按钮的功能
        rolesBtn.addActionListener(e -> {
            // TODO: 实现roles undertaken按钮的功能
            new Main();
        });

        // HOME按钮的功能
        homeBtn.addActionListener(e -> {
            // TODO: 实现HOME按钮的功能
            new GUI_1();
            setVisible(false);
        });

        // 设置窗口可见性
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args){
        new RecordList();
    }
}


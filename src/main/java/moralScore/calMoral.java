package moralScore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Represents the Moral Calculation window of the Moral Score System.
 * This window displays tables for club and volunteer information, allows input of statistics,
 * calculates moral scores based on user inputs, and provides navigation options.
 */
public class calMoral extends JFrame{
    private DefaultTableModel model, model1;
    private JTable table, table1;
    private JButton addBtn;
    private clubManager clubManager;
    private volunteerManager volunteerManager;
    private int credit1, credit2;
    private JPanel buttonPanel = new JPanel();
    private JLabel Credit2Lable, Credit1Lable;
    private JLabel Account1Lable, Account2Lable;
    private JTextField Account1Field, Account2Field;
    /**
     * Sets the credit for volunteer experience.
     *
     * @param credit The credit for volunteer experience to set.
     */
    public void setCredit1(int credit) {
        this.credit1 = credit;
    }
    /**
     * Retrieves the credit for volunteer experience.
     *
     * @return The credit for volunteer experience.
     */
    public int getCredit1() {
        return credit1;
    }
    /**
     * Sets the credit for roles undertaken.
     *
     * @param credit The credit for roles undertaken to set.
     */
    public void setCredit2(int credit) {
        this.credit2 = credit;
    }
    /**
     * Retrieves the credit for roles undertaken.
     *
     * @return The credit for roles undertaken.
     */
    public int getCredit2() {
        return credit2;
    }

    /**
     * Constructs the calMoral window.
     * Sets up the table models, buttons, labels, and text fields.
     * Also calculates the credits for volunteer experience and roles undertaken.
     */
    public calMoral() {
        super("Moral Calculation Table");
        String[][] datas = {};
        String[] titles = {"Name", "Rank", "Hour", "Credit"};

        String[][] datas1 = {};
        String[] titles1 = {"Roles Undertaken Credit", "Volunteer Activity Credit", "Roles Undertaken Account", "Volunteer Activity Account", "Total Score"};

        clubManager = new clubManager();
        volunteerManager = new volunteerManager();

        model = new DefaultTableModel(datas, titles);
        model1 = new DefaultTableModel(datas1, titles1);

        table = new JTable(model);
        table1 = new JTable(model1);

        addBtn = new JButton("Input statistics");

        addBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ArrayList<club> clubs =  clubManager.getclubs();
            ArrayList<Volunteer> volunteers = volunteerManager.getVolunteers();

            for (club club : clubs) {
                model.addRow(new String[] { club.getname_Club(), String.valueOf(club.get_rolerank()), String.valueOf(club.getHours()), String.valueOf(club.getCredit())});
            }        
            
            for (Volunteer volunteer : volunteers) {
                model.addRow(new String[] { volunteer.getName(), String.valueOf(volunteer.getvolunteer_rank()), String.valueOf(volunteer.getHours()), String.valueOf(volunteer.getCredit())});
            }

            model1.addRow(new String[] { String.valueOf(credit1), String.valueOf(credit2), "To be added", "To be added"});


        }
        });
        ArrayList<club> clubs =  clubManager.getclubs();
        ArrayList<Volunteer> volunteers = volunteerManager.getVolunteers();

        for (club club : clubs) {
            credit1 += club.getCredit();
        }        
        
        for (Volunteer volunteer : volunteers) {
            credit2 += volunteer.getCredit();
        }

        Credit1Lable = new JLabel("Credit of Volunteer Experience: " + credit2);
        Credit2Lable = new JLabel("Credit of Roles Undertaken: " + credit1);
        Credit1Lable.setBounds(5, 300, 500, 40);
        Credit2Lable.setBounds(5, 275, 500, 40);
        add(Credit1Lable);
        add(Credit2Lable);
        
        Account1Lable = new JLabel("Account of Volunteer Experience: ");
        Account2Lable = new JLabel("Account of Roles Undertaken: ");
        Account1Lable.setBounds(5, 350, 225, 40);
        Account2Lable.setBounds(5, 325, 225, 40);
        add(Account1Lable);
        add(Account2Lable);

        Account1Field = new JTextField();
        Account1Field.setBounds(250, 365, 50, 18);
        add(Account1Field);

        Account2Field = new JTextField();
        Account2Field.setBounds(250, 340, 50, 18);
        add(Account2Field);

        JTextArea result = new JTextArea();
        result.setBounds(340, 290, 100, 20);
        result.setEditable(false);
        add(result);


        add(addBtn, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        setSize(500, 500);
        setLocationRelativeTo(null);


        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        

        JButton calButton = new JButton("Calculate");
        calButton.addActionListener(e -> {
        Float account1Float = Account1FieldgetText();
        Float account2Float = Account2FieldgetText();

        Float total = (float)credit1*account2Float + (float)credit2*account1Float;


        result.setText("Moral score:" + total);
  

        System.out.println(total);
            
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {

            setVisible(false);
            
        });
        buttonPanel.add(calButton);
        buttonPanel.add(backButton);

        setVisible(true);
    }
    /**
     * Retrieves the value from the Account2Field as a Float.
     *
     * @return The value from the Account2Field as a Float.
     */
        private Float Account2FieldgetText() {
        return Float.parseFloat(Account2Field.getText());
    }
    /**
     * Retrieves the value from the Account1Field as a Float.
     *
     * @return The value from the Account1Field as a Float.
     */
        private Float Account1FieldgetText() {
        return Float.parseFloat(Account1Field.getText());
    }
    /**
     * The entry point of the application.
     * Creates an instance of the calMoral window to start the program.
     *
     * @param args The command-line arguments passed to the program.
     */
        public static void main(String[] args) {
            new calMoral();
        }

    }    


package skills;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import javax.swing.*;

/**
 * The modify_GUI class represents a graphical user interface for modifying skills.
 * It allows the user to modify skills of different categories such as Language, Software, Hardware, and more.
 */
public class modify_GUI extends JFrame{

    private JButton Language;
    private JButton Software;
    private JButton Hardware;
    private TextArea textArea;
    private JButton Help;
    private JButton Others;
    private JButton Knowledge_and_Theoretical;
    String[] save=new String[5];
    int con=0;

    private Container container;

    private File targetFile;
    /**
     * Constructs a modify_GUI object.
     *
     * @throws IOException If an I/O error occurs.
     */
    public modify_GUI() throws IOException {
        //set the title
        super("Modify your skills");

        setLocationRelativeTo(null);
        setResizable(false);
        //set the layout
        setLayout(new FlowLayout());

        //obtain the container
        container = getContentPane();

        //create an object of the file
        String dir="skills.txt";
        targetFile = new File(dir);


        textArea = new TextArea();
        Language = new JButton("Language");
        Software = new JButton("Software");
        Hardware=new JButton("Hardware");
        Help=new JButton("Help");
        Help.setBackground(Color.RED);
        Others=new JButton("Others");
        Knowledge_and_Theoretical =new JButton("Knowledge and Theoretical");
        JPanel jPanel = new JPanel();

        Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel,"Please input your skill that be modified and then choose the button below.");
            }
        });
        Language.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    container = getContentPane();
                    String kind="Language";
                    BufferedReader br = new BufferedReader(new FileReader(targetFile));
                    String line;
                    for (line = br.readLine(); line != null; line = br.readLine()) {
                        con++;
                        save[con-1]=line;
                        if (line.contains(kind)) {
                            int number = kind.length();
                            String old_content = line.substring(number + 1, save[con-1].length());
                            String result1 = textArea.getText();
                            line = line.replace(old_content, result1);
                            save[con-1]=line;
                        }

                    }
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter(targetFile));
                    for(con=1;con<6;con++){
                        bw1.write(save[con-1]);
                        bw1.newLine();
                    }
                    //bw1.flush();
                    bw1.close();
                    textArea.setText("");
                    con=0;
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        Software.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    container = getContentPane();
                    String kind="Software";
                    BufferedReader br = new BufferedReader(new FileReader(targetFile));
                    String line;
                    for (line = br.readLine(); line != null; line = br.readLine()) {
                        con++;
                        save[con-1]=line;
                        if (line.contains(kind)) {
                            int number = kind.length();
                            String old_content = line.substring(number + 1, save[con-1].length());
                            String result1 = textArea.getText();
                            line = line.replace(old_content, result1);
                            save[con-1]=line;
                        }

                    }
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter(targetFile));
                    for(con=1;con<6;con++){
                        bw1.write(save[con-1]);
                        bw1.newLine();
                    }
                    bw1.close();
                    textArea.setText("");
                    con=0;
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


            }
        });

        Hardware.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    container = getContentPane();
                    String kind="Hardware";
                    BufferedReader br = new BufferedReader(new FileReader(targetFile));
                    String line;

                    for (line = br.readLine(); line != null; line = br.readLine()) {
                        con++;
                        save[con-1]=line;
                        if (line.contains(kind)) {
                            int number = kind.length();
                            String old_content = line.substring(number + 1, line.length());
                            String result3 = textArea.getText();
                            line = line.replace(old_content, result3);
                            save[con-1]=line;
                        }

                    }
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter(targetFile));
                    for(con=1;con<6;con++){
                        bw1.write(save[con-1]);
                        bw1.newLine();
                    }
                    bw1.flush();
                    bw1.close();
                    textArea.setText("");
                    con=0;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Others.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    container = getContentPane();
                    String kind="Others";
                    BufferedReader br = new BufferedReader(new FileReader(targetFile));
                    String line;

                    for (line = br.readLine(); line != null; line = br.readLine()) {
                        con++;
                        save[con-1]=line;
                        if (line.contains(kind)) {
                            int number = kind.length();
                            String old_content = line.substring(number + 1, line.length());
                            String result4 = textArea.getText();
                            line = line.replace(old_content, result4);
                            save[con-1]=line;
                        }

                    }
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter(targetFile));
                    for(con=1;con<6;con++){
                        bw1.write(save[con-1]);
                        bw1.newLine();
                    }
                    bw1.flush();
                    bw1.close();
                    textArea.setText("");
                    con=0;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Knowledge_and_Theoretical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    container = getContentPane();
                    String kind="Knowledge and Theoretical skills";
                    BufferedReader br = new BufferedReader(new FileReader(targetFile));
                    String line;

                    for (line = br.readLine(); line != null; line = br.readLine()) {
                        con++;
                        save[con-1]=line;
                        if (line.contains(kind)) {
                            int number = kind.length();
                            String old_content = line.substring(number + 1, line.length());
                            String result5 = textArea.getText();
                            line = line.replace(old_content, result5);
                            save[con-1]=line;
                        }

                    }
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter(targetFile));
                    for(con=1;con<6;con++){
                        bw1.write(save[con-1]);
                        bw1.newLine();
                    }
                    bw1.flush();
                    bw1.close();
                    textArea.setText("");
                    con=0;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        container.add(textArea);
        container.add(Help);
        container.add(Software);
        container.add(Language);
        container.add(Hardware);
        container.add(Knowledge_and_Theoretical);
        container.add(Others);
        setSize(600, 300);
        setVisible(true);
    }
    /**
     * The main method that launches the modify_GUI.
     *
     * @param args The command-line arguments.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {


        modify_GUI demo = new modify_GUI();
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
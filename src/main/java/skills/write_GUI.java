package skills;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

/**
 * The write_GUI class represents a graphical user interface (GUI) for writing skills.
 * It provides options to write skills in different categories using buttons and a text area.
 */
public class write_GUI extends JFrame{

    //components
    private JButton Language;
    private JButton Software;
    private JButton Hardware;
    private TextArea textArea;
    private JButton Help;
    private JButton Others;
    private JButton Knowledge_and_Theoretical;

    //container
    private Container container;

    //objective file
    private File targetFile;
    /**
     * Constructs a write_GUI object.
     *
     * @throws IOException If an I/O error occurs.
     */
    public write_GUI() throws IOException {
        //set the title
        super("Write your skills");

        //set the layout
        setLayout(new FlowLayout());

        //obtain the container
        container = getContentPane();

        //create an object of the file
        String dir="skills.txt";
        targetFile = new File(dir);
        if(targetFile.createNewFile()) {
            System.out.println("File doesn't exist.Successfully create!");
        }else {
            System.out.println("File exists");
        }

        setLocation(350,180);
        setResizable(false);

        textArea = new TextArea();
        Language = new JButton("Language");
        Software = new JButton("Software");
        Hardware=new JButton("Hardware");
        Help=new JButton("Help");
        Help.setBackground(Color.RED);
        Others=new JButton("Others");
        Knowledge_and_Theoretical =new JButton("Knowledge and Theoretical");
        JPanel jPanel = new JPanel();
        BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));

        Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel,"Please input your skill first and then choose the button below.");
            }
        });
        Language.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                     container = getContentPane();

                    //write into the file
                    writer.write("Language: ");
                    String result1 = textArea.getText();
                    writer.write(result1);
                    writer.flush();
                    writer.newLine();

                    //clear the text area
                    textArea.setText("");

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


                    //write into the file
                    writer.write("Software: ");
                    String result2 = textArea.getText();
                    writer.write(result2);
                    writer.flush();
                    writer.newLine();

                    //clear the text area
                    textArea.setText("");
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

                    //write into the file
                    writer.write("Hardware: ");
                    String result3 = textArea.getText();
                    writer.write(result3);
                    writer.flush();
                    writer.newLine();
                    //clear the text area
                    textArea.setText("");

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

                    //write into the file
                    writer.write("Others: ");
                    String result4 = textArea.getText();
                    writer.write(result4);
                    writer.flush();
                    writer.newLine();
                    //close the writer
                    writer.close();
                    //clear the text area
                    textArea.setText("");

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

                    //write into the file
                    writer.write("Knowledge and Theoretical skills: ");
                    String result5 = textArea.getText();
                    writer.write(result5);
                    writer.flush();
                     writer.newLine();
                    //clear the text area
                    textArea.setText("");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //装填组件
        container.add(textArea);
        container.add(Help);
        container.add(Software);
        container.add(Language);
        container.add(Hardware);
        container.add(Knowledge_and_Theoretical);
        container.add(Others);
        //modify the size of the window
        setSize(600, 300);
        //set the window visible
        setVisible(true);
    }

}
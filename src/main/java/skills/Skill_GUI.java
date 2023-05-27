package skills;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The Skill_GUI class represents a graphical user interface (GUI) for managing skills.
 * It provides options to write, load, and modify skills using a text area and buttons.
 */
public class Skill_GUI extends JFrame{

    private JButton writeButton;
    private JButton loadButton;
    private JButton modifyButton;
    private TextArea textArea;

    private Container container;
    private JPanel jPanel;

    private File targetFile;
    /**
     * Constructs a Skill_GUI object.
     *
     * @throws IOException If an I/O error occurs.
     */
    public Skill_GUI() throws IOException {
        super("My Skills");
        setLocation(300,150);
        setLayout(null);
        jPanel = (JPanel)  this.getContentPane();
        ImageIcon img = new ImageIcon("img1.jpeg");
        JLabel background = new  JLabel(img);
        this.getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        jPanel.setOpaque(false);
        String dir="skills.txt";
        targetFile = new File(dir);
        if(targetFile.createNewFile()) {
            System.out.println("File doesn't exist.Successfully create!");
        }else {
            System.out.println("File exists");
        }
        setResizable(false);
        textArea = new TextArea();
        textArea.setBounds(50,70,750,400);
        writeButton = new JButton("write");
        writeButton.setBounds(375,500,75,30);
        loadButton = new JButton("load");
        loadButton.setBounds(200,500,75,30);
        modifyButton=new JButton("modify");
        modifyButton.setBounds(550,500,75,30);

        writeButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    write_GUI demo = new write_GUI();
                    demo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    FileReader reader = new FileReader(targetFile);
                    char[] buffer = new char[1024];
                    StringBuffer result = new StringBuffer();
                    int len;
                    while((len = reader.read(buffer)) != -1) {
                        result.append(buffer,0,len);
                    }

                    //close the reader
                    reader.close();

                    //update the text area
                    textArea.setText(result.toString());
                    textArea.setFont(new Font("宋体", Font.BOLD,25));
                    System.out.println("Load successful");
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modify_GUI demo = new modify_GUI();
                    demo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //fill the container
        jPanel.add(textArea);
        jPanel.add(loadButton);
        jPanel.add(writeButton);
        jPanel.add(modifyButton);
        //modify the size of the window
        setSize(850, 600);
        //show
        setVisible(true);
    }
    /**
     * The main method that creates an instance of Skill_GUI and sets the default close operation for the GUI.
     *
     * @param args Command-line arguments (unused).
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        Skill_GUI demo = new Skill_GUI();
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


import javax.swing.*;
import java.awt.*;

public class demo_GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My GUI");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns, 10px horizontal and vertical gap
        JButton button1 = new JButton("Button 1");
        button1.setPreferredSize(new Dimension(120, 70)); // set button size
        panel.add(button1);
        JButton button2 = new JButton("Button 2");
        button2.setPreferredSize(new Dimension(120, 70));
        panel.add(button2);
        JButton button3 = new JButton("Button 3");
        button3.setPreferredSize(new Dimension(120, 70));
        panel.add(button3);
        JButton button4 = new JButton("Button 4");
        button4.setPreferredSize(new Dimension(120, 70));
        panel.add(button4);
        JButton button5 = new JButton("Button 5");
        button5.setPreferredSize(new Dimension(120, 70));
        panel.add(button5);
        JButton button6 = new JButton("Button 6");
        button6.setPreferredSize(new Dimension(120, 70));
        panel.add(button6);
        frame.add(panel);
        frame.setVisible(true);
    }
}


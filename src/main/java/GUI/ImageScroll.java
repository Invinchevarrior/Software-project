package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
/**
 * The ImageScroll class represents a JFrame that displays an image with a scrollable panel.
 * The image can be scrolled vertically using the scroll bar.
 */
public class ImageScroll extends JFrame implements AdjustmentListener {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JLabel label;
    private int width = 500;
    private int height = 500;
    private int imageWidth;
    private int imageHeight;
    /**
     * Constructs a new ImageScroll object.
     * This sets up the window, panel, scroll pane, and image display.
     */
    public ImageScroll() {
        setTitle("Module");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        try {
            Image image = ImageIO.read(new File("module1.jpg"));
            imageWidth = image.getWidth(null);
            imageHeight = image.getHeight(null);
            label = new JLabel(new ImageIcon(image));
            panel.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }

        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(width, height));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(this);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
    /**
     * The main method to start the application.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        new ImageScroll();
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        int value = e.getValue();
        int max = scrollPane.getVerticalScrollBar().getMaximum();
        int extent = scrollPane.getVerticalScrollBar().getModel().getExtent();
        int position = max - extent - value;
        label.setBounds(0, position, imageWidth, imageHeight);
    }
}


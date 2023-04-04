package skills;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;


public class write_GUI extends JFrame{

    //组件
    private JButton Language;
    private JButton Software;
    private JButton Hardware;
    private TextArea textArea;
    private JButton Help;
    private JButton Others;
    private JButton Knowledge_and_Theoretical;

    //容器
    private Container container;

    //目标文件
    private File targetFile;

    public write_GUI() throws IOException {
        //设置title
        super("Write your skills");

        //设置流布局
        setLayout(new FlowLayout());

        //获取容器
        container = getContentPane();

        //创建目标文件对象
        String dir="skills.txt";
        targetFile = new File(dir);
        if(targetFile.createNewFile()) {
            System.out.println("文件不存在，创建成功");
        }else {
            System.out.println("文件存在");
        }


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

                    //写入文件
                    writer.write("Language: ");
                    String result1 = textArea.getText();
                    writer.write(result1);
                    writer.flush();
                    writer.newLine();

                    //清空文本显示区内容
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


                    //写入文件
                    writer.write("Software: ");
                    String result2 = textArea.getText();
                    writer.write(result2);
                    writer.flush();
                    writer.newLine();

                    //清空文本显示区内容
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

                    //写入文件
                    writer.write("Hardware: ");
                    String result3 = textArea.getText();
                    writer.write(result3);
                    writer.flush();
                    writer.newLine();
                    //清空文本显示区内容
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

                    //写入文件
                    writer.write("Others: ");
                    String result4 = textArea.getText();
                    writer.write(result4);
                    writer.flush();
                    writer.newLine();
                    //关闭输出流
                    writer.close();
                    //清空文本显示区内容
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

                    //写入文件
                    writer.write("Knowledge and Theoretical skills: ");
                    String result5 = textArea.getText();
                    writer.write(result5);
                    writer.flush();
                     writer.newLine();
                    //清空文本显示区内容
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
        //调整大小
        setSize(600, 300);
        //显示
        setVisible(true);
    }

    /*public static void main(String[] args) throws IOException {


        write_GUI demo = new write_GUI();
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }*/
}
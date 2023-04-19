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


public class Skill_GUI extends JFrame{

    //组件
    private JButton writeButton;
    private JButton loadButton;
    private JButton modifyButton;
    private TextArea textArea;

    //容器
    private Container container;
    private JPanel jPanel;

    //目标文件
    private File targetFile;

    public Skill_GUI() throws IOException {
        //设置title
        super("My Skills");

        //设置流布局
        setLayout(null);

        //获取容器
        jPanel = (JPanel)  this.getContentPane();
        ImageIcon img = new ImageIcon("img1.jpeg"); //添加图片
        JLabel background = new  JLabel(img);
        this.getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        jPanel.setOpaque(false);//把我的面板设置为不可视
        //创建目标文件对象
        String dir="skills.txt";
        targetFile = new File(dir);
        if(targetFile.createNewFile()) {
            System.out.println("文件不存在，创建成功");
        }else {
            System.out.println("文件存在");
        }

        //组件
        textArea = new TextArea();
        textArea.setBounds(50,70,750,400);
        writeButton = new JButton("write");
        writeButton.setBounds(375,500,75,30);
        loadButton = new JButton("load");
        loadButton.setBounds(200,500,75,30);
        modifyButton=new JButton("modify");
        modifyButton.setBounds(550,500,75,30);

        //写入文件按钮点击事件
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

        //读入文件按钮点击事件
        loadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //字符读入流
                    FileReader reader = new FileReader(targetFile);

                    //读入缓冲区
                    char[] buffer = new char[1024];

                    //读入结果
                    StringBuffer result = new StringBuffer();

                    //每次读入缓冲区的长度
                    int len;

                    //从读入流中读取文件内容并形成结果
                    while((len = reader.read(buffer)) != -1) {
                        result.append(buffer,0,len);
                    }

                    //关闭读入流
                    reader.close();

                    //更新文本显示区内容
                    textArea.setText(result.toString());
                    textArea.setFont(new Font("宋体", Font.BOLD,25));
                    System.out.println("读档成功");
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

        //装填组件
        jPanel.add(textArea);
        jPanel.add(loadButton);
        jPanel.add(writeButton);
        jPanel.add(modifyButton);
        //调整大小
        setSize(850, 600);
        //显示
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Skill_GUI demo = new Skill_GUI();
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

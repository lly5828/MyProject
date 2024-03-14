package Camera.startCheck;

import basicClass.MyClass;

import javax.swing.*;
import java.awt.*;

public class Check extends JFrame {
    MyClass myClass;

    public Check(MyClass myClass){
        this.myClass=myClass;
        CheckListener checkListener=new CheckListener(myClass);
        setTitle("考勤");
        setSize(1200,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel classLabel=new JLabel(myClass.getName());
//        classLabel.setBounds(550,20,100,20);
        classLabel.setPreferredSize(new Dimension(90,30));
        add(classLabel);

        JButton button1=new JButton("启动");
        button1.setPreferredSize(new Dimension(90,30));
        button1.addActionListener(checkListener);
        add(button1);
        JButton button2=new JButton("关闭");
        button2.setPreferredSize(new Dimension(90,30));
        button2.addActionListener(checkListener);
        add(button2);



        setVisible(true);
    }
}

package Camera.setStuInfo;


import basicClass.Manager;
import basicClass.Student;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


//次类为教务处人脸信息录入，目前不可用
public class CameraJFrame extends JFrame {


    public void login(Manager manager) {
        CameraListener cameraListener = new CameraListener();
        setTitle("人脸录入");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel panel=new JPanel();
        setContentPane(panel);

        String[] str = {"启动", "关闭", "录入"};
        for (String strs : str) {
            JButton btn = new JButton(strs);
            btn.setPreferredSize(new Dimension(90, 30));
            btn.addActionListener(cameraListener);
            panel.add(btn);
        }


//        setLayout(null);

        JLabel nameLab,sexLab,pNumLab,stuIDLab,classLab;
        JTextField nameText,sexText,pNumText,stuIDText,classText;

        nameLab=new JLabel("姓名");
        nameLab.setBounds(52, 33, 54, 15);
        panel.add(nameLab);
        nameText=new JTextField(12);
        nameText.setBounds(116, 30, 139, 21);
        panel.add(nameText);

        sexLab=new JLabel("性别");
        sexLab.setBounds(52, 73, 54, 15);
        panel.add(sexLab);
        sexText=new JTextField(12);
        sexText.setBounds(116, 70, 139, 21);
        panel.add(sexText);

        pNumLab=new JLabel("电话");
        pNumLab.setBounds(52, 103, 54, 15);
        panel.add(pNumLab);
        pNumText=new JTextField(12);
        pNumText.setBounds(116, 100, 139, 21);
        panel.add(pNumText);

        stuIDLab=new JLabel("学号");
        stuIDLab.setBounds(52, 133, 54, 15);
        panel.add(stuIDLab);
        stuIDText=new JTextField(12);
        stuIDText.setBounds(116, 130, 139, 21);
        panel.add(stuIDText);

        classLab=new JLabel("班级");
        classLab.setBounds(52, 143, 54, 15);
        panel.add(classLab);
        classText=new JTextField(12);
        classText.setBounds(116, 140, 139, 21);
        panel.add(classText);


        cameraListener.setJTextFields(new JTextField[]{nameText,sexText,pNumText,stuIDText,classText});
        cameraListener.setManager(manager);

        setVisible(true);
        cameraListener.setGraphics(getGraphics());
    }

//    public static void main(String[] args) {
//        Manager manager=new Manager();
//        CameraJFrame cameraJFrame = new CameraJFrame(manager);
//
//    }
}


class CameraThreadRunnable implements Runnable {
    boolean flag;
    Webcam webcam;
    private Graphics graphics;

    public CameraThreadRunnable(Webcam webcam, Graphics graphics) {
        this.webcam = webcam;
        this.graphics = graphics;
    }

    public void setCameraOpen() {
        this.flag = true;
    }

    public void setCameraClose() {
        this.flag = false;
    }

    @Override
    public void run() {
        while (flag) {
            BufferedImage bufferedImage = webcam.getImage();
            graphics.drawImage(bufferedImage, 100, 150, null);
        }
    }
}





class CameraListener implements ActionListener {
    Webcam webcam = null;
    private Graphics graphics;
    CameraThreadRunnable cameraThreadRunnable;
    Manager manager;
    JTextField[] jTextFields;

    public void setManager(Manager manager){
        this.manager=manager;
    }

    public void setJTextFields(JTextField[] jTextFields) {
        this.jTextFields = jTextFields;
    }

    public void setWebcam(Webcam webcam) {
        this.webcam = webcam;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String commandName = e.getActionCommand();
        if (commandName.equals("启动")) {
//            flag = true;
            webcam = Webcam.getDefault();
            webcam.open();

            cameraThreadRunnable = new CameraThreadRunnable(webcam, graphics);
            cameraThreadRunnable.setCameraOpen();
            Thread thread = new Thread(cameraThreadRunnable);
            thread.start();
        } else if (commandName.equals("关闭")) {
            webcam.close();
            cameraThreadRunnable.setCameraClose();
        } else if (commandName.equals("录入")) {

            String fileName = "/opt/myProject/photoFromCamera/" + System.currentTimeMillis()+".png";
            WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);




//            BufferedImage image=new BufferedImage(webcam.getImage().getWidth(),webcam.getImage().getHeight(),5);
//            ImageInfo imageInfo=ImageFactory.bufferedImage2ImageInfo(image);


            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Student student;
                    if(jTextFields[1].getText().equals("男")){
                        student=new Student(jTextFields[0].getText(),jTextFields[2].getText(),true,jTextFields[3].getText());
                    }else if(jTextFields[1].getText().equals("女")){
                        student=new Student(jTextFields[0].getText(),jTextFields[2].getText(),false,jTextFields[3].getText());
                    }else {
                        JOptionPane.showMessageDialog(null,"fault sex");
                        return;
                    }






//                    student.setFaceInformation(fileName);
//                    System.out.println(jTextFields[4].getText());
//                    manager.addStudent(jTextFields[4].getText(),student);
//
//                    manager.showStudent("aaa","1");

                }
            });





//            Student student;
//            if(jTextFields[1].getText().equals("男")){
//                student=new Student(jTextFields[0].getText(),jTextFields[2].getText(),true,jTextFields[3].getText());
//            }else if(jTextFields[1].getText().equals("女")){
//                student=new Student(jTextFields[0].getText(),jTextFields[2].getText(),false,jTextFields[3].getText());
//            }else {
//                JOptionPane.showMessageDialog(null,"fault sex");
//                return;
//            }
//            student.setFaceInformation(fileName);
//            manager.addStudent(jTextFields[4].getText(),student);
//
//            manager.showStudent("aaa","1");



        }


    }



}


//package Camera.LogIn;
//
//
//import basicClass.face.FaceInformation;
//import com.arcsoft.face.FaceFeature;
//import com.github.sarxos.webcam.Webcam;
//import com.github.sarxos.webcam.WebcamUtils;
//import com.github.sarxos.webcam.util.ImageUtils;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.util.concurrent.Callable;
//
//public class CameraJFrame extends JFrame {
//    CameraListener cameraListener = new CameraListener();
//
//    public void initUI() {
//        setTitle("人脸录入");
//        setSize(1200, 800);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());
//
//        String[] str = {"启动", "关闭", "拍照"};
//        for (String strs : str) {
//            JButton btn = new JButton(strs);
//            btn.setPreferredSize(new Dimension(90, 30));
//            btn.addActionListener(cameraListener);
//            add(btn);
//        }
//
//        setVisible(true);
//        cameraListener.setGraphics(getGraphics());
//    }
//
//    public static void main(String[] args) {
//        CameraJFrame cameraJFrame = new CameraJFrame();
//        cameraJFrame.initUI();
//    }
//}
//
//
//class CameraThreadRunnable implements Runnable {
//    boolean flag;
//    Webcam webcam;
//    Graphics graphics;
//
//    public CameraThreadRunnable(Webcam webcam, Graphics graphics) {
//        this.webcam = webcam;
//        this.graphics = graphics;
//    }
//
//    public void setCameraOpen() {
//        this.flag = true;
//    }
//
//    public void setCameraClose() {
//        this.flag = false;
//    }
//
//    @Override
//    public void run() {
//        while (flag) {
//            BufferedImage bufferedImage = webcam.getImage();
//            graphics.drawImage(bufferedImage, 100, 150, null);
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//class CameraListener implements ActionListener {
//    Webcam webcam = null;
//    private Graphics graphics;
//    CameraThreadRunnable cameraThreadRunnable;
//
//    public void setWebcam(Webcam webcam) {
//        this.webcam = webcam;
//    }
//
//    public void setGraphics(Graphics graphics) {
//        this.graphics = graphics;
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String commandName = e.getActionCommand();
//        if (commandName.equals("启动")) {
////            flag = true;
//            webcam = Webcam.getDefault();
//            webcam.open();
//
//            cameraThreadRunnable = new CameraThreadRunnable(webcam, graphics);
//            cameraThreadRunnable.setCameraOpen();
//            Thread thread = new Thread(cameraThreadRunnable);
//            thread.start();
//        } else if (commandName.equals("关闭")) {
//            webcam.close();
//            cameraThreadRunnable.setCameraClose();
//        } else if (commandName.equals("拍照")) {
//
//            String fileName = "/opt/myProject/photoFromCamera/" + System.currentTimeMillis();
//            WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
//
//            BufferedImage bufferedImage=webcam.getImage();
//            FaceInformation faceInformation=new FaceInformation(new FaceFeature(WebcamUtils.getImageBytes(webcam,ImageUtils.FORMAT_JPG))) ;
//
//
//
////            提示拍摄完成
////            SwingUtilities.invokeLater(new Runnable() {
////                @Override
////                public void run() {
//////                    录入信息
//////                    SetInfoJFrame setInfoJFrame=new SetInfoJFrame(faceInformation,bufferedImage);
//////                    setInfoJFrame.start(fileName);
////
////                }
////            });
//
//
//        }
//
//
//    }
//
//
//}
//

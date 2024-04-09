package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import basicClass.SchoolTime;
import com.github.sarxos.webcam.Webcam;

import com.github.sarxos.webcam.WebcamPanel;

import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

public class TestWebCam {

    public static void main(String[] args) throws InterruptedException {
//        deletePhoto("/opt/myProject/photoFromCamera/1712561085190.png");
        SchoolTime.getNowSchoolTime().showSchoolTime();
    }
    public static void deletePhoto(String filePath){
        File file = new File(filePath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return ;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                // 路径为文件且不为空则进行删除
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
        }
    }
}


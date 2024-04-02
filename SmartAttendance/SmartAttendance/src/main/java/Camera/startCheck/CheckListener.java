package Camera.startCheck;

import basicClass.MyClass;
import basicClass.SchoolTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckListener implements ActionListener {
    MyClass myClass;
    CheckRunnable checkRunnable;

    public CheckListener(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if(command.equals("启动")){
            checkRunnable=new CheckRunnable(myClass);
            checkRunnable.open();
            Thread t=new Thread(checkRunnable);
            t.start();
        } else if (command.equals("关闭")) {
            checkRunnable.close();
        }
    }
}

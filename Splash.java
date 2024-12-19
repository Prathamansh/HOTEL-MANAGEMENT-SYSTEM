package Hotel.Management.System;

import javax.swing.*;

public class Splash extends JFrame {

    Splash(){
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif")); // we cannot add the gif directly so we take help of Jlable
        JLabel lable = new JLabel(imageicon); // here we use to set the gif, but its work is different, but also it can work in this way.
        lable.setBounds(0,0,1152,648);
        add(lable);

        setLayout(null);
        setLocation(210,95);
        setSize(1152,648);
        setVisible(true);

        try{
            Thread.sleep(7000);
            new Login();
            setVisible(false);
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {

        new Splash();
    }
}

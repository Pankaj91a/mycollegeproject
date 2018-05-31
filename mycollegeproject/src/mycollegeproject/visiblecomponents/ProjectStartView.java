package mycollegeproject.visiblecomponents;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProjectStartView {

    public static void main(String arg[]) {
        try {
            LoginFrame frame = new LoginFrame();
            frame.setTitle("VGC");
            frame.setVisible(true);
            frame.setBounds(10, 10, 810, 510);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

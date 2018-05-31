package mycollegeproject.visiblecomponents;

import mycollegeproject.businesscomponents.StudentPojo;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StudentMenuView extends JFrame implements ActionListener {

    StudentPojo student;
    Container container = getContentPane();

    JLabel pageTitleLabel = new JLabel("Faculty Home page");

    JButton branchesViewButton = new JButton("Show Available Branches");
    JButton examsViewButton = new JButton("Show all Exams Details");

    StudentMenuView(StudentPojo student) {
        this.student = student;
        container.setLayout(null);
        this.setBounds(10, 10, 810, 510);
        pageTitleLabel.setBounds(20, 10, 500, 50);

        branchesViewButton.addActionListener(this);
        examsViewButton.addActionListener(this);

        branchesViewButton.setBounds(75, 100, 250, 30);
        examsViewButton.setBounds(75, 150, 250, 30);

        container.add(pageTitleLabel);
        container.add(branchesViewButton);
        container.add(examsViewButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Show Available Branches")) {
            BranchesInfoView branchesList = new BranchesInfoView("All available Branches");
            branchesList.setVisible(true);
        } else if (e.getActionCommand().equals("Show all Exams Details")) {
            ExamsInfoView testsList = new ExamsInfoView("Show all Exams Details");
            testsList.setVisible(true);
        }
    }
}

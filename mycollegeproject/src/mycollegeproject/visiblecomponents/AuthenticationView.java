package mycollegeproject.visiblecomponents;

import mycollegeproject.businesscomponents.FacultyPojo;
import mycollegeproject.businesscomponents.StudentPojo;
import mycollegeproject.businesscomponents.AdminPojo;
import mycollegeproject.businesscomponents.UserPojo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mycollegeproject.businesscomponents.Manager;

class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitle = new JLabel("Login page");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("New Student ? Register now !");
    Manager manager = new Manager();

    LoginFrame() {
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        container.setLayout(null);
        pageTitle.setBounds(75, 50, 150, 50);

        userLabel.setBounds(50, 150, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);

        passwordLabel.setBounds(50, 220, 100, 30);
        passwordField.setBounds(150, 220, 150, 30);

        loginButton.setBounds(50, 300, 100, 30);
        registerButton.setBounds(50, 350, 400, 30);

        container.add(pageTitle);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(registerButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // login
        if (e.getActionCommand().equals("LOGIN")) {
            String un = userTextField.getText();
            String pw = passwordField.getText();
            System.out.println("User Name : " + un);
            System.out.println("Password : " + pw);
            UserPojo user = manager.getUser(un, pw);
            if (user == null) {
                UnAuthroizedView errorPage = new UnAuthroizedView("No User found with the given credentials.");
                errorPage.setVisible(true);
                //this.setVisible(false);
            } else {
                if (user.isSuperAdmin()) {
                    System.out.println("Logged in as super admin.");
                    AdminMenuView adminPage = new AdminMenuView((AdminPojo) user);
                    adminPage.setVisible(true);
                    this.setVisible(false);
                } else if (user.isFaculty()) {
                    System.out.println("Logged in as faculty.");
                    FacultyMenuView facultyPage = new FacultyMenuView((FacultyPojo) user);
                    facultyPage.setVisible(true);
                    this.setVisible(false);
                } else if (user.isStudent()) {
                    System.out.println("Logged in as student.");
                    StudentMenuView studentPage = new StudentMenuView((StudentPojo) user);
                    studentPage.setVisible(true);
                    this.setVisible(false);
                }
            }
        } // register
        else if (e.getActionCommand().equals("New Student ? Register now !")) {
            RegisterView registrationPage = new RegisterView("Student Registration", "student");
            registrationPage.setVisible(true);
        }
    }
}
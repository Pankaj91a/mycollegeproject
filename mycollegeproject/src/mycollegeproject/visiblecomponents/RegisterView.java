package mycollegeproject.visiblecomponents;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import mycollegeproject.businesscomponents.Manager;

class RegisterView extends JFrame implements ActionListener {

    Manager m = new Manager();
    Container container = getContentPane();
    JLabel pageTitleLabel = null;
    JLabel firstNameLabel = new JLabel("First Name : ");
    JLabel lastNameLabel = new JLabel("Last Name : ");
    JLabel pwLabel = new JLabel("Password : ");

    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton registerButton = new JButton("Register");
    String entityType = null;

    RegisterView(String pageTitle, String entityType) {
        this.entityType = entityType;
        this.setBounds(10, 10, 810, 510);
        registerButton.addActionListener(this);
        container.setLayout(null);
        pageTitleLabel = new JLabel(pageTitle);
        pageTitleLabel.setBounds(75, 50, 150, 50);
        container.add(pageTitleLabel);

        firstNameLabel.setBounds(50, 150, 150, 30);
        firstNameField.setBounds(200, 150, 150, 30);

        lastNameLabel.setBounds(50, 220, 150, 30);
        lastNameField.setBounds(200, 220, 150, 30);

        pwLabel.setBounds(50, 290, 150, 30);
        passwordField.setBounds(200, 290, 150, 30);

        registerButton.setBounds(50, 370, 150, 30);

        container.add(firstNameLabel);
        container.add(firstNameField);
        container.add(lastNameLabel);
        container.add(lastNameField);
        container.add(pwLabel);
        container.add(passwordField);
        container.add(registerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // registration.
        if (e.getActionCommand().equals("Register")) {
            if (entityType.equalsIgnoreCase("student")) {
                m.addStudent(firstNameField.getText(), lastNameField.getText(), passwordField.getText());
            }
            else if (entityType.equalsIgnoreCase("faculty")) {
                m.addFacultY(firstNameField.getText(), lastNameField.getText(), passwordField.getText());
            }
            else if (entityType.equalsIgnoreCase("superAdmin")) {
                m.addSuperAdmin(firstNameField.getText(), lastNameField.getText(), passwordField.getText());
            }
            this.setVisible(false);
        }
    }

}

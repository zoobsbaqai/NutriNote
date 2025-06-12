import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class settingScreen extends JPanel {
    public settingScreen(JFrame frame) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setBounds(50, 50, 300, 30);
        titleLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(titleLabel);

        JButton goalsButton = new JButton("Edit Goals");
        goalsButton.setBounds(50, 120, 250, 40);
        add(goalsButton);

        JButton changePassButton = new JButton("Change Password");
        changePassButton.setBounds(50, 170, 250, 40);
        add(changePassButton);

        JButton editButton = new JButton("Personal Settings");
        editButton.setBounds(50, 220, 250, 40);
        add(editButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 25);
        add(backButton);

        goalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new userGoalScreen(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new HealthInfoScreen(frame, null, null, null));
                frame.revalidate();
                frame.repaint();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new HomeScreen(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        changePassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                forgotPassword.showForgotPasswordDialog(frame);
            }
        });
    }
}

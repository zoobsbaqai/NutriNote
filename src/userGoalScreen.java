import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class userGoalScreen extends JPanel {
    public userGoalScreen(JFrame frame) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Set Your Goals");
        titleLabel.setBounds(50, 50, 300, 30);
        titleLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(titleLabel);

        JLabel goalLabel = new JLabel("Primary Goal:");
        goalLabel.setBounds(50, 100, 150, 25);
        add(goalLabel);

        JComboBox<String> goalCombo = new JComboBox<>(new String[] {
                "General Health", "Lose Weight", "Gain Muscle", "Fat Loss", "Gain Weight"
        });
        goalCombo.setBounds(200, 100, 150, 25);
        add(goalCombo);

        JLabel dietLabel = new JLabel("Dietary Restrictions:");
        dietLabel.setBounds(50, 150, 150, 25);
        add(dietLabel);

        JComboBox<String> dietCombo = new JComboBox<>(new String[] {
                "None", "Vegetarian", "Vegan", "Pescatarian", "Flexitarian"
        });
        dietCombo.setBounds(200, 150, 150, 25);
        add(dietCombo);

        JButton saveButton = new JButton("Save Goals");
        saveButton.setBounds(150, 220, 150, 30);
        add(saveButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 25);
        add(backButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String goal = (String) goalCombo.getSelectedItem();
                String diet = (String) dietCombo.getSelectedItem();
                frame.dispose();
                DietManagerMenu.main(null);

                try (FileWriter writer = new FileWriter("user_goals.txt", true)) {
                    writer.write(goal + "," + diet + "\n");
                    JOptionPane.showMessageDialog(frame, "Goals saved successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving goals.");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new HomeScreen(frame));
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
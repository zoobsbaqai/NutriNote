import javax.swing.*;
import java.awt.*;

public class GoalSet extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Bimsara Code
    public GoalSet() {
        setTitle("NutriNote");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // First screen
        JPanel screen1 = new JPanel(new GridLayout(1, 1, 5, 2));
        JButton startButton = new JButton("Start");
        // Bimsara Code
        screen1.add(startButton);
        // Bimsara Code
        JPanel screen2 = new JPanel(new GridLayout(5, 2, 5, 2));
        JComboBox<String> actionCombo = new JComboBox<>(new String[] {
                    "General Health", "Lose Weight", "Gain Muscle" , "Fat Loss", "Gain Weight"
                });
        JComboBox<String> actionCombo2 = new JComboBox<>(new String[] {
                    "None", "Vegetarian", "Vegan" , "Pescatarian", "Flexitarian", "Halal/Kosher"
                });
        JButton doneButton = new JButton("Done");
        
        screen2.add(new JLabel("Choose a course of action:"));
        screen2.add(actionCombo);
        screen2.add(new JLabel("Which dietary restrictions do you have if any?:"));
        screen2.add(actionCombo2);
        screen2.add(doneButton);

        // Add screens to main panel
        mainPanel.add(screen1, "Screen1");
        mainPanel.add(screen2, "Screen2");

        // Button listeners
        startButton.addActionListener(e -> cardLayout.show(mainPanel, "Screen2"));
        doneButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Thank you! Your entries have been saved!");
                dispose();
                DietManagerMenu.main(null);
            });

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GoalSet::new);
    }
}
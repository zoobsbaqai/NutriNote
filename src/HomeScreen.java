import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// @author Bismah

// Defines the HomeScreen which extends JPanel 
public class HomeScreen extends JPanel {

    // Constructor tfor the homescreen
    public HomeScreen(JFrame frame) {
        // Set the layout manager to null so all the components are posiitoned on our
        // own
        setLayout(null);

        // creates a custom green color for all the elements
        Color green = new Color(75, 163, 97);

        // Creates a title label that welcomes the user to nutrinote
        JLabel title = new JLabel("Welcome to NutriNote!");
        // Sets the position and size of the label
        title.setBounds(66, 50, 300, 150);
        // Sets the font, typeface and size for the title
        title.setFont(new Font("Raleway", Font.PLAIN, 25));
        // Sets the color of the text to the custom green color
        title.setForeground(green);

        // Creates the Login button which will alllow users to log into their account
        JButton login = new JButton("Login");
        // Sets the position and size of the login button
        login.setBounds(95, 220, 200, 30);

        // Adds the action listener for when the login button is clicked
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switches to the login screen
                frame.setContentPane(new LoginScreen(frame));
                // Re-layouts the components
                frame.revalidate();
                // refreshes the screen
                frame.repaint();
            }
        });

        // Creates a button to allow the user to create a new account and register
        JButton newAccount = new JButton("Create an account");
        // Sets the position and size of the create an account button
        newAccount.setBounds(95, 260, 200, 30);

        // Adds an action listener for when the create an account button is clicked
        newAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switches to the register screen
                frame.setContentPane(new RegisterScreen(frame));
                // relayouts the components
                frame.revalidate();
                // refreshes the screen
                frame.repaint();
            }
        });

        JButton settings = new JButton("Settings");
        settings.setBounds(95, 300, 200, 30);

        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new settingScreen(frame));
                frame.revalidate();
                frame.repaint();
            }
        });

        // Adds the welcome title label to the screen
        add(title);
        // Adds the login button to the screen
        add(login);
        // Adds the create account button to the screen
        add(newAccount);
        add(settings);
    }
}

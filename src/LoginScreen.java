import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Defines the LoginScreen class, which is extending the JPanel to act as a screen for the app
public class LoginScreen extends JPanel {
    // Constructor for LoginScreen, it takes a JFrame so it can switch to different
    // screens
    public LoginScreen(JFrame frame) {
        // Set the layout manager to null so all the components are posiitoned on our
        // own
        setLayout(null);
        // Creates a label which asks the user for an email or username
        JLabel userLabel = new JLabel("Email or Username:");
        // Sets the position and size of the userLabel on the screen
        userLabel.setBounds(30, 100, 140, 25);
        // Adds the user label to the current screen
        add(userLabel);

        // Creates a text field for the user to input their email or username
        JTextField userField = new JTextField();
        // sets the size and posiiton of the userFeild
        userField.setBounds(180, 100, 150, 25);
        // Adds the userField to the current screen
        add(userField);

        // Creates a label asking the user for their password
        JLabel passLabel = new JLabel("Password:");
        // Sets the posoiton and size of the password label
        passLabel.setBounds(30, 140, 100, 25);
        // Adds the password field to the screen
        add(passLabel);

        // Creates a password field for inputtinf the password
        JPasswordField passField = new JPasswordField();
        // Sets the size and position of the password field
        passField.setBounds(180, 140, 150, 25);
        // Adds the password field to the screen
        add(passField);

        // CCreates a checbox to allow the user to toggle the password visibility
        JCheckBox showPass = new JCheckBox("Show Password");
        // Sets the position and size of the showPass checkbox
        showPass.setBounds(180, 170, 150, 25);
        // adds the checkbox to the screen
        add(showPass);
        // adds action lisgener tot the checkbox to toggle the password visibility
        showPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If the checkbox is selected it shows the characters otherwise it is masked
                // with "•"
                passField.setEchoChar(showPass.isSelected() ? (char) 0 : '•');
            }
        });

        // CReates the login button
        JButton login = new JButton("Login");
        // Sets the size and positon of the login button
        login.setBounds(150, 200, 100, 30);
        // Adds login button to the screen
        add(login);

        // Adds an action listener tfor when the login button is clicked
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Gets the user onput from the username/email field
                String userInput = userField.getText().trim();
                // Gets the password input from the password field
                String password = new String(passField.getPassword()).trim();

                // Trys to open and read from user.txt file
                try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
                    // Initialize variable to store whetert the login was successful or not
                    String line;
                    boolean match = false;

                    // Read each line in the users.txt file
                    while ((line = reader.readLine()) != null) {
                        // SPlits the line by commas
                        String[] parts = line.split(",");
                        // Ensures the line has atleats 3 parts
                        if (parts.length >= 3) {
                            String username = parts[0]; // Gets the user name
                            String email = parts[1]; // Gets the email
                            String pass = parts[2]; // Extract password

                            // CHecks if the input matchees either username or email and the password
                            if ((userInput.equalsIgnoreCase(username) || userInput.equalsIgnoreCase(email))
                                    && password.equals(pass)) {
                                // If a match is found, set match to true and breaks the loop
                                match = true;
                                break;
                            }
                        }
                    }
                    // after checking all the lines in the file, it then does rhe folllowing based
                    // on the result
                    if (match) {
                        // Shows this message if the credentials match
                        JOptionPane.showMessageDialog(frame, "Login successful.");
                        // Bimsara Code : transfers to userGoal page, where user can customize their
                        // meal plan
                        frame.setContentPane(new userGoalScreen(frame));
                        frame.revalidate();
                        frame.repaint();

                    } else {
                        // SHows this message if the credentials dont match any user
                        JOptionPane.showMessageDialog(frame, "Incorrect email/username or password.");
                    }
                } catch (IOException ex) {
                    // catches error if the file cant be read
                    JOptionPane.showMessageDialog(frame, "Error reading user file.");
                }
            }
        });

        // createa a forgot password button
        JButton forgotPass = new JButton("Forgot Password?");
        // sets its size and position
        forgotPass.setBounds(95, 240, 230, 25);
        // Adds the button to the screen
        add(forgotPass);

        forgotPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                forgotPassword.showForgotPasswordDialog(frame);
            }
        });

        // creates a back button to go to the homescreen
        JButton back = new JButton("Back");
        // sets it position and the size on the screen
        back.setBounds(10, 10, 80, 25);
        // adds the button to the screen
        add(back);
        // action listener so then when the button is clicked it goes back to the home
        // screen
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // replaces the current screen to the homscreen
                frame.setContentPane(new HomeScreen(frame));
                // revalidates the screen to apply the new layout
                frame.revalidate();
                // repaints the screen
                frame.repaint();
            }
        });
    }
}

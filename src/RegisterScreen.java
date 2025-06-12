import javax.swing.*;
import java.awt.event.*;
import java.io.*;

// @author Bismah

public class RegisterScreen extends JPanel {

    // Constructor that sets up the registration screen
    public RegisterScreen(JFrame frame) {
        /// Set the layout manager to null so all the components are posiitoned on our
        // own
        setLayout(null);

        // Label for the user's name
        JLabel nameLabel = new JLabel("Name:");
        // Sets the size and position
        nameLabel.setBounds(50, 60, 100, 25);
        // adds the label to the screen
        add(nameLabel);

        // Sets a text field for the user to enter their name
        JTextField nameField = new JTextField();
        // Sets the size and position
        nameField.setBounds(150, 60, 150, 25);
        // adds the field to the sceen
        add(nameField);

        // Creates a label for the users email
        JLabel emailLabel = new JLabel("Email:");
        // sets the position and size
        emailLabel.setBounds(50, 100, 100, 25);
        // adds the label to the screen
        add(emailLabel);

        // Creates a text field for the user to enter there email
        JTextField emailField = new JTextField();
        // Sets the position and size of the field
        emailField.setBounds(150, 100, 150, 25);
        // adds the field to the screen
        add(emailField);

        // Label for the password
        JLabel passLabel = new JLabel("Password:");
        // sets the position and size on the screen
        passLabel.setBounds(50, 140, 100, 25);
        // adds the label to the screen
        add(passLabel);

        // Creates a password field so the user can add the password
        JPasswordField passField = new JPasswordField();
        // sets the position and size on the screen
        passField.setBounds(150, 140, 150, 25);
        // adds the field to the screen
        add(passField);

        // Adds a checbox so the user can show/hide their password
        JCheckBox showPass = new JCheckBox("Show Password");
        // sets the positon and size on the screen
        showPass.setBounds(150, 170, 150, 25);
        // adds the checkbox to the screen
        add(showPass);

        // Action listener for the toggle for the visibility of the password characters
        showPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If it is selected, it show plain text; otherwise its the bullet character
                passField.setEchoChar(showPass.isSelected() ? (char) 0 : '•');
            }
        });

        // Adds a button to proceed next
        JButton next = new JButton("Next");
        // sets the position and size on the screen
        next.setBounds(150, 210, 100, 30);
        // adds the button to the screen
        add(next);

        // Action listener tfor when then the next button is clicked
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Trims the text if there is any unnecary spaces
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = new String(passField.getPassword()).trim();

                // checks if no field was left empty
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required.");
                    return; // otherwise stop processing if the validation fails
                }

                // Checks if the email is already registered by reading from the file
                try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        // compares against other emails
                        if (parts[0].equalsIgnoreCase(email)) {
                            JOptionPane.showMessageDialog(frame, "Email already registered.");
                            return; // Stops if a duplicate found
                        }
                    }
                } catch (IOException ex) {
                    // the exception is ignored
                }

                // If the validation passes and email is not in use, moves to the next screen
                frame.setContentPane(new HealthInfoScreen(frame, name, email, password));
                frame.revalidate(); // Refreshs the layout
                frame.repaint(); // Redraws the screen
            }
        });

        // Creates a button that lets the user return to the home screen
        JButton back = new JButton("Back");
        // sets the position and size on the screen
        back.setBounds(10, 10, 80, 25);
        // adds rhe back button to the screen
        add(back);

        // Action listener for when the backbutton is clicked
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new HomeScreen(frame)); // switches to the homescreen
                frame.revalidate(); // refreshes the layout
                frame.repaint(); // redraws the screen
            }
        });
    }
}

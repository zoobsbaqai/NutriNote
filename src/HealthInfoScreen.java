import javax.swing.*;
import java.awt.event.*;
import java.io.*;

// @author Bismah

public class HealthInfoScreen extends JPanel {

    // Constructor for HealthInfoScreen that takes the main screen ad all the user
    // info
    public HealthInfoScreen(JFrame frame, String email, String password, String name) {

        setLayout(null);

        // Sets a label to ask the user for age
        JLabel ageLabel = new JLabel("Age:");
        // Sets and position and size on the screen
        ageLabel.setBounds(50, 80, 100, 30);
        // Adds the label to the screen
        add(ageLabel);

        // Creates a text field for user to enter their age
        JTextField ageField = new JTextField();
        // Sets position and size on the screen
        ageField.setBounds(150, 80, 150, 30);
        // Adds the age field to the screen
        add(ageField);

        // Sets the label for the gender selection
        JLabel genderLabel = new JLabel("Gender:");
        // sets position and size on the screen
        genderLabel.setBounds(50, 130, 100, 30);
        // adds the gender field to the screen
        add(genderLabel);

        // Define gender options
        String[] genders = { "Male", "Female", "Other" };

        // Creates a dropdown menu for gender selection
        JComboBox<String> genderBox = new JComboBox<>(genders);
        // sets the position and size on the screen
        genderBox.setBounds(150, 130, 150, 30);
        // adds the drop down menu onto the screen
        add(genderBox);

        // sets the label for the weight
        JLabel weightLabel = new JLabel("Weight (lb):");
        // sets the position and size on the screen
        weightLabel.setBounds(50, 180, 100, 30);
        // adds the weight label to the screen
        add(weightLabel);

        // Sets the text field for the weight
        JTextField weightField = new JTextField();
        // sets the position and size on the screen
        weightField.setBounds(150, 180, 150, 30);
        // adds the weight field on the screen
        add(weightField);

        // Sets the height label
        JLabel heightLabel = new JLabel("Height (ft):");
        // sets the position and size of the height label
        heightLabel.setBounds(50, 230, 100, 30);
        // adds the height label to the screen
        add(heightLabel);

        // Text field for height input
        JTextField heightField = new JTextField();
        // sets the position and size of the height field
        heightField.setBounds(150, 230, 150, 30);
        // adds the height field to the screen
        add(heightField);

        // Sets the button to submit
        JButton submit = new JButton("Submit");
        // sets the positon and size on the screen
        submit.setBounds(150, 280, 100, 30);
        // adds the submit button to the screen
        add(submit);

        // Sets the button to go back to the register screen
        JButton backButton = new JButton("Back");
        // Sets the position and the size on the screen
        backButton.setBounds(50, 280, 80, 30);
        // adds the back button to the screen
        add(backButton);

        // Adds an action listener for whent eh submit button is clicked
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Trims the values if there is any unnesscary space
                String age = ageField.getText().trim(); // user enters their age
                String gender = (String) genderBox.getSelectedItem(); // user selects there gender
                String weight = weightField.getText().trim(); // user enters their weight
                String height = heightField.getText().trim(); // user enters their height

                // Checks if any of the text fields are empty
                if (age.isEmpty() || weight.isEmpty() || height.isEmpty()) {
                    // Shows an error message if any are empty
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                    return; // Exits the method
                }

                // Saves the data to the user.txt file
                try (FileWriter writer = new FileWriter("users.txt", true)) {
                    // Creates new line in the users.txt file with all the collected data
                    writer.write(email + "," + password + "," + name + "," +
                            age + "," + gender + "," + weight + "," + height + "\n");

                    // Shows a message that the account was created successfully
                    JOptionPane.showMessageDialog(frame, "Account created successfully!");

                    // Go back to the home screen
                    frame.setContentPane(new HomeScreen(frame));
                    frame.revalidate(); // Re-layout components
                    frame.repaint(); // Refreshes the screen

                } catch (IOException ex) {
                    // If saving it to the file fales, error message is shown
                    JOptionPane.showMessageDialog(frame, "Failed to save account.");
                }
            }
        });

        // Action listener for when the backbutton is clicked
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Goes back to the Register screen
                frame.setContentPane(new HomeScreen(frame));
                frame.revalidate(); // Revalidates the screen
                frame.repaint(); // Redraws the screen
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;

// @author Bismah

public class MainApp {

    public static void main(String[] args) {

        // Tried setting the "nimbus style" look for the app
        // Reference:
        // https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html
        try {
            // Loops through all installed look and feels in the code
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                // Checks if the current look and feel is named "Nimbus"
                if ("Nimbus".equals(info.getName())) {
                    // Sets the UI to use Nimbus look and feel
                    UIManager.setLookAndFeel(info.getClassName());
                    // Break the loop once Nimbus is set
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available or there's an error, it continues with the deafult
            // style

        }

        // used this for help
        // https://docs.oracle.com/javase/8/docs/api/javax/swing/UIManager.html

        // Sets the default font and style for all the JButton components
        UIManager.put("Button.font", new Font("Raleway", Font.BOLD, 14));
        // Sets the background color of buttons to a green shade
        UIManager.put("Button.background", new Color(75, 163, 97));
        // Sets the text color on buttons to white
        UIManager.put("Button.foreground", Color.WHITE);

        // Sets the default font for labels
        UIManager.put("Label.font", new Font("Raleway", Font.PLAIN, 15));
        // Sets the font style for text fields
        UIManager.put("TextField.font", new Font("Raleway", Font.PLAIN, 13));
        // Sets the font style for password fields
        UIManager.put("PasswordField.font", new Font("Raleway", Font.PLAIN, 13));

        // Sets the default background color of all panels to white
        UIManager.put("Panel.background", Color.WHITE);

        // Creates a new frame called "Nutri Note"
        JFrame frame = new JFrame("NutriNote");
        // Sets the default close operation to exit the app whent the screen is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sest the size of the screen
        frame.setSize(400, 600);

        // Sets the main content of the screen to the HomeScreen screen
        frame.setContentPane(new HomeScreen(frame));
        // Centers the app on the screen
        frame.setLocationRelativeTo(null);
        // Makes the app visible to the user
        frame.setVisible(true);
    }
}

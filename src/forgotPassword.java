import javax.swing.*;
import java.awt.*;
import java.io.*;

//@author Bismah

public class forgotPassword {
    public static void showForgotPasswordDialog(JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField emailInput = new JTextField();
        JPasswordField newPass = new JPasswordField();
        JPasswordField confirmPass = new JPasswordField();
        JCheckBox showReset = new JCheckBox("Show Passwords");

        panel.add(new JLabel("Email:"));
        panel.add(emailInput);
        panel.add(new JLabel("New Password:"));
        panel.add(newPass);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPass);
        panel.add(new JLabel(""));
        panel.add(showReset);

        showReset.addActionListener(e -> {
            char c = showReset.isSelected() ? (char) 0 : '•';
            newPass.setEchoChar(c);
            confirmPass.setEchoChar(c);
        });

        int result = JOptionPane.showConfirmDialog(frame, panel, "Reset Password", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String email = emailInput.getText().trim();
            String npass = new String(newPass.getPassword());
            String cpass = new String(confirmPass.getPassword());

            if (!npass.equals(cpass)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match.");
                return;
            }

            File temp = new File("users_temp.txt");
            File orig = new File("users.txt");
            boolean updated = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(orig));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 3 && parts[1].equalsIgnoreCase(email)) {
                        writer.write(parts[0] + "," + parts[1] + "," + npass + "\n");
                        updated = true;
                    } else {
                        writer.write(line + "\n");
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error updating password.");
                return;
            }

            if (updated) {
                orig.delete();
                temp.renameTo(orig);
                JOptionPane.showMessageDialog(frame, "Password updated.");
            } else {
                temp.delete();
                JOptionPane.showMessageDialog(frame, "Email not found.");
            }
        }
    }
}

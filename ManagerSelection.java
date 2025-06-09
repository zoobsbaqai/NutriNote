import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

// Zohair
class ManagerSelection extends JFrame {

    // Main method to set up the main menu interface
    public static void main(String[] args) {
        JFrame frame = new JFrame("NutriNote");
        frame.setSize(400, 700);
        frame.setLayout(null);

        JButton exit = new JButton("Exit");
        exit.setBounds(175, 575, 50, 15);

        JButton dietTab = new JButton("DIET MANAGER");
        dietTab.setBounds(20, 180, 360, 120);
        dietTab.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton exerTab = new JButton("EXERCISE MANAGER");
        exerTab.setBounds(20, 375, 360, 120);
        exerTab.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JLabel title = new JLabel("NutriNote");
        title.setBounds(80, 25, 720, 75);
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 52));

        //Adding all of the objects to the frame
        frame.add(title);
        frame.add(exerTab);
        frame.add(exit);
        frame.add(dietTab);
       
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dietTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DietManagerMenu.show(frame);
                frame.setVisible(false);
            }
        });

        exerTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExcerciseManagerMenu.show(frame);
                frame.setVisible(false);
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });
    }
}
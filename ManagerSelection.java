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

        JButton exit = new JButton("close");
        exit.setBounds(175, 575, 50, 15);

        JButton play = new JButton("DIET MANAGER");
        play.setBounds(20, 180, 360, 120);
        play.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton helpTab = new JButton("EXERCISE MANAGER");
        helpTab.setBounds(20, 375, 360, 120);
        helpTab.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JLabel title = new JLabel("NutriNote");
        title.setBounds(90, 25, 720, 75);
        title.setFont(new Font("Serif", Font.PLAIN, 52));

        //Adding all of the objects to the frame
        frame.add(title);
        frame.add(helpTab);
        frame.add(exit);
        frame.add(play);
       
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });
    }
}
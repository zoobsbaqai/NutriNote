import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class DietManagerMenu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Diet Manager");
        frame.setSize(400, 700);
        frame.setLayout(null);

        JButton exit = new JButton("close");
        exit.setBounds(175, 575, 50, 15);

        JLabel title = new JLabel("Diet Manager");
        title.setBounds(90, 25, 720, 75);
        title.setFont(new Font("Serif", Font.PLAIN, 45));
        
        frame.add(title);
        frame.add(exit);
    }
}

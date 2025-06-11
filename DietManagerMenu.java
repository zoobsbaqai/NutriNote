import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class DietManagerMenu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("NutriNote");
        frame.setSize(400, 700);
        frame.setLayout(null);

        JButton dietEntry = new JButton("Post Entry");
        dietEntry.setBounds(20, 120, 360, 120);
        dietEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton seeLog = new JButton("View Food Log");
        seeLog.setBounds(20, 265, 360, 120);
        seeLog.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton getRec = new JButton("Meal Recommendations");
        getRec.setBounds(20, 415, 360, 120);
        getRec.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton exit = new JButton("exit");
        exit.setBounds(175, 575, 50, 15);

        JLabel title = new JLabel("NutriNote");
        title.setBounds(80, 25, 720, 75);
        title.setFont(new Font("Serif", Font.PLAIN, 45));
        
        frame.add(title);
        frame.add(exit);
        frame.add(getRec);
        frame.add(seeLog);
        frame.add(dietEntry);

        seeLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DietLogPane.main(null);
            }
        });

        getRec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DietRecPane.main(null);
            }
        });

        dietEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DietPost.show(frame);
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

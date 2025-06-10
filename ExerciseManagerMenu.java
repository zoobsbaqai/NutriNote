import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ExerciseManagerMenu {

    public static void show(JFrame previousFrame){
        JFrame frame = new JFrame("Exercise Manager");
        frame.setSize(400, 700);
        frame.setLayout(null);

        JButton back = new JButton("Back");
        back.setBounds(175, 575, 50, 15);

        JLabel title = new JLabel("Exercise Manager");
        title.setBounds(32, 25, 720, 85);
        title.setFont(new Font("Serif", Font.PLAIN, 45));

        JButton exerEntry = new JButton("Post Entry");
        exerEntry.setBounds(20, 120, 360, 120);
        exerEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton seeELog = new JButton("View Exercise Log");
        seeELog.setBounds(20, 265, 360, 120);
        seeELog.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton getERec = new JButton("Exercise Library");
        getERec.setBounds(20, 415, 360, 120);
        getERec.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        frame.add(title);
        frame.add(back);
        frame.add(seeELog);
        frame.add(getERec);
        frame.add(exerEntry);

        seeELog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExerciseLogPane.main(null);
            }
        });

        getERec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExerRecPane.main(null);
            }
        });

        exerEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExercisePost.main(null);
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // close current window
                previousFrame.setVisible(true); // show previous frame
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

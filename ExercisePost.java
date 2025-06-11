import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ExercisePost {
    public static void show(JFrame previousFrame) {
        JFrame frame = new JFrame("Exercise Entry Post");
        frame.setSize(350, 300);
        frame.setLayout(null);

        JButton back = new JButton("Back");
        back.setBounds(270, 235, 65, 20);

        JButton submit = new JButton("Post");
        submit.setBounds(150, 235, 75, 25);

        JLabel title = new JLabel("Exercise Entry Post");
        title.setBounds(30, 8, 720, 40);
        title.setFont(new Font("Serif", Font.PLAIN, 35));


        final JTextField textName = new JTextField();
        textName.setBounds(10, 80, 150, 20);

        final JTextField textTarget = new JTextField();
        textTarget.setBounds(10, 130, 50, 20);

        final JTextField textSet = new JTextField();
        textSet.setBounds(10, 180, 50, 20);

        final JTextField textRep = new JTextField();
        textSet.setBounds(10, 230, 50, 20);


        JLabel exerName;
        exerName = new JLabel("What workout did you complete?:");
        exerName.setBounds(15, 60, 160, 20);
        
        JLabel exerTarget;
        exerTarget = new JLabel("Which muscle group?:");
        exerTarget.setBounds(15, 110, 150, 20);

        JLabel exerSets;
        exerSets = new JLabel("How many sets?:");
        exerSets.setBounds(15, 160, 150, 20);

        JLabel exerRep;
        exerRep = new JLabel("How many repititions?:");
        exerRep.setBounds(15, 210, 150, 20);


        frame.add(title);
        frame.add(exerName);
        frame.add(exerRep);
        frame.add(exerSets);
        frame.add(exerTarget);
        frame.add(textName);
        frame.add(textRep);
        frame.add(textSet);
        frame.add(textTarget);
        frame.add(back);
        frame.add(submit);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // close current window
                previousFrame.setVisible(true); // show previous frame
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class DietPost {
    public static void show(JFrame previousFrame) {
        JFrame frame = new JFrame("Diet Entry Post");
        frame.setSize(350, 300);
        frame.setLayout(null);

        JButton back = new JButton("Back");
        back.setBounds(270, 235, 65, 20);

        JButton submit = new JButton("Post");
        submit.setBounds(150, 235, 75, 25);

        JLabel title = new JLabel("Diet Entry Post");
        title.setBounds(30, 8, 720, 40);
        title.setFont(new Font("Serif", Font.PLAIN, 35));


        final JTextField foodName = new JTextField();
        foodName.setBounds(10, 80, 150, 20);

        final JTextField foodCal = new JTextField();
        foodCal.setBounds(10, 130, 50, 20);

        final JTextField foodCarb = new JTextField();
        foodCarb.setBounds(10, 180, 50, 20);

        final JTextField foodProt = new JTextField();
        foodProt.setBounds(10, 230, 50, 20);


        JLabel entName;
        entName = new JLabel("What did you eat?:");
        entName.setBounds(15, 60, 160, 20);
        
        JLabel entCal;
        entCal = new JLabel("Calories:");
        entCal.setBounds(15, 110, 150, 20);

        JLabel entCarb;
        entCarb = new JLabel("Carbohydrates:");
        entCarb.setBounds(15, 160, 150, 20);

        JLabel entProt;
        entProt = new JLabel("Protein:");
        entProt.setBounds(15, 210, 150, 20);


        frame.add(title);
        frame.add(entCal);
        frame.add(entProt);
        frame.add(entCarb);
        frame.add(entName);
        frame.add(foodName);
        frame.add(foodCarb);
        frame.add(foodCal);
        frame.add(foodProt);
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

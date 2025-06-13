import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//zohair
public class DietPost {

    //this method takes in the user inputs for each section and writes it into the food log text file
    public static void updateFoodLog(String foodName, int foodCal, int foodCarb, int foodProt){
        String filePath = "FoodLog";
        List<String> foodLog = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                foodLog.add(line);
            }
        } catch (IOException e) {
        }

        foodLog.add(foodName + ". Calories: " + foodCal + "g. Carbs: " + foodCarb + "g. Protein: " + foodProt + "g.");
    
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String entry : foodLog) {
                writer.write(entry + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //this method is called when the reset button is pressed, it clears the food log txt file
    public static void resetLog(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //main method sets frame and records actions
    public static void show(JFrame previousFrame) {
        JFrame frame = new JFrame("Diet Entry Post");
        frame.setSize(350, 300);
        frame.setLayout(null);

        JButton back = new JButton("Back");
        back.setBounds(270, 235, 65, 20);

        JButton submit = new JButton("Post");
        submit.setBounds(150, 235, 75, 25);

        JButton reset = new JButton("Reset Food Log");
        reset.setBounds(200, 75, 125, 25);

        JLabel title = new JLabel("Diet Entry Post");
        title.setBounds(30, 8, 720, 40);
        title.setFont(new Font("Serif", Font.PLAIN, 35));


        final JTextField foodName = new JTextField();
        foodName.setBounds(17, 75, 150, 25);

        final JTextField foodCal = new JTextField();
        foodCal.setBounds(17, 125, 50, 25);

        final JTextField foodCarb = new JTextField();
        foodCarb.setBounds(17, 175, 50, 25);

        final JTextField foodProt = new JTextField();
        foodProt.setBounds(17, 225, 50, 25);


        JLabel entName;
        entName = new JLabel("What did you eat?:");
        entName.setBounds(15, 55, 160, 20);
        
        JLabel entCal;
        entCal = new JLabel("Calories:");
        entCal.setBounds(15, 105, 150, 20);

        JLabel entCarb;
        entCarb = new JLabel("Carbohydrates:");
        entCarb.setBounds(15, 155, 150, 20);

        JLabel entProt;
        entProt = new JLabel("Protein:");
        entProt.setBounds(15, 205, 150, 20);

        //add all buttons, fields and text to the main frame body
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
        frame.add(reset);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFoodLog(foodName.getText(), Integer.parseInt(foodCal.getText()), Integer.parseInt(foodCarb.getText()), Integer.parseInt(foodProt.getText()));
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                resetLog("FoodLog");
            }
        });

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

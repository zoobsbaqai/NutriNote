import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//zohair
public class DietLogPane {

    //the main calls the methods
    public static void main(String[] args) {
        List<String> foodItems = readFoodItemsFromFile("FoodLog");
        displayFoodItemsInMessageBox(foodItems);
    }

    //this method gets all the items in the food log
    private static List<String> readFoodItemsFromFile(String fileName) {
        List<String> foodItems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                foodItems.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodItems;
    }

    //this method prints the food items onto the pane for the user to read
    private static void displayFoodItemsInMessageBox(List<String> foodItems) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < foodItems.size(); i++) {
            sb.append((i + 1) + ". ").append(foodItems.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Food Log", JOptionPane.INFORMATION_MESSAGE);
    }
}

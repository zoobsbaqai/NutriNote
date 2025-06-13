import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;
import javax.swing.*;
import java.awt.*;

//zohair

public class DietRec {

    //importing openAI API
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void show(JFrame previousFrame) {

        //get the user goal and dietary restriction for ai prompt
        String goal = userGoalScreen.getUserGoal();
        String diet = userGoalScreen.getUserDiet();

        //this is the prompt that is sent to openAI everytime the user selects meal recommendations
        try {
            String prompt = "For someone who has a '" + diet + "' restriction and wants to '" + goal + "', create a list of 10 meals including the ingredients, calories, protein, and carbohydrates. Just send the list and nothing else.";            //setting the model of ai to use
            String payload = "{\n" +
                    "  \"model\": \"gpt-3.5-turbo\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + prompt + "\"}\n" +
                    "  ]\n" +
                    "}";
    
            String jsonResponse = sendPostRequest(API_URL, payload);
    
            //formats openAi response into a more readable message
            JSONObject obj = new JSONObject(jsonResponse);
            JSONArray choices = obj.getJSONArray("choices");
            JSONObject message = choices.getJSONObject(0).getJSONObject("message");
            String content = message.getString("content");
    
            //nicer UI to allow user to read the information more better in a box
            JTextArea textArea = new JTextArea(content);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 400));
    
            //initializing pane to display all recommendations
            JOptionPane.showMessageDialog(null, scrollPane, "Meal Recommendation", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            //displays an error message if encountered
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    //this method allows for information to be sent to openAI api
    private static String sendPostRequest(String apiUrl, String payload) throws Exception {
        URL url = new URL(apiUrl);
        //connect to website
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        //allows api to take input from code
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setRequestProperty("Content-Type", "application/json");

        // send data to openAI
        try (OutputStream os = connection.getOutputStream()) {
            os.write(payload.getBytes("UTF-8"));
            os.flush();
        }

        // get ai status
        int status = connection.getResponseCode();
        Scanner scanner = (status >= 200 && status < 300)
                ? new Scanner(connection.getInputStream())
                : new Scanner(connection.getErrorStream());

        //read response, if error, send error message else if its normal then send the ai response
        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        
        //print error code
        if (status != 200) {
            System.err.println("HTTP Error Code: " + status);
        }

        //return ai response
        return response.toString();
    }
}
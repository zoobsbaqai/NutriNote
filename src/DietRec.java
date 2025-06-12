import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;

import javax.swing.*;
import java.awt.*;

public class DietRec {
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void show(JFrame previousFrame) {
        try {
            String prompt = "For someone who has a 'vegetarian' restriction and wants to 'lose weight', create a list of 10 meals including the ingredients, calories, protein, and carbohydrates. Just send the list and nothing else.";
            String payload = "{\n" +
                    "  \"model\": \"gpt-3.5-turbo\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + prompt + "\"}\n" +
                    "  ]\n" +
                    "}";
    
            String jsonResponse = sendPostRequest(API_URL, payload);
    
            // Parse the JSON and extract the assistant message content
            JSONObject obj = new JSONObject(jsonResponse);
            JSONArray choices = obj.getJSONArray("choices");
            JSONObject message = choices.getJSONObject(0).getJSONObject("message");
            String content = message.getString("content");
    
            // Display just the assistant response
            JTextArea textArea = new JTextArea(content);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 400));
    
            JOptionPane.showMessageDialog(null, scrollPane, "Meal Plan", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static String sendPostRequest(String apiUrl, String payload) throws Exception {
        URL url = new URL(apiUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setRequestProperty("Content-Type", "application/json");

        // Send the JSON body
        try (OutputStream os = connection.getOutputStream()) {
            os.write(payload.getBytes("UTF-8"));
            os.flush();
        }

        // Handle both success and error responses
        int status = connection.getResponseCode();
        Scanner scanner = (status >= 200 && status < 300)
                ? new Scanner(connection.getInputStream())
                : new Scanner(connection.getErrorStream());

        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        if (status != 200) {
            System.err.println("HTTP Error Code: " + status);
        }

        return response.toString();
    }

    public static void OpenAIAPI(String restriction, String goal){

    }
}
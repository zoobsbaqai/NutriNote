import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class DietRec {
    private static final String API_KEY = "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"; // Keep this secure
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void show(JFrame previousFrame) {
    }

    public static void OpenAIAPI(String restriction, String goal){
        try {
            String prompt = "For someone who has a " + restriction + " restriction and wants to " + goal + ", create a list of 10 meals including the ingredients, calories, protein, and carbohydrates. Just send the list and nothing else.";
            String payload = "{\n" +
                    "  \"model\": \"gpt-3.5-turbo\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + prompt + "\"}\n" +
                    "  ]\n" +
                    "}";

            String response = sendPostRequest(API_URL, payload);
            JOptionPane.showMessageDialog(null, "Response:\n" + response);
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
}
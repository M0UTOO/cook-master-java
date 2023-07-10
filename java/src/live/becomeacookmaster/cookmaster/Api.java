package live.becomeacookmaster.cookmaster;

import java.io.*;
import java.net.*;

public class Api {
    

    public String getApiInfo(String endpoint, String method) {
        try {
            // Create URL object with the API endpoint
            URL url = new URL("https://api.becomeacookmaster.live:9000/" + endpoint);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json");

            // Set the token
            File file = new File();
            String token = file.readFromInputStream(new FileInputStream("target/classes/token.yml"));
            connection.setRequestProperty("Token", token.substring(0, token.length() - 1));

            BufferedReader reader = null;

            // Read the response from the API
            try{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (Exception e) {
                //e.printStackTrace();
            }
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Close the connection
            connection.disconnect();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String loginManager(String email, String password) {
        try {
            // Create URL object with the API endpoint
            URL url = new URL("https://api.becomeacookmaster.live:9000/user/login");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "*/*");

            // Set the token
            File file = new File();
            String token = file.readFromInputStream(new FileInputStream("target/classes/token.yml"));
            connection.setRequestProperty("Token", token.substring(0, token.length() - 1));

            connection.setDoOutput(true);
            String jsonInputString = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}";
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);			
            }

            // Read the response from the API
            try(BufferedReader br = new BufferedReader(
            new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                connection.disconnect();
                return response.toString();
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }

        return null;
    }

    public String getPassword(String email) {
        try {
            // Create URL object with the API endpoint
            URL url = new URL("https://api.becomeacookmaster.live:9000/user/password");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "*/*");

            // Set the token
            File file = new File();
            String token = file.readFromInputStream(new FileInputStream("target/classes/token.yml"));
            connection.setRequestProperty("Token", token.substring(0, token.length() - 1));

            connection.setDoOutput(true);
            String jsonInputString = "{\"email\": \"" + email + "\"}";
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);			
            }

            // Read the response from the API
            try(BufferedReader br = new BufferedReader(
            new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                connection.disconnect();
                return response.toString();
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return null;
    }
}



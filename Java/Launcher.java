package Java;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Launcher {

    public static void main(String[] args) 
    {
        // Définissez le frame
        JFrame frame = new JFrame("Hello World");

        JLabel label = new JLabel("Je suis un JLabel", JLabel.CENTER);
        frame.add(label);
    
        // Définissez le panel
        JPanel panel = new JPanel();
        // Définir les boutons
        JButton btn1 = new JButton("Bouton 1");
        JButton btn2 = new JButton("Bouton 2");      
        // Ajouter les boutons au frame
        panel.add(btn1); 
        panel.add(btn2);
        
        // Ajouter label et panel au frame
        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);
        
        frame.pack();
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
        // Create URL object with the API endpoint
        URL url = new URL("http://localhost:9000/");

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Print the response
        System.out.println(response.toString());

        // Close the connection
        connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package cookmaster;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPage {

    final static Color TITLE_COLOR = new Color(77, 71, 167);
    final static Color BACKGROUND_COLOR = new Color(210, 230, 251);
    final static Color COOKMASTERBLACK_COLOR = new Color(37, 33, 32);
    
    public void createClientPage() {
        // Définissez le frame
        JFrame frame = new JFrame("CookMaster");
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("java/src/cookmaster/assets/logo.png"));
        }catch(IOException e) {
            System.out.println("Error: " + e);
        }

        JLabel pic = new JLabel(new ImageIcon(image));
        pic.setBounds(450, -50, 250, 250);

        JLabel cookmaster = new JLabel("COOKMASTER");
        cookmaster.setBounds(430, 30, 300, 300);
        cookmaster.setPreferredSize(new Dimension(200, 200));
        cookmaster.setFont(new Font("Heebo", Font.PLAIN, 40));
        cookmaster.setForeground(COOKMASTERBLACK_COLOR);

        try {
            Api api = new Api();
            StringBuilder response = api.getApiInfo("client/all", "GET");
            System.out.println(response.toString());
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }

        // Ajouter label et  frame
        frame.add(pic);
        frame.add(cookmaster);

        frame.setSize(1200, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

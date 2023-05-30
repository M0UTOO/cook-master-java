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

public class MainPage {

    final static Color TITLE_COLOR = new Color(77, 71, 167);
    final static Color BACKGROUND_COLOR = new Color(210, 230, 251);
    final static Color COOKMASTERBLACK_COLOR = new Color(37, 33, 32);
    
    public void createMainPage() throws IOException {
        // Définissez le frame
        JFrame frame = new JFrame("CookMaster");

        BufferedImage image = ImageIO.read(new File("java/src/cookmaster/assets/logo.png"));
        JLabel pic = new JLabel(new ImageIcon(image));
        pic.setBounds(470, -50, 250, 250);

        JLabel cookmaster = new JLabel("COOKMASTER");
        cookmaster.setBounds(450, 30, 300, 300);
        cookmaster.setPreferredSize(new Dimension(200, 200));
        cookmaster.setFont(new Font("Heebo", Font.PLAIN, 40));
        cookmaster.setForeground(COOKMASTERBLACK_COLOR);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(300, 150, 250, 250);
        email.setPreferredSize(new Dimension(200, 200));
        email.setFont(new Font("Heebo", Font.PLAIN, 20));
        email.setForeground(TITLE_COLOR);

        JTextField emailField = new RoundJTextField(20);
        emailField.setBounds(300, 300, 600, 70);
        emailField.setText("");
        PlaceholderTextField.setPlaceholder(emailField, "Enter your email");

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(300, 300, 250, 250);
        password.setPreferredSize(new Dimension(200, 200));
        password.setFont(new Font("Heebo", Font.PLAIN, 20));
        password.setForeground(TITLE_COLOR);

        JTextField passwordField = new RoundJTextField(20);
        passwordField.setBounds(300, 450, 600, 70);
        passwordField.setText("");
        PlaceholderTextField.setPlaceholder(passwordField, "Enter your password");


        JButton btnConnexion = new JButton("SE CONNECTER");
        btnConnexion.setBounds(300, 600, 600, 70);
        btnConnexion.setFont(new Font("Heebo", Font.BOLD, 20));
        btnConnexion.setForeground(TITLE_COLOR);
        btnConnexion.setBackground(BACKGROUND_COLOR);
        btnConnexion.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = passwordField.getText();
                try {
                    Api api = new Api();
                    StringBuilder response = api.loginManager(email, password);
                    if (response.toString().contains("\"role\":\"manager\"")) {
                        System.out.println("Manager");
                    }
                } catch (Exception exception) {
                    //exception.printStackTrace();
                }
            }
        });


        // Ajouter label et  frame
        frame.add(pic);
        frame.add(cookmaster);
        frame.add(email);
        frame.add(emailField);
        frame.add(password);
        frame.add(passwordField);
        frame.add(btnConnexion);

        frame.setSize(1200, 1000);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

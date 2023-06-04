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
        pic.setBounds(450, -50, 250, 250);

        JLabel cookmaster = new JLabel("COOKMASTER");
        cookmaster.setBounds(430, 30, 300, 300);
        cookmaster.setPreferredSize(new Dimension(200, 200));
        cookmaster.setFont(new Font("Heebo", Font.PLAIN, 40));
        cookmaster.setForeground(COOKMASTERBLACK_COLOR);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(280, 150, 250, 250);
        email.setPreferredSize(new Dimension(200, 200));
        email.setFont(new Font("Heebo", Font.PLAIN, 20));
        email.setForeground(TITLE_COLOR);

        JTextField emailField = new RoundJTextField(20);
        emailField.setBounds(280, 300, 600, 70);
        emailField.setText("");
        PlaceholderTextField.setPlaceholder(emailField, "Enter your email");

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(280, 300, 250, 250);
        password.setPreferredSize(new Dimension(200, 200));
        password.setFont(new Font("Heebo", Font.PLAIN, 20));
        password.setForeground(TITLE_COLOR);

        JTextField passwordField = new RoundJTextField(20);
        passwordField.setBounds(280, 450, 600, 70);
        passwordField.setText("");
        PlaceholderTextField.setPlaceholder(passwordField, "Enter your password");


        JButton btnConnection = new JButton("LOG IN");
        btnConnection.setBounds(280, 600, 600, 70);
        btnConnection.setFont(new Font("Heebo", Font.BOLD, 20));
        btnConnection.setForeground(TITLE_COLOR);
        btnConnection.setBackground(BACKGROUND_COLOR);
        btnConnection.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnConnection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = passwordField.getText();
                try {
                    Api api = new Api();
                    StringBuilder response = api.loginManager(email, password);
                    if (response.toString().contains("\"role\":\"manager\"")) {
                        frame.setDefaultCloseOperation(0);
                    }
                } catch (Exception exception) {
                    frame.setVisible(false);
                    frame.dispose();
                    MenuPage menuPage = new MenuPage();
                    menuPage.createMenuPage();
                    // JFrame frame = new JFrame("Error");
                    // JOptionPane.showMessageDialog(frame, "Email or password incorrect");
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
        frame.add(btnConnection);

        frame.setSize(1200, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

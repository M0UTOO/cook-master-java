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


public class MenuPage {

    final static Color TITLE_COLOR = new Color(77, 71, 167);
    final static Color BACKGROUND_COLOR = new Color(210, 230, 251);
    final static Color COOKMASTERBLACK_COLOR = new Color(37, 33, 32);
    
    public void createMenuPage() {
        // Définissez le frame
        JFrame frame = new JFrame("CookMaster");
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("java/src/cookmaster/assets/logo.png"));
        }catch(IOException e) {
            System.out.println("Error: " + e);
        }

        JLabel pic = new JLabel(new ImageIcon(image));
        pic.setBounds(470, -50, 250, 250);

        JLabel cookmaster = new JLabel("COOKMASTER");
        cookmaster.setBounds(450, 30, 300, 300);
        cookmaster.setPreferredSize(new Dimension(200, 200));
        cookmaster.setFont(new Font("Heebo", Font.PLAIN, 40));
        cookmaster.setForeground(COOKMASTERBLACK_COLOR);

        JButton btnClient = new JButton("GET CLIENTS INFO");
        btnClient.setBounds(300, 600, 600, 70);
        btnClient.setFont(new Font("Heebo", Font.BOLD, 20));
        btnClient.setForeground(TITLE_COLOR);
        btnClient.setBackground(BACKGROUND_COLOR);
        btnClient.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnEvent = new JButton("GET EVENTS INFO");
        btnEvent.setBounds(300, 600, 600, 70);
        btnEvent.setFont(new Font("Heebo", Font.BOLD, 20));
        btnEvent.setForeground(TITLE_COLOR);
        btnEvent.setBackground(BACKGROUND_COLOR);
        btnEvent.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnPrestation = new JButton("GET PRESTATIONS INFO");
        btnPrestation.setBounds(300, 600, 600, 70);
        btnPrestation.setFont(new Font("Heebo", Font.BOLD, 20));
        btnPrestation.setForeground(TITLE_COLOR);
        btnPrestation.setBackground(BACKGROUND_COLOR);
        btnPrestation.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnPrestation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnPDF = new JButton("DOWNLOAD PDF");
        btnPDF.setBounds(300, 600, 600, 70);
        btnPDF.setFont(new Font("Heebo", Font.BOLD, 20));
        btnPDF.setForeground(TITLE_COLOR);
        btnPDF.setBackground(BACKGROUND_COLOR);
        btnPDF.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });


        // Ajouter label et  frame
        frame.add(pic);
        frame.add(cookmaster);
        frame.add(btnClient);
        frame.add(btnEvent);
        frame.add(btnPrestation);
        frame.add(btnPDF);

        frame.setSize(1200, 1000);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}

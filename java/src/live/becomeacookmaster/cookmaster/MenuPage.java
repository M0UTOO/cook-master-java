package live.becomeacookmaster.cookmaster;

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
            image = ImageIO.read(new File("target/classes/logo.png"));
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

        JButton btnClient = new JButton("GET CLIENTS INFO");
        btnClient.setBounds(50, 325, 500, 125);
        btnClient.setFont(new Font("Heebo", Font.BOLD, 20));
        btnClient.setForeground(TITLE_COLOR);
        btnClient.setBackground(BACKGROUND_COLOR);
        btnClient.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Api api = new Api();
                    api.getApiInfo("", "GET");
                } catch (Exception exception) {
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Can't get database info");
                    return;
                }
                frame.dispose();
                ClientPage clientPage = new ClientPage();
                clientPage.createClientPage();
            }
        });

        JButton btnEvent = new JButton("GET EVENTS INFO");
        btnEvent.setBounds(600, 325, 500, 125);
        btnEvent.setFont(new Font("Heebo", Font.BOLD, 20));
        btnEvent.setForeground(TITLE_COLOR);
        btnEvent.setBackground(BACKGROUND_COLOR);
        btnEvent.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Api api = new Api();
                    api.getApiInfo("", "GET");
                } catch (Exception exception) {
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Can't get database info");
                    return;
                }
                frame.dispose();
                EventPage eventPage = new EventPage();
                eventPage.createEventPage();
            }
        });

        JButton btnPrestation = new JButton("GET ORDERS INFO");
        btnPrestation.setBounds(50, 575, 500, 125);
        btnPrestation.setFont(new Font("Heebo", Font.BOLD, 20));
        btnPrestation.setForeground(TITLE_COLOR);
        btnPrestation.setBackground(BACKGROUND_COLOR);
        btnPrestation.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnPrestation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Api api = new Api();
                    api.getApiInfo("", "GET");
                } catch (Exception exception) {
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Can't get database info");
                    return;
                }
                frame.dispose();
                PrestationPage prestationPage = new PrestationPage();
                prestationPage.createPrestationPage();
            }
        });

        JButton btnPDF = new JButton("DOWNLOAD PDF");
        btnPDF.setBounds(600, 575, 500, 125);
        btnPDF.setFont(new Font("Heebo", Font.BOLD, 20));
        btnPDF.setForeground(TITLE_COLOR);
        btnPDF.setBackground(BACKGROUND_COLOR);
        btnPDF.setBorder(new LineBorder(TITLE_COLOR, 1));
        btnPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Pdf pdf = new Pdf();
                    boolean iscreated = pdf.createPDF();
                    if (iscreated) {
                        JFrame frame = new JFrame("Success");
                        JOptionPane.showMessageDialog(frame, "PDF created");
                    } else {
                        JFrame frame = new JFrame("Error");
                        JOptionPane.showMessageDialog(frame, "Can't create PDF");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        try {
            image = ImageIO.read(new File("target/classes/return.png"));
        }catch(IOException e) {
            System.out.println("Error: " + e);
        }
        BufferedImage buttonIcon = image;
        JButton btnReturn = new JButton(new ImageIcon(buttonIcon));
        btnReturn.setBorderPainted(false);
        btnReturn.setFocusPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.setBounds(25, 25, 100, 100);
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainPage mainPage = new MainPage();
                try {
                    mainPage.createMainPage();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        // Ajouter label et  frame
        frame.add(pic);
        frame.add(cookmaster);
        frame.add(btnClient);
        frame.add(btnEvent);
        frame.add(btnPrestation);
        frame.add(btnPDF);
        frame.add(btnReturn);

        frame.setSize(1200, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}

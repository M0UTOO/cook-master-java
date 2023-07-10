package live.becomeacookmaster.cookmaster;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrestationPage {

    final static Color TITLE_COLOR = new Color(77, 71, 167);
    final static Color BACKGROUND_COLOR = new Color(210, 230, 251);
    final static Color COOKMASTERBLACK_COLOR = new Color(37, 33, 32);

    public void createPrestationPage() {

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

        try {
            image = ImageIO.read(new File("target/classes/return.png"));
        }catch(IOException e) {
            System.out.println("Error: " + e);
        }
        BufferedImage btnReturnIcon = image;
        JButton btnReturn = new JButton(new ImageIcon(btnReturnIcon));
        btnReturn.setBorderPainted(false);
        btnReturn.setFocusPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.setBounds(25, 25, 100, 100);
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuPage menuPage = new MenuPage();
                try {
                    menuPage.createMenuPage();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        JTextField idField = new RoundJTextField(20);
        idField.setBounds(400, 250, 250, 70);
        idField.setText("");
        PlaceholderTextField.setPlaceholder(idField, "Enter the ID of the order");

        try {
            image = ImageIO.read(new File("target/classes/go.png"));
        }catch(IOException e) {
            System.out.println("Error: " + e);
        }
        BufferedImage btnGoIcon = image;
        JButton btnGo = new JButton(new ImageIcon(btnGoIcon));
        btnGo.setBorderPainted(false);
        btnGo.setFocusPainted(false);
        btnGo.setContentAreaFilled(false);
        btnGo.setBounds(650, 235, 100, 100);
        btnGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                if (id.equals("Enter the ID of the order") || id.equals("")) {
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Please enter an ID");
                    return;
                }
                Api api = new Api();
                String response = "";
                try {
                    response = api.getApiInfo("order/" + id, "GET");
                } catch (Exception exception) {
                    //exception.printStackTrace();
                }
                if (response.contains("\"idorder\":")) {
                    frame.dispose();
                    OrderDescriptionPage orderDescriptionPage = new OrderDescriptionPage();
                    orderDescriptionPage.createOrderDescriptionPage(id);
                } else if (response.contains("\"message :\"")) {
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Could not find the order");
                } else {
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Error on event ID");
                }
            }
        });

        String response = "";

        try {
            Api api = new Api();
            response = api.getApiInfo("order/all", "GET");           
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }
      
        JsonToArray jsonToArray = new JsonToArray();
        String[][] eventList = jsonToArray.jsonToArray(response);  
        String column[]={"ID","Status","Price", "CreatedAt", "Delivery Address","ID Chef","ID Delivery Man","ID Client"};
        JTable jt=new JTable(eventList,column);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(50,350,1100,500);

        // Ajouter label et  frame
        frame.add(pic);
        frame.add(cookmaster);
        frame.add(btnReturn);
        frame.add(idField);
        frame.add(btnGo);
        frame.add(sp);

        frame.setSize(1200, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
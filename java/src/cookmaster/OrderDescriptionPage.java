package cookmaster;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderDescriptionPage {

    final static Color TITLE_COLOR = new Color(77, 71, 167);
    final static Color BACKGROUND_COLOR = new Color(210, 230, 251);
    final static Color COOKMASTERBLACK_COLOR = new Color(37, 33, 32);

    public void createOrderDescriptionPage(String id) {

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
            image = ImageIO.read(new File("java/src/cookmaster/assets/return.png"));
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
                PrestationPage prestationPage = new PrestationPage();
                try {
                    prestationPage.createPrestationPage();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        String response = "";

        try {
            Api api = new Api();
            response = api.getApiInfo("order/food/" + id, "GET");           
        }catch(Exception e) {
            //System.out.println("Error: " + e);
        }
        
        if (response.contains("null")) {
            response = "[{\"idfood\":\"None\",\"name\":\"None\",\"price\":\"None\"}]";
        }
        JsonToArray jsonToArrayF = new JsonToArray();
        String[][] eventListF = jsonToArrayF.jsonToArray(response);  
        String columnF[]={"Id Food", "Name", "Price"};
        JTable jtF=new JTable(eventListF,columnF);
        JScrollPane spFood=new JScrollPane(jtF);
        spFood.setBounds(600,250,550,600);

        JLabel foods = new JLabel("Foods :");
        foods.setBounds(850, 100, 250, 250);
        foods.setPreferredSize(new Dimension(200, 200));
        foods.setFont(new Font("Heebo", Font.PLAIN, 20));
        foods.setForeground(TITLE_COLOR);

        response = "";

        try {
            Api api = new Api();
            response = api.getApiInfo("order/item/" + id, "GET");           
        }catch(Exception e) {
            //System.out.println("Error: " + e);
        }
        
        if (response.contains("null")) {
            response = "[{\"iditem\":\"None\",\"name\":\"None\",\"price\":\"None\"}]";
        }
        JsonToArray jsonToArrayI = new JsonToArray();
        String[][] eventListI = jsonToArrayI.jsonToArray(response);  
        String columnI[]={"Id Item", "Name", "Price"};
        JTable jtI=new JTable(eventListI,columnI);
        JScrollPane spItem=new JScrollPane(jtI);
        spItem.setBounds(25,250,550,600);

        JLabel items = new JLabel("Items :");
        items.setBounds(275, 100, 250, 250);
        items.setPreferredSize(new Dimension(200, 200));
        items.setFont(new Font("Heebo", Font.PLAIN, 20));
        items.setForeground(TITLE_COLOR);

        // Ajouter label et  frame
        frame.add(pic);
        frame.add(cookmaster);
        frame.add(btnReturn);
        frame.add(spFood);
        frame.add(foods);
        frame.add(spItem);
        frame.add(items);

        frame.setSize(1200, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    } 
}

package live.becomeacookmaster.cookmaster;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDescriptionPage {
    
    final static Color TITLE_COLOR = new Color(77, 71, 167);
    final static Color BACKGROUND_COLOR = new Color(210, 230, 251);
    final static Color COOKMASTERBLACK_COLOR = new Color(37, 33, 32);

    public void createEventDescriptionPage(String id) {

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
                EventPage eventPage = new EventPage();
                try {
                    eventPage.createEventPage();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        String response = "";

        try {
            Api api = new Api();
            response = api.getApiInfo("event/animate/" + id, "GET");           
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }
      
        JsonToArray jsonToArrayCo = new JsonToArray();
        String[][] eventListCo = jsonToArrayCo.jsonToArray(response);  
        String columnCo[]={"IdContractor", "Email", "IdUser"};
        JTable jtCo=new JTable(eventListCo,columnCo);
        JScrollPane spContractor=new JScrollPane(jtCo);
        spContractor.setBounds(25,400,420,450);

        JLabel eventContractors = new JLabel("Event Contractors :");
        eventContractors.setBounds(150, 250, 250, 250);
        eventContractors.setPreferredSize(new Dimension(200, 200));
        eventContractors.setFont(new Font("Heebo", Font.PLAIN, 20));
        eventContractors.setForeground(TITLE_COLOR);

        try {
            Api api = new Api();
            response = api.getApiInfo("event/organize/" + id, "GET");           
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }
      
        JsonToArray jsonToArrayM = new JsonToArray();
        String[][] eventListM = jsonToArrayM.jsonToArray(response);  
        String columnM[]={"IdManager", "Email", "IdUser"};
        JTable jtM=new JTable(eventListM,columnM);
        JScrollPane spManager=new JScrollPane(jtM);
        spManager.setBounds(400,275,350,38);

        JLabel eventCreator = new JLabel("Event creator :");
        eventCreator.setBounds(500, 125, 250, 250);
        eventCreator.setPreferredSize(new Dimension(200, 200));
        eventCreator.setFont(new Font("Heebo", Font.PLAIN, 20));
        eventCreator.setForeground(TITLE_COLOR);

        response = "";

        try {
            Api api = new Api();
            response = api.getApiInfo("event/host/java/" + id, "GET");           
        }catch(Exception e) {
            //System.out.println("Error: " + e);
        }
        
        if (response.equals("")) {
            response = "[{\"idCookingSpace\":\"None\",\"name\":\"None\",\"idPremise\":\"None\"}]";
        }
        JsonToArray jsonToArrayP = new JsonToArray();
        String[][] eventListP = jsonToArrayP.jsonToArray(response);  
        String columnP[]={"Id Cooking Space", "Name", "Id Premise"};
        JTable jtP=new JTable(eventListP,columnP);
        JScrollPane spPremise=new JScrollPane(jtP);
        spPremise.setBounds(800,275,350,38);

        JLabel eventPlace = new JLabel("Place of the event :");
        eventPlace.setBounds(885, 125, 250, 250);
        eventPlace.setPreferredSize(new Dimension(200, 200));
        eventPlace.setFont(new Font("Heebo", Font.PLAIN, 20));
        eventPlace.setForeground(TITLE_COLOR);

        response = "";

        try {
            Api api = new Api();
            response = api.getApiInfo("event/groups/" + id, "GET");           
        }catch(Exception e) {
            //System.out.println("Error: " + e);
        }
        
        if (response.contains("\"idgroup\":\"1\"")) {
            response = "[{\"idgroup\":\"None\",\"name\":\"None\"}]";
        }
        JsonToArray jsonToArrayG = new JsonToArray();
        String[][] eventListG = jsonToArrayG.jsonToArray(response);  
        String columnG[]={"Id Group", "Name"};
        JTable jtG=new JTable(eventListG,columnG);
        JScrollPane spGroup=new JScrollPane(jtG);
        spGroup.setBounds(25,275,325,38);

        JLabel eventGroup = new JLabel("Event group :");
        eventGroup.setBounds(125, 125, 250, 250);
        eventGroup.setPreferredSize(new Dimension(200, 200));
        eventGroup.setFont(new Font("Heebo", Font.PLAIN, 20));
        eventGroup.setForeground(TITLE_COLOR);

        response = "";

        try {
            Api api = new Api();
            response = api.getApiInfo("event/participate/" + id, "GET");           
        }catch(Exception e) {
            //System.out.println("Error: " + e);
        }
        
        if (response.contains("null")) {
            response = "[{\"iduser\":\"None\",\"email\":\"None\",\"firstname\":\"None\",\"lastname\":\"None\",\"idclient\":\"None\",\"ispresent\":\"None\"}]";
        }
        JsonToArray jsonToArrayCl = new JsonToArray();
        String[][] eventListCl = jsonToArrayCl.jsonToArray(response);  
        String columnCl[]={"Id User", "Email", "Firstname", "Lastname", "Id Client", "Is Present"};
        JTable jtCl=new JTable(eventListCl,columnCl);
        JScrollPane spClient=new JScrollPane(jtCl);
        spClient.setBounds(500,400,650,450);

        JLabel eventParticipation = new JLabel("Clients participating :");
        eventParticipation.setBounds(725, 250, 250, 250);
        eventParticipation.setPreferredSize(new Dimension(200, 200));
        eventParticipation.setFont(new Font("Heebo", Font.PLAIN, 20));
        eventParticipation.setForeground(TITLE_COLOR);

        // Ajouter label et  frame
        frame.add(pic);
        frame.add(cookmaster);
        frame.add(btnReturn);
        frame.add(spContractor);
        frame.add(eventContractors);
        frame.add(spManager);
        frame.add(eventCreator);
        frame.add(spPremise);
        frame.add(eventPlace);
        frame.add(spGroup);
        frame.add(eventGroup);
        frame.add(spClient);
        frame.add(eventParticipation);

        frame.setSize(1200, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

package cookmaster;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Pdf {
    public boolean createPDF() throws Exception {
        try {
            PDDocument document = new PDDocument();

            createPage1(document);

            createPage2(document);

            createPage3(document);

            createPage4(document);

            createPage5(document);

            createPage6(document);

            createPage7(document);

            createPage8(document);

            document.save("./charts.pdf");
            document.close();

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    private void createPage1(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Clients Charts");

            content.endText();
            
            createPieChart(document, content, "Subscription Chart", "client/subscription", "top");

            createBarChart(document, content, "Average Client Particpation By Month", "Month", "Particpation", "client/participation", "bottom");

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createPage2(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Clients Charts");

            content.endText();

            createBarChart(document, content, "Clients By Country", "Country", "Clients", "client/country", "top");

            createBarChart(document, content, "Average Client Money Spent By Month", "Month", "Money", "client/money", "bottom");

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createPage3(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Events Charts");

            content.endText();

            createPieChart(document, content, "Events By Type", "event/type", "top");

            createBarChart(document, content, "Events For Each Month", "Month", "Counter", "event/month", "bottom");

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createPage4(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Events Charts");

            content.endText();

            createPieChart(document, content, "Events By Day Of The Week", "event/week", "top");

            createBarChart(document, content, "Events For Each Month In a Year", "Month", "Counter", "event/months", "bottom");

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createPage5(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Prestations Charts");

            content.endText();

            createPieChart(document, content, "Lessons By Difficulty", "lesson/difficulty", "top");

            createPieChart(document, content, "Books By Premises", "premise/books", "bottom");

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createPage6(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Prestations Charts");

            content.endText();

            createBarChart(document, content, "Orders By Month", "Month", "Orders", "order/month", "top");

            createBarChart(document, content, "Formations Finished", "Formation", "Count", "event/formation", "bottom");

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createPage7(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Top 5 Charts");
            content.endText();

            createTop5(content, font, "TOP 5 EVENTS", "event/top5", "Participation", 680);

            createTop5(content, font, "TOP 5 COOKING SPACE", "cookingspace/top5", "Books", 520);

            createTop5(content, font, "TOP 5 ITEMS", "order/top5item", "Times ordered", 360);

            createTop5(content, font, "TOP 5 FOODS", "order/top5food", "Times ordered", 200);

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private void createPage8(PDDocument document) throws Exception {
        try {

            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont( font, 12 );
            content.newLineAtOffset(220, 750);
            content.showText("CookMaster - Top 30 Chart");
            content.endText();

            createTop5(content, font, "TOP 30 CLIENTS", "client/top5", "Points", 680);

            content.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createTop5(PDPageContentStream content, PDType0Font font, String title, String apiPath, String counterName, int y) {

        try {
            content.beginText();
                content.setFont( font, 10 );
                content.newLineAtOffset(250, y);
                content.showText(title);
                content.endText();

                String response = "";

                try {
                    Api api = new Api();
                    response = api.getApiInfo(apiPath, "GET");           
                }catch(Exception e) {
                    System.out.println("Error: " + e);
                }
            
                JsonToArray jsonToArray = new JsonToArray();
                String[][] tab = jsonToArray.jsonToArray(response);  

                float startX = 100; // X-coordinate where the tab should start
                float tabWidth = 150; // Width of the tab
                float startY = y - 50; // Y-coordinate where the tab should start

                for (int row = 0; row < tab.length; row++) {
                    float currentX = startX;

                    for (int col = 0; col < tab[row].length; col++) {
                        if (row == 0 && col == 0) {
                            content.beginText();
                            content.newLineAtOffset(currentX, startY+25);
                            content.showText("Id");
                            content.endText();
                        }
                        if (row == 0 && col == 1) {
                            content.beginText();
                            content.newLineAtOffset(currentX, startY+25);
                            content.showText("Name");
                            content.endText();
                        }
                        if (row == 0 && col == 2) {
                            content.beginText();
                            content.newLineAtOffset(currentX, startY+25);
                            content.showText(counterName);
                            content.endText();
                        }
                        content.beginText();
                        content.newLineAtOffset(currentX, startY);
                        content.showText(tab[row][col]);
                        content.endText();

                        currentX += tabWidth;
                    }

                    startY -= 15; // Move to the next row
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createPieChart(PDDocument document, PDPageContentStream content, String title, String apiPath, String position) {

        try {
            DefaultPieDataset dataset = new DefaultPieDataset();
            String response;
            Api api = new Api();
            response = api.getApiInfo(apiPath, "GET");
            JsonToArray jsonToArrayG = new JsonToArray();
            String[][] eventListG = jsonToArrayG.jsonToArray(response);
            for (int i = 0; i < eventListG.length; i++) {
                dataset.setValue(eventListG[i][0], new Double(eventListG[i][1]));
            }

            JFreeChart chart = ChartFactory.createPieChart3D(
                    title,  // chart title
                    dataset,             // data
                    true,               // include legend
                    true,
                    false
            );

            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
            plot.setNoDataMessage("No data available");
            plot.setCircular(false);
            plot.setLabelGap(0.02);

                // Set the label generator to include both the section label and value
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0}: {1}");
            plot.setLabelGenerator(labelGenerator);

            BufferedImage chartImage = chart.createBufferedImage(400, 250);

            PDImageXObject pdfChartImage = JPEGFactory.createFromImage(document, chartImage, 1f);
            if (position.equals("bottom")) {
                content.drawImage(pdfChartImage, 100, 100);
            } else {
                content.drawImage(pdfChartImage, 100, 440);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createBarChart(PDDocument document, PDPageContentStream content, String title, String xLabel, String yLabel, String apiPath, String position) {

        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            String response;
            Api api = new Api();
            response = api.getApiInfo(apiPath, "GET");
            JsonToArray jsonToArrayG = new JsonToArray();
            String[][] eventListG = jsonToArrayG.jsonToArray(response);
            for (int i = 0; i < eventListG.length; i++) {
                dataset.addValue(Double.parseDouble(eventListG[i][1]), eventListG[i][0], "");
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    title,                  // chart title
                    xLabel,                 // domain axis label
                    yLabel,                 // range axis label
                    dataset,                // data
                    PlotOrientation.VERTICAL,
                    true,                  // include legend
                    true,
                    false
            );

            BufferedImage chartImage = chart.createBufferedImage(500, 300);

            PDImageXObject pdfChartImage = JPEGFactory.createFromImage(document, chartImage, 1f);
            if (position.equals("bottom")) {
                content.drawImage(pdfChartImage, 50, 50);
            } else {
                content.drawImage(pdfChartImage, 50, 420);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package cookmaster;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import java.io.File;
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


public class PdfTest {
    public void createPDF() throws Exception {
        try {
            PDDocument document = new PDDocument();

            createPage1(document);

            createPage2(document);

            document.save("./pdf/charts.pdf");
            document.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            
            createPieChart(document, content);

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

    private void createPieChart(PDDocument document, PDPageContentStream content) {

        try {
            DefaultPieDataset dataset = new DefaultPieDataset();
            String response;
            Api api = new Api();
            response = api.getApiInfo("client/subscription", "GET");
            JsonToArray jsonToArrayG = new JsonToArray();
            String[][] eventListG = jsonToArrayG.jsonToArray(response);
            for (int i = 0; i < eventListG.length; i++) {
                dataset.setValue(eventListG[i][0], new Double(eventListG[i][1]));
            }

            JFreeChart chart = ChartFactory.createPieChart3D(
                    "Subscription Charts",  // chart title
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
            content.drawImage(pdfChartImage, 100, 440);
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

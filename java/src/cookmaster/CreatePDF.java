package cookmaster;

import java.io.*;
import java.io.File;
import java.util.Calendar;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class CreatePDF {

    public void createPDF() throws IOException {

        try {
            String directoryPath = "./pdf/";
            String fileName = "example.pdf";

            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            // Create a new empty PDF document
            PDDocument document = new PDDocument();

            // Creating the PDDOcumentInformation object
            PDDocumentInformation pdd = document.getDocumentInformation();

            // Set the properties of the document
            pdd.setAuthor("CookMaster");
            pdd.setCreationDate(Calendar.getInstance());
            pdd.setCreator("cookmaster-app");
            pdd.setTitle("CookMaster");
            pdd.setSubject("CookMaster Charts Overview");

            // Create a new page in the document
            PDPage firstPage = new PDPage();

            // Add the page to the document
            document.addPage(firstPage);

            // Add a new paragraph to the document
            PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);

            // Add the title to the document
            contentStream.beginText();

            PDType0Font font = PDType0Font.load(document, new File("java/src/cookmaster/assets/fonts/Heebo-VariableFont_wght.ttf"));
            contentStream.setFont(font, 14);

            //Setting the position for the line
            contentStream.newLineAtOffset(215, 700);

            //Adding text in the form of string
            String title = "CookMaster Charts Overview";
            contentStream.showText(title);

            //Ending the content stream
            contentStream.endText();

            // Make sure that the content stream is closed:
            contentStream.close();

            // Save the document
            document.save(directoryPath + fileName);
            
            // Close the document
            document.close();
            
            System.out.println("PDF created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating PDF: " + e.getMessage());
        }

    }
    
}

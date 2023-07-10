package live.becomeacookmaster.cookmaster;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;


public class CustomFontExample {
    
    public Font registerFont() throws Exception {
        // Register the font
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("target/classes/fonts/Heebo-VariableFont_wght.ttf")));

        // Use the font
        Font customFont = new Font("MyFont", Font.BOLD, 20);
        // ... use the customFont in your components

        return customFont; 
    }
}
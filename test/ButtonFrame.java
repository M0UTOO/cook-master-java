package test;

import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public final class ButtonFrame extends JFrame {

ButtonFrame(String buttonText) {
    final JButton button = new JButton(buttonText);

    addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            float fittedFontSize = 1.0f;        
            while (getFittedText(button, fittedFontSize += 1.0f).equals(button.getText()));
            button.setFont(button.getFont().deriveFont(fittedFontSize - 1.0f));
            button.revalidate();
            button.repaint();
        }
    });

    getContentPane().add(button);
}

private String getFittedText(JButton button, float fontSize) {
    Insets i = button.getInsets();
    Rectangle viewRect = new Rectangle();
    Rectangle textRect = new Rectangle();
    Rectangle iconRect = new Rectangle();
    viewRect.x = i.left;
    viewRect.y = i.top;
    viewRect.width = button.getWidth() - (i.right + viewRect.x);
    viewRect.height = button.getHeight() - (i.bottom + viewRect.y);
    textRect.x = textRect.y = textRect.width = textRect.height = 0;
    iconRect.x = iconRect.y = iconRect.width = iconRect.height = 0;

    return SwingUtilities.layoutCompoundLabel(
            button, 
            button.getFontMetrics(button.getFont().deriveFont(fontSize)),
            button.getText(),
            button.getIcon(),
            button.getVerticalAlignment(),
            button.getHorizontalAlignment(),
            button.getVerticalTextPosition(),
            button.getHorizontalTextPosition(),
            viewRect,
            textRect,
            iconRect,
            button.getIconTextGap());
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {         
        @Override
        public void run() {
            JFrame frame = new ButtonFrame("sample text");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
        }
    });     
}
}
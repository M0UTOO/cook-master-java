package cookmaster;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

class PlaceholderTextField extends JTextField {

    final static Color titleColor = new Color(77, 71, 167);

    public static void setPlaceholder(JTextField textField, String placeholder) {
        Font originalFont = textField.getFont();
        Font italicFont = originalFont.deriveFont(Font.ITALIC);

        textField.setText(placeholder);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setFont(new Font("Arial", Font.PLAIN, 20));
                    textField.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, titleColor));
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setFont(new Font("Arial", Font.PLAIN, 20));
                    textField.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, titleColor));
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                super.replace(fb, offset, length, text, attrs);
                if (textField.getText().equals(placeholder)) {
                    textField.setCaretPosition(0);
                }
            }
        });
    }

}
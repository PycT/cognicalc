package utils;

import java.awt.Font;
import javax.swing.JComponent;

public class Utils {

    public static void fitFont(JComponent object, String string, double width) {
        Font font = object.getFont();
        int stringWidth = object.getFontMetrics(font).stringWidth(string);
        double updateCoeff = width / stringWidth;
        int fontSize = (int)(font.getSize() * updateCoeff);
        if (fontSize > Config.maxDisplayFontSize) fontSize = Config.maxDisplayFontSize;
        Font fontUpdate = new Font(
            font.getName(),
            font.PLAIN,
            fontSize
        );
        object.setFont(fontUpdate);

    }

}
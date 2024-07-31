package utils;

public class Config {
    public static String appTitleString="Cognicalc";

    public static String numbersFormat = "%,.2f";

    public static int maxDisplayFontSize = 80;

    public static double scale = 1.2;
    
    public static int baseButtonHeight = 48;
    public static int baseButtonWidth = 48;

    public static int buttonsPerRow = 4;
    public static int buttonRowsMax = 8; // affects window height

    public static int buttonHeight = (int) (baseButtonHeight * scale);
    public static int buttonWidth = (int) (baseButtonWidth * scale);
    public static int vSpacing = buttonHeight / 4;
    public static int hSpacing = buttonWidth / 4;

    public static int displayAreaWidth = (buttonWidth + hSpacing) * buttonsPerRow - hSpacing;
    public static int displayAreaHeight = (buttonHeight + vSpacing) * 2;

    public static int windowWidth= buttonWidth * buttonsPerRow + hSpacing * (buttonsPerRow + 1);
    public static int windowHeight = (buttonHeight + vSpacing) * buttonRowsMax;

    public static int buttonsStartingPointX = hSpacing;
    public static int buttonsStartingPointY = displayAreaHeight + 2 * vSpacing;

}
package main;

import javax.swing.JFrame;
import java.awt.Color;
import utils.Config;

public class Cognicalc {
    private JFrame mainWindow;
    private CalcOperations operations;
    private CalcDisplay display;
    private CalcKeypad keypad;

    public Cognicalc() {
        buildWindow();
    }

    private void buildWindow() {
        this.mainWindow = new JFrame(Config.appTitleString);
        this.operations = new CalcOperations();

        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainWindow.setSize(Config.windowWidth, Config.windowHeight);
        this.mainWindow.setResizable(false);
        this.mainWindow.getContentPane().setBackground(new Color(33, 33, 33));

        this.display = new CalcDisplay(this);

        this.keypad = new CalcKeypad(this);

        this.mainWindow.setLayout(null);

        this.mainWindow.setLocationRelativeTo(null);
        this.mainWindow.setVisible(true);
    }

    public JFrame getMainWindow() {
        return this.mainWindow;
    }

    public CalcOperations getOperationsCore() {
        return this.operations;
    }

    public CalcDisplay getDisplay() {
        return this.display;
    }

}
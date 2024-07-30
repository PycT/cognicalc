package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import utils.Config;
import utils.Utils;

class CalcDisplay {
    private Cognicalc hostApp;
    private JPanel displayArea;
    private JLabel text;

    public CalcDisplay(Cognicalc host) {
        this.hostApp = host;
        this.displayArea = new JPanel();
        this.displayArea.setBounds(
            Config.hSpacing,
            Config.vSpacing,
            Config.displayAreaWidth,
            Config.displayAreaHeight
        );
        this.displayArea.setBackground(new Color(200, 200, 200));

        this.text = new JLabel();

        this.displayArea.add(text);

        this.hostApp.getMainWindow().add(displayArea);
        this.update();
    }

    public void update() {
        CalcOperations operations = this.hostApp.getOperationsCore();
        String toDisplay = operations.getOperand1();
        String operation = operations.getOperation();
        if (operation.length() > 0) {
            toDisplay = toDisplay.concat(" ").concat(operation);
            String opd2 = operations.getOperand2();
            if (opd2.length() > 0) toDisplay = toDisplay.concat(" ").concat(opd2);
        }

        double width = (double)(Config.displayAreaWidth - Config.hSpacing * 2);
        Utils.fitFont(this.text, toDisplay, width);
        
        this.text.setText(toDisplay);
    }

}
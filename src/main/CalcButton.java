package main;

import javax.swing.JButton;
import utils.Utils;
import utils.Config;


public class CalcButton extends JButton {

    public CalcButton(String label, Runnable action) {
        super();
        this.setText(label);
        double width = (double) Config.buttonWidth / 4;
        Utils.fitFont(this, label, width);

        this.addActionListener((event) -> action.run());
    }

}
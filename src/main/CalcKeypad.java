package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import utils.Config;

class CalcKeypad {
    private Cognicalc hostApp;
    private ArrayList<CalcButton> buttons = new ArrayList<CalcButton>();

    public CalcKeypad(Cognicalc app) {
        this.hostApp = app;

        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};

        HashMap<String, Runnable> operations = new HashMap<String, Runnable>();
        operations.put("-n", () -> this.hostApp.getOperationsCore().negate());
        operations.put("←", () -> this.hostApp.getOperationsCore().backSpace());
        operations.put("*", () -> this.hostApp.getOperationsCore().setOperation("*"));
        operations.put("/", () -> this.hostApp.getOperationsCore().setOperation("/"));
        operations.put("-", () -> this.hostApp.getOperationsCore().setOperation("-"));
        operations.put("+", () -> this.hostApp.getOperationsCore().setOperation("+"));
        operations.put("C", () -> this.hostApp.getOperationsCore().clear());
        operations.put("=", () -> this.hostApp.getOperationsCore().execute());

        for (String digit : digits) {
            this.buttons.add(
                new CalcButton(digit, () -> {
                    this.hostApp.getOperationsCore().inputDigit(digit);
                    this.hostApp.getDisplay().update();
                    this.updateKeyPad();
                })
            );
        }

        for (String opKey: operations.keySet()) {
            this.buttons.add(
                new CalcButton(opKey, () -> {
                    operations.get(opKey).run();
                    this.hostApp.getDisplay().update();
                    this.updateKeyPad();
                })
            );
        }

        this.updateKeyPad();
        this.initKeypad();

    }

    public void initKeypad() {
        for (CalcButton button : this.buttons) {
            this.hostApp.getMainWindow().add(button);
        }
    }

    public void updateKeyPad() {
        Collections.shuffle(this.buttons);

        int x = Config.buttonsStartingPointX;
        int y = Config.buttonsStartingPointY;
        int counter = 0;

        for (CalcButton button : this.buttons) {
            button.setBounds(x, y, Config.buttonWidth, Config.buttonHeight);
            x += Config.buttonWidth + Config.hSpacing;
            counter++;
            if (counter == Config.buttonsPerRow) {
                counter = 0;
                x = Config.buttonsStartingPointX;
                y += Config.buttonHeight + Config.vSpacing;
            }
        }
    }
}
package main;

import java.util.HashMap;
import utils.Config;

class CalcOperations {

    private HashMap<String, String> signature = new HashMap<String, String>() {{
        put("operand1", "0");
        put("operand2", "");
        put("operation", "");
    }};

    public CalcOperations(){
        this.clear();
    }

    public void clear() {
        this.signature.put("operand1", "0");
        this.signature.put("operand2", "");
        this.signature.put("operation", "");
    }

    private void addDigit2Operand(String operandName, String digit) {
        String operandValue = this.signature.get(operandName);
        switch (digit) {
            case ".":
                if (!operandValue.contains(".")) operandValue = operandValue.concat(
                    (operandValue.length() == 0) ? "0." : "."
                );
                break;
            default:
                operandValue = (operandValue == "0") ? digit : operandValue.concat(digit);
        }
        this.signature.put(operandName, operandValue);
    }


    public void inputDigit(String digit) {
        if (this.getOperation().length() > 0) this.addDigit2Operand("operand2", digit);
        else this.addDigit2Operand("operand1", digit);
    }


    public void negateOperand(String operandName) {
        String operandValue = this.signature.get(operandName);
        if (!(operandValue.equals("0"))
            && 
            !(operandValue.equals(String.format(Config.numbersFormat, 0.0d)))
        ) {
            if (operandValue.substring(0, 1).equals("-")) operandValue = operandValue.substring(1);
            else operandValue = "-".concat(operandValue);
        }
        this.signature.put(operandName, operandValue);
    }


    public void negate() {
        if (this.getOperation().length() > 0) this.negateOperand("operand2");
        else this.negateOperand("operand1");
    }


    public void backSpace() {
        String item = this.getOperand2();
        int length = item.length();
        if (length > 0) {
            item = item.substring(0, length - 1);
            if (item.equals("-")) item = "";
            this.setOperand2(item);
            return;
        } else if (this.getOperation().length() > 0) {
            this.setOperation("");
            return;
        } else {
            item = this.getOperand1();
            length = item.length();
            item = length > 1 ? item.substring(0, length -1) : "0";
            if (item.equals("-")) item = "0";
            this.setOperand1(item);
        }
    }


    public void execute() {

        if (this.getOperation().length() == 0 || this.getOperand2().length() == 0) return;

        double operand1 = Double.parseDouble(this.getOperand1());
        double operand2 = Double.parseDouble(this.getOperand2());
        double result = 0;
        boolean error = false;

        switch (this.getOperation()) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-": 
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) error = true;
                else result = operand1 / operand2;
                break;
        }

        this.clear();
        this.setOperand1(error ? "0" : String.format(Config.numbersFormat, result));

    }


    private void setOperand1(String value) {
        this.signature.put("operand1", value);
    }

    private void setOperand2(String value) {
        this.signature.put("operand2", value);
    }

    public void setOperation(String operation) {
        this.signature.put("operation", operation);
    }


    public String getOperand1() {
        return this.signature.get("operand1");
    }

    public String getOperand2() {
        return this.signature.get("operand2");
    }

    public String getOperation() {
        return this.signature.get("operation");
    }


}
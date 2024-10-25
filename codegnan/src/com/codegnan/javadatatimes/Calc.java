package com.codegnan.javadatatimes;

public class Calc {
    int cal(String num) {
        if (num.contains("*") || num.contains("/") || num.contains("-") || num.contains("+")) {
            if (num.contains("*")) {
                int in1 = num.indexOf("*");
                int pre = Integer.parseInt(getLeftOperand(num, in1));
                int post = Integer.parseInt(getRightOperand(num, in1));
                String res = String.valueOf(pre * post);
                String subb = num.substring(getLeftOperandStart(num, in1), getRightOperandEnd(num, in1));
                num = num.replace(subb, res);
                return cal(num);
            }
            if (num.contains("/")) {
                int in1 = num.indexOf("/");
                int pre = Integer.parseInt(getLeftOperand(num, in1));
                int post = Integer.parseInt(getRightOperand(num, in1));
                String res = String.valueOf(pre / post);
                String subb = num.substring(getLeftOperandStart(num, in1), getRightOperandEnd(num, in1));
                num = num.replace(subb, res);
                return cal(num);
            }
            if (num.contains("+")) {
                int in1 = num.indexOf("+");
                return cal(num.substring(0, in1)) + cal(num.substring(in1 + 1));
            }
            if (num.contains("-")) {
                int in1 = num.indexOf("-");
                return cal(num.substring(0, in1)) - cal(num.substring(in1 + 1));
            }
        } else {
            return Integer.parseInt(num);
        }
        return 0;
    }

    private String getLeftOperand(String num, int operatorIndex) {
        int startIndex = getLeftOperandStart(num, operatorIndex);
        return num.substring(startIndex, operatorIndex);
    }

    private int getLeftOperandStart(String num, int operatorIndex) {
        int index = operatorIndex - 1;
        while (index >= 0 && Character.isDigit(num.charAt(index))) {
            index--;
        }
        return index + 1;
    }

    private String getRightOperand(String num, int operatorIndex) {
        int endIndex = getRightOperandEnd(num, operatorIndex);
        return num.substring(operatorIndex + 1, endIndex);
    }

    private int getRightOperandEnd(String num, int operatorIndex) {
        int index = operatorIndex + 1;
        while (index < num.length() && Character.isDigit(num.charAt(index))) {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        String num = "22+5*33-1";
        Calc c = new Calc();
        System.out.println(c.cal(num)); // Expected output: 186
    }
}

package cs20models;

/**
 * A class to model the problem or situation your program solves
 *
 * @author cheng
 */
public class CalcSimple {

    private int num1, num2;
    private char operation;

    public CalcSimple() {
        this.operation = '+';
        this.num1 = 0;
        this.num2 = 0;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operator) {
        operation = operator;
    }

    public void setNum1(String num) {
        num1 = Integer.parseInt(num);
    }

    public void setNum2(String num) {
        num2 = Integer.parseInt(num);
    }

    public int getResult() {
        int answer = 0;
        switch (operation) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            default:
                answer = 404;
                break;
        }
        return answer;
    }
}

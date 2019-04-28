package personal.finance;

/**
 * Simple command line arithmetic.
 */
public class InlineCalculator {
    public static void wrongExpressionExit() {
        System.out.println("Provide correct expression.");
        System.exit(1);
    }

    public static void main(String args[]) {
        String expression = args[0];
        // expression can't be less than 3 symbols, e.g. simplest is 1+1
        if(expression.length() < 3) {
            wrongExpressionExit();
        }

        int index = 0;

        // get left argument
        String leftPart = "";
        while(true) {
            char ch = expression.charAt(index);
            if(Character.isDigit(ch)) {
                leftPart += ch;
                index++;
            } else {
                break;
            }
        }

        // get operator
        String operator = Character.toString(expression.charAt(index));
        if("+-/*%".contains(operator)) {
            index++;
        } else {
            wrongExpressionExit();
        }

        // get right argument
        String rightPart = "";
        while(true) {
            if(index == expression.length()) {
                break;
            }
            char ch = expression.charAt(index);
            if(Character.isDigit(ch)) {
                rightPart += ch;
                index++;
            } else {
                wrongExpressionExit();
            }
        }

        System.out.println("Your expression is " + leftPart + operator + rightPart);
        int leftArg = Integer.parseInt(leftPart);
        int rightArg = Integer.parseInt(rightPart);
        int result = 0;
        switch(operator) {
            case "+":
                result = leftArg + rightArg;
                break;
            case "-":
                result = leftArg - rightArg;
                break;
            case "*":
                result = leftArg * rightArg;
                break;
            case "/":
                result = leftArg / rightArg;
                break;
            case "%":
                result = (leftArg / 100) * rightArg;
                break;
            default:
                wrongExpressionExit();
        }
        System.out.println("Result is " + result);
    }
}

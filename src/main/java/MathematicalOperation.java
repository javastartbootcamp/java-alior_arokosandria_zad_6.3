public class MathematicalOperation {
    private double number1;
    private String operator;
    private double number2;

    public MathematicalOperation(double number1, String operator, double number2) {
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;
    }

    public double getNumber1() {
        return number1;
    }

    public String getOperator() {
        return operator;
    }

    public double getNumber2() {
        return number2;
    }

    public double mathematicalOperationResult() {
        double result = switch (operator) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> {
                if (number2 == 0) {
                    throw new ArithmeticException("Nie można dzielić przez zero.");
                }
                yield number1 / number2;
            }
            default -> throw new IllegalArgumentException("Niepoprawny operator.");
        };
        return result;
    }
}


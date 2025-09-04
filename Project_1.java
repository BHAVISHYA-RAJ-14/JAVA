//make a calculator that can do addition, subtraction, multiplication, division & handle invalid inputs as well as division by zero , and it should ask user that would he like to continue or not
import java.util.Scanner;
public class Project_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.println("Enter first number:");
            double num1 = getValidNumber(scanner);

            System.out.println("Enter an operator (+, -, *, /):");
            char operator = getValidOperator(scanner);

            System.out.println("Enter second number:");
            double num2 = getValidNumber(scanner);

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    }
                    break;
                default:
                    validOperation = false;
                    System.out.println("Error: Invalid operator.");
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }

            System.out.println("Would you like to perform another calculation? (Y/N)");
            String response = scanner.next().toLowerCase();
            continueCalculating = response.equals("Y");
        }

        scanner.close();
        System.out.println("Calculator closed.");
    }

    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
    }

    private static char getValidOperator(Scanner scanner) {
        while (true) {
            char operator = scanner.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                return operator;
            } else {
                System.out.println("Invalid operator. Please enter one of (+, -, *, /):");
            }
        }
    }
}
import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SCIENTIFIC CALCULATOR ===");
        System.out.println("Welcome to Java Calculator!");
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    basicCalculator();
                    break;
                case 2:
                    scientificCalculator();
                    break;
                case 3:
                    percentageCalculator();
                    break;
                case 4:
                    powerCalculator();
                    break;
                case 5:
                    rootCalculator();
                    break;
                case 6:
                    factorialCalculator();
                    break;
                case 7:
                    trigonometricCalculator();
                    break;
                case 8:
                    System.out.println("Thank you for using Calculator!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n=== CALCULATOR MENU ===");
        System.out.println("1. Basic Calculator (+, -, *, /)");
        System.out.println("2. Scientific Calculator");
        System.out.println("3. Percentage Calculator");
        System.out.println("4. Power Calculator");
        System.out.println("5. Root Calculator");
        System.out.println("6. Factorial Calculator");
        System.out.println("7. Trigonometric Calculator");
        System.out.println("8. Exit");
        System.out.println("=======================");
    }
    
    private static void basicCalculator() {
        System.out.println("\n=== BASIC CALCULATOR ===");
        
        double num1 = getDoubleInput("Enter first number: ");
        System.out.println("Available operations: +, -, *, /, %");
        String operation = getStringInput("Enter operation: ");
        double num2 = getDoubleInput("Enter second number: ");
        
        double result = 0;
        boolean validOperation = true;
        
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;
            case "%":
                result = num1 % num2;
                break;
            default:
                System.out.println("Invalid operation!");
                validOperation = false;
        }
        
        if (validOperation) {
            System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operation, num2, result);
        }
    }
    
    private static void scientificCalculator() {
        System.out.println("\n=== SCIENTIFIC CALCULATOR ===");
        System.out.println("Available functions:");
        System.out.println("1. Square (x²)");
        System.out.println("2. Cube (x³)");
        System.out.println("3. Square Root (√x)");
        System.out.println("4. Cube Root (∛x)");
        System.out.println("5. Natural Logarithm (ln x)");
        System.out.println("6. Logarithm base 10 (log x)");
        System.out.println("7. Exponential (e^x)");
        System.out.println("8. Absolute Value (|x|)");
        
        int function = getIntInput("Enter function number: ");
        double number = getDoubleInput("Enter number: ");
        
        double result = 0;
        boolean validFunction = true;
        
        switch (function) {
            case 1:
                result = Math.pow(number, 2);
                System.out.printf("Square of %.2f = %.2f%n", number, result);
                break;
            case 2:
                result = Math.pow(number, 3);
                System.out.printf("Cube of %.2f = %.2f%n", number, result);
                break;
            case 3:
                if (number >= 0) {
                    result = Math.sqrt(number);
                    System.out.printf("Square root of %.2f = %.2f%n", number, result);
                } else {
                    System.out.println("Error: Cannot calculate square root of negative number!");
                }
                break;
            case 4:
                result = Math.cbrt(number);
                System.out.printf("Cube root of %.2f = %.2f%n", number, result);
                break;
            case 5:
                if (number > 0) {
                    result = Math.log(number);
                    System.out.printf("Natural logarithm of %.2f = %.2f%n", number, result);
                } else {
                    System.out.println("Error: Cannot calculate logarithm of non-positive number!");
                }
                break;
            case 6:
                if (number > 0) {
                    result = Math.log10(number);
                    System.out.printf("Logarithm base 10 of %.2f = %.2f%n", number, result);
                } else {
                    System.out.println("Error: Cannot calculate logarithm of non-positive number!");
                }
                break;
            case 7:
                result = Math.exp(number);
                System.out.printf("e^%.2f = %.2f%n", number, result);
                break;
            case 8:
                result = Math.abs(number);
                System.out.printf("Absolute value of %.2f = %.2f%n", number, result);
                break;
            default:
                System.out.println("Invalid function!");
                validFunction = false;
        }
    }
    
    private static void percentageCalculator() {
        System.out.println("\n=== PERCENTAGE CALCULATOR ===");
        System.out.println("1. Calculate percentage of a number");
        System.out.println("2. Calculate percentage increase/decrease");
        System.out.println("3. Calculate percentage difference");
        
        int choice = getIntInput("Enter choice: ");
        
        switch (choice) {
            case 1:
                double number = getDoubleInput("Enter the number: ");
                double percentage = getDoubleInput("Enter percentage: ");
                double result = (number * percentage) / 100;
                System.out.printf("%.1f%% of %.2f = %.2f%n", percentage, number, result);
                break;
            case 2:
                double originalValue = getDoubleInput("Enter original value: ");
                double newValue = getDoubleInput("Enter new value: ");
                double change = ((newValue - originalValue) / originalValue) * 100;
                System.out.printf("Percentage change: %.2f%%%n", change);
                if (change > 0) {
                    System.out.println("This is an increase.");
                } else if (change < 0) {
                    System.out.println("This is a decrease.");
                } else {
                    System.out.println("No change.");
                }
                break;
            case 3:
                double value1 = getDoubleInput("Enter first value: ");
                double value2 = getDoubleInput("Enter second value: ");
                double difference = Math.abs(value1 - value2);
                double average = (value1 + value2) / 2;
                double percentDiff = (difference / average) * 100;
                System.out.printf("Percentage difference: %.2f%%%n", percentDiff);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void powerCalculator() {
        System.out.println("\n=== POWER CALCULATOR ===");
        double base = getDoubleInput("Enter base number: ");
        double exponent = getDoubleInput("Enter exponent: ");
        
        double result = Math.pow(base, exponent);
        System.out.printf("%.2f ^ %.2f = %.2f%n", base, exponent, result);
    }
    
    private static void rootCalculator() {
        System.out.println("\n=== ROOT CALCULATOR ===");
        System.out.println("1. Square Root");
        System.out.println("2. Cube Root");
        System.out.println("3. Nth Root");
        
        int choice = getIntInput("Enter choice: ");
        
        switch (choice) {
            case 1:
                double number1 = getDoubleInput("Enter number: ");
                if (number1 >= 0) {
                    double sqrtResult = Math.sqrt(number1);
                    System.out.printf("Square root of %.2f = %.2f%n", number1, sqrtResult);
                } else {
                    System.out.println("Error: Cannot calculate square root of negative number!");
                }
                break;
            case 2:
                double number2 = getDoubleInput("Enter number: ");
                double cbrtResult = Math.cbrt(number2);
                System.out.printf("Cube root of %.2f = %.2f%n", number2, cbrtResult);
                break;
            case 3:
                double number3 = getDoubleInput("Enter number: ");
                double n = getDoubleInput("Enter root degree (n): ");
                if (n != 0) {
                    double nthRootResult = Math.pow(number3, 1.0 / n);
                    System.out.printf("%.0fth root of %.2f = %.2f%n", n, number3, nthRootResult);
                } else {
                    System.out.println("Error: Root degree cannot be zero!");
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void factorialCalculator() {
        System.out.println("\n=== FACTORIAL CALCULATOR ===");
        int number = getIntInput("Enter a positive integer: ");
        
        if (number < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers!");
            return;
        }
        
        if (number > 20) {
            System.out.println("Warning: Result may be very large for numbers > 20!");
        }
        
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        
        System.out.printf("Factorial of %d = %d%n", number, factorial);
    }
    
    private static void trigonometricCalculator() {
        System.out.println("\n=== TRIGONOMETRIC CALCULATOR ===");
        System.out.println("1. Sine (sin)");
        System.out.println("2. Cosine (cos)");
        System.out.println("3. Tangent (tan)");
        System.out.println("4. Arcsine (asin)");
        System.out.println("5. Arccosine (acos)");
        System.out.println("6. Arctangent (atan)");
        
        int choice = getIntInput("Enter choice: ");
        double angle = getDoubleInput("Enter angle in degrees: ");
        
        // Convert degrees to radians
        double radians = Math.toRadians(angle);
        double result = 0;
        boolean validFunction = true;
        
        switch (choice) {
            case 1:
                result = Math.sin(radians);
                System.out.printf("sin(%.2f°) = %.4f%n", angle, result);
                break;
            case 2:
                result = Math.cos(radians);
                System.out.printf("cos(%.2f°) = %.4f%n", angle, result);
                break;
            case 3:
                result = Math.tan(radians);
                System.out.printf("tan(%.2f°) = %.4f%n", angle, result);
                break;
            case 4:
                if (angle >= -1 && angle <= 1) {
                    result = Math.asin(angle);
                    result = Math.toDegrees(result);
                    System.out.printf("asin(%.2f) = %.2f°%n", angle, result);
                } else {
                    System.out.println("Error: Input must be between -1 and 1 for arcsine!");
                }
                break;
            case 5:
                if (angle >= -1 && angle <= 1) {
                    result = Math.acos(angle);
                    result = Math.toDegrees(result);
                    System.out.printf("acos(%.2f) = %.2f°%n", angle, result);
                } else {
                    System.out.println("Error: Input must be between -1 and 1 for arccosine!");
                }
                break;
            case 6:
                result = Math.atan(angle);
                result = Math.toDegrees(result);
                System.out.printf("atan(%.2f) = %.2f°%n", angle, result);
                break;
            default:
                System.out.println("Invalid choice!");
                validFunction = false;
        }
    }
    
    // Utility methods
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }
    
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double input = Double.parseDouble(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}

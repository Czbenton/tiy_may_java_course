import java.util.Scanner;

/**
 * Created by Zach on 7/17/17.
 */
public class Main {

    public static void main(String[] args) {

        showResults(getUserInput("Please enter a number"),getUserInput("Please enter another number"));

    }

    private static double getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        return Double.parseDouble(scanner.nextLine());
    }


    private static void showResults(double x, double y) {
        double sum = 0;
        double diff = 0;
        double product = 0;
        double quotient = 0;
        double remainder = 0;

        sum = x + y;
        diff = x - y;
        product = x * y;
        quotient = x / y;
        remainder = x % y;

        System.out.printf("Sum: %s\n" + "Diff: %s\n" + "Product: %s\n" + "Quotient: %s\n" + "Remainder: %s", sum, diff, product, quotient, remainder);
    }


}


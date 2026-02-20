import java.util.Scanner;

public class CurrencyConverter{

    private static final double USD_TO_INR = 83.47;
    private static final double INR_TO_USD = 1 / USD_TO_INR;

    private static final double EUR_TO_INR = 89.10;
    private static final double INR_TO_EUR = 1 / EUR_TO_INR;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========== Currency Exchange System ==========");
        System.out.println("1. Convert USD to INR");
        System.out.println("2. Convert INR to USD");
        System.out.println("3. Convert EUR to INR");
        System.out.println("4. Convert INR to EUR");
        System.out.print("Select conversion option: ");

        int option = input.nextInt();

        switch (option) {

            case 1:
                System.out.print("Enter amount in USD: ");
                double usdAmount = input.nextDouble();
                displayResult(usdAmount, "USD", convertUsdToInr(usdAmount), "INR");
                break;

            case 2:
                System.out.print("Enter amount in INR: ");
                double inrAmount1 = input.nextDouble();
                displayResult(inrAmount1, "INR", convertInrToUsd(inrAmount1), "USD");
                break;

            case 3:
                System.out.print("Enter amount in EUR: ");
                double eurAmount = input.nextDouble();
                displayResult(eurAmount, "EUR", convertEurToInr(eurAmount), "INR");
                break;

            case 4:
                System.out.print("Enter amount in INR: ");
                double inrAmount2 = input.nextDouble();
                displayResult(inrAmount2, "INR", convertInrToEur(inrAmount2), "EUR");
                break;

            default:
                System.out.println("Invalid selection. Please run the program again.");
        }

        input.close();
    }

    private static double convertUsdToInr(double amount) {
        return amount * USD_TO_INR;
    }

    private static double convertInrToUsd(double amount) {
        return amount * INR_TO_USD;
    }

    private static double convertEurToInr(double amount) {
        return amount * EUR_TO_INR;
    }

    private static double convertInrToEur(double amount) {
        return amount * INR_TO_EUR;
    }

    private static void displayResult(double originalAmount, String fromCurrency,
                                      double convertedAmount, String toCurrency) {

        System.out.printf("Converted: %.2f %s = %.2f %s\n",
                originalAmount, fromCurrency, convertedAmount, toCurrency);
    }
}

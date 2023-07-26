import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        final byte ANNUAL_MONTHS = 12;
        final byte PERCENTAGE = 100;

        int principal = 0;
        float monthlyInterest;
        int numberOfPayments;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(" Principal amount (Enter a value between 1,000 & 1,000,000) : ");
            principal = input.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000) {
                break;
            }
            System.out.println(" Value is outside of accepted range. Please re-enter a value between 1,000 & 1,000,000. ");
        }

        while (true) {
            System.out.print(" Annual Interest Rate (Enter a value between 1 & 30) : ");
            float annualInterest = input.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENTAGE / ANNUAL_MONTHS;
                break;
            }
            System.out.println(" Value is outside of accepted range. Please re-enter a value between 1 & 30. ");
        }

        while (true) {
            System.out.print(" Time period (in years, between 1 & 30) : ");
            byte years = input.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * ANNUAL_MONTHS;
                break;
            }
            System.out.println(" Value is outside of accepted range. Please re-enter a value between 1 and 30. ");
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println( " Mortgage: " + mortgageFormatted);
    }
}

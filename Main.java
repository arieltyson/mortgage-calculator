import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        final byte ANNUAL_MONTHS = 12;
        final byte PERCENTAGE = 100;

        Scanner input = new Scanner(System.in);

        System.out.println(" Principal amount : ");
        int principal = input.nextInt();

        System.out.println(" Annual Interest Rate : ");
        float annualInterest = input.nextFloat();
        float monthlyInterest = annualInterest / PERCENTAGE / ANNUAL_MONTHS;

        System.out.println(" Period in (years) : ");
        byte years = input.nextByte();
        int numberOfPayments = years * ANNUAL_MONTHS;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println( " Mortgage: " + mortgageFormatted);

    }
}

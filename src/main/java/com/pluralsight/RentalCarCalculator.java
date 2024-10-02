package com.pluralsight;
import java.util.*;

public class RentalCarCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        //Establish KNOWN values, from requirements
        double priceOfCarRentalPerDay = 29.99;
        double priceOfTollTagPerDay = 3.95;
        double priceOfGPSPerDay = 2.95;
        double priceOfRoadsideAssistancePerDay = 3.95;
        float underageSurchargePercentage = 0.30f;
        int underageSurchargeCutoffAge = 25;

        //Establish KNOWN values, from user.
        String pickupDate = PromptForString("When will you pick this up? (Ex. YYYY/MM/DD): ");
        short numberOfDays = PromptForShort("How many days will you need this car?: ");
        boolean needsTollTag = PromptForYesNo("Do you need a Toll Tag?: ");
        boolean needsGPS = PromptForYesNo("Do you need a GPS?: ");
        boolean needsRoadsideAssistance = PromptForYesNo("Do you need Roadside Assistance?: ");
        byte age = PromptForByte("How old are you?: ");


        //Calculate Unknown Values
        double basicCarRentalFee = numberOfDays * priceOfCarRentalPerDay;
        double costOfTollTag = (needsTollTag) ? (numberOfDays * priceOfTollTagPerDay) : 0;
        double costOfGPS = (needsGPS) ? (numberOfDays * priceOfGPSPerDay) : 0;
        double costOfRoadsideAssistance = (needsRoadsideAssistance) ? (numberOfDays * priceOfRoadsideAssistancePerDay) : 0;
        double optionsTotalFee = costOfTollTag + costOfGPS + costOfRoadsideAssistance;
        double underageSurcharge = (age < underageSurchargeCutoffAge) ? basicCarRentalFee * underageSurchargePercentage : 0;
        double totalCost = basicCarRentalFee + optionsTotalFee + underageSurcharge;


        //Display the results
        System.out.printf("Basic Car Rental Fee:   %.2f\n", basicCarRentalFee);
        System.out.printf("Options Fee:            %.2f\n", optionsTotalFee);
        System.out.printf("Underage Surcharge Fee: %.2f\n", underageSurcharge);
        System.out.println("-------------------------------------");
        System.out.printf("TOTAL:                  %.2f\n", totalCost);

        System.out.println(pickupDate);

    }


    public static String PromptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static boolean PromptForYesNo(String prompt) {
        System.out.print(prompt + " ( Y for Yes, N for No ) ?");
        String userinput = scanner.nextLine();

        return (userinput.equalsIgnoreCase("Y") || userinput.equalsIgnoreCase("YES"));

    }

    public static short PromptForShort(String prompt) {
        System.out.print(prompt);
        short userinput = scanner.nextShort();
        scanner.nextLine();
        return userinput;
    }

    public static byte PromptForByte(String prompt) {
        System.out.print(prompt);
        byte userinput = scanner.nextByte();
        return userinput;
    }
}
package TripPlanner;
import java.util.Scanner;

public class TripPlanner {

    public static void main(String[] args) {
    greeting();
    travelTimeAndBudget();
    timeDifference();
    countryArea();
    homeDestinationDistance();
    }

    public static void greeting() {
        //method asks about 'personal data' and 'travel destination'

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String userName = input.nextLine();//getting user's name
        System.out.print("Hello ");
        System.out.print(userName + "! ");
        timeDelayMilliseconds(500);
        System.out.print("Nice to meet you. ");
        timeDelayMilliseconds(500);
        System.out.print("Where are you travelling to? ");
        String destinationPlace = input.nextLine();//getting travel destination
        System.out.print("Great! ");
        timeDelayMilliseconds(500);
        System.out.print(destinationPlace + "! ");
        timeDelayMilliseconds(250);
        System.out.println("That sounds like an amazing journey!");
        timeDelayMilliseconds(1500);
        System.out.println();
    }

    public static void travelTimeAndBudget() {
        //method asks about available 'time' and 'budget' for trip

        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int tripLength = input.nextInt();//getting trip length
        System.out.print("How much money, in USD, ");
        timeDelayMilliseconds(500);
        System.out.print("are you planning to spend on your trip? ");
        double tripBudget = input.nextDouble();//getting trip budget
        System.out.print("What is the currency symbol for your travel destination? ");
        timeDelayMilliseconds(3000);
        System.out.print("(For example CAD for Canadian Dollar) ");
        String moneySymbol = input.next();//getting local currency symbol
        System.out.print("What is the exchange rate between USD and " + moneySymbol + "? ");
        double exchangeRate = input.nextDouble();//getting exchange rate
        System.out.println();

        int lengthInMinutes;
        lengthInMinutes = tripLength * 60 * 60;

        int lengthInHours;
        lengthInHours = tripLength * 60;

        double dailyUsdExpenses;
        dailyUsdExpenses = tripBudget / tripLength;//counting daily budget in USD

        double budgetInLocalCurrency;
        budgetInLocalCurrency = tripBudget * exchangeRate;//counting budget in local currency

        double dailyBudgetInLocalCurrency;
        dailyBudgetInLocalCurrency = budgetInLocalCurrency / tripLength;//counting daily budget in local currency

        timeDelayMilliseconds(500);
        System.out.print("If you are travelling for " + tripLength + " days that is the same as " + lengthInHours);
        timeDelayMilliseconds(500);
        System.out.println(" hours, or " + lengthInMinutes + " minutes.");
        timeDelayMilliseconds(1500);
        System.out.println("In that case...");
        timeDelayMilliseconds(1000);
        System.out.println("Total budget of " + tripBudget + " USD allows for daily expenses as high as " + numberRound(dailyUsdExpenses) + " USD (rounded off).");
        timeDelayMilliseconds(2000);
        System.out.println("In currency of that country that is " + budgetInLocalCurrency + " " + moneySymbol + " in total, and " + numberRound(dailyBudgetInLocalCurrency) + " " + moneySymbol + " (rounded off) daily.");
        System.out.println();

    }

    public static void timeDifference() {
        //method asks about 'timezone difference' between home and destination

        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, ");
        timeDelayMilliseconds(250);
        System.out.print("in hours, ");
        timeDelayMilliseconds(250);
        System.out.print("between your home and your destination? ");
        int timeDifference = input.nextInt();//getting time difference
        int localTimeWhen12pm;
        localTimeWhen12pm = (24 + timeDifference) % 24;//counting local time
        int localTimeWhen12am;
        localTimeWhen12am = 12 + timeDifference;//counting local time

        timeDelayMilliseconds(500);
        System.out.println("It is worth to know that when it is midnight at home it will be " + localTimeWhen12pm + " in your travel destination");
        timeDelayMilliseconds(1500);
        System.out.println("and when it is noon at home it will be " + localTimeWhen12am + " there.");
        System.out.println();
        timeDelayMilliseconds(2500);

    }

    public static void countryArea() {
        //if destination country doesn't use imperial system,
        //method asks about country's area in square kilometers and converts to square miles

        Scanner input = new Scanner(System.in);
        System.out.println("What is the square area of your destination country in km2? ");
        double metricSquareArea = input.nextDouble();
        double imperialSquareArea;
        imperialSquareArea = metricSquareArea * 0.38610;
        System.out.println("In square miles that is " + numberRound(imperialSquareArea) + ". ");
        System.out.println();
        timeDelayMilliseconds(2500);

    }

    public static double numberRound(double numberToRound) {
        //method cleans numbers so they each only have two decimal places
        double stageOne;
        double finalStage;
        stageOne = numberToRound * 100;
        finalStage = (int)stageOne / 100.0;
        return finalStage;
    }

    public static void homeDestinationDistance() {
        //method calculates distance from 'home' to 'destination' using 'Haversine formula'

        timeDelayMilliseconds(500);
        Scanner input = new Scanner(System.in);
        String request = "Please enter in decimal degrees. ";

        System.out.print("What is your home location's latitude? " + request);
        double homeLatitude = input.nextDouble();//getting home latitude
        System.out.print("What is your home locations's longitude? " + request);
        double homeLongitude = input.nextDouble();//getting home longitude

        System.out.print("What is your destinations's latitude? " + request);
        double destinationLatitude = input.nextDouble();//getting destination latitude
        System.out.print("What is your destination's longitude? " + request);
        double destinationLongitude = input.nextDouble();//getting destination longitude

        final int earthRadius = 6371; //setting Earth radius

        double distanceLatitude = Math.toRadians(destinationLatitude - homeLatitude);
        double distanceLongitude = Math.toRadians(destinationLongitude - homeLongitude);

        homeLatitude = Math.toRadians(homeLatitude);
        destinationLatitude = Math.toRadians(destinationLatitude);

        double a = Math.pow(Math.sin(distanceLatitude / 2), 2) + Math.pow(Math.sin(distanceLongitude / 2), 2) * Math.cos(homeLatitude) * Math.cos(destinationLatitude);
        double c = 2 * Math.asin(Math.sqrt(a));
        double finalDistance = earthRadius * c;

        System.out.println("Distance between your home and destination place in kilometers is " + numberRound(finalDistance));

    }

    public static void timeDelayMilliseconds(int howMany) {
        int i = 1;
        if (i == 1) {
            try {
                Thread.sleep(howMany);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

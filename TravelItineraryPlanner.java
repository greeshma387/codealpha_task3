import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelItineraryPlanner {

    static class Destination {
        String name;
        String startDate;
        String endDate;

        public Destination(String name, String startDate, String endDate) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        @Override
        public String toString() {
            return "Destination: " + name + ", Start Date: " + startDate + ", End Date: " + endDate;
        }
    }

    private static List<Destination> itinerary = new ArrayList<>();
    private static double totalBudget = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Travel Itinerary Planner");
            System.out.println("1. Add Destination");
            System.out.println("2. Display Itinerary");
            System.out.println("3. Calculate Budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addDestination(scanner);
                    break;
                case 2:
                    displayItinerary();
                    break;
                case 3:
                    calculateBudget();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using Travel Itinerary Planner.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }

    private static void addDestination(Scanner scanner) {
        System.out.print("Enter Destination Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Start Date (MM/DD/YYYY): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter End Date (MM/DD/YYYY): ");
        String endDate = scanner.nextLine();

        Destination destination = new Destination(name, startDate, endDate);
        itinerary.add(destination);
        System.out.println("Destination added to itinerary.");
    }

    private static void displayItinerary() {
        System.out.println("===== Your Travel Itinerary =====");
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
        System.out.println("===============================");
    }

    private static void calculateBudget() {
        totalBudget = 0;
        for (Destination destination : itinerary) {
            // Mock calculation based on number of days and a fixed daily budget
            String[] start = destination.startDate.split("/");
            String[] end = destination.endDate.split("/");
            int days = daysBetween(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]),
                                   Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));
            double dailyBudget = 100; // Mock daily budget
            double destinationBudget = days * dailyBudget;
            totalBudget += destinationBudget;
        }
        System.out.println("Total Budget for the Trip: $" + totalBudget);
    }

    private static int daysBetween(int month1, int day1, int year1, int month2, int day2, int year2) {
        // Simple method to calculate days between two dates
        int days1 = year1 * 365 + month1 * 30 + day1;
        int days2 = year2 * 365 + month2 * 30 + day2;
        return Math.abs(days2 - days1);
    }
}

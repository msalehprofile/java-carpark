package org.carpark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class UserInteraction {
    private static String userInput;
    private static String selectedVehicle;
    private static boolean gameState = false;
    private static int carsInCarSpaces;
    private static int carsInVanSpaces;
    private static int vansInCarSpaces;
    private static int vansInVanSpaces;
    private static int motorcyclesInVanSpaces;
    private static int motorcyclesInCarSpaces;
    private static int motorcyclesInMotorcycleSpaces;
    private static int totalCarsParked;

    public static String getSelectedVehicle() {
        return selectedVehicle;
    }

    public static boolean isGameState() {
        return gameState;
    }

    public static void welcomeToTheCarPark(int totalSpaces, int carSpaces, int largeSpaces, int motorcycleSpaces, ArrayList<String> usedCarSpaces, ArrayList<String> usedLargeSpaces, ArrayList<String> usedMotorcycleSpaces) {
        System.out.println("\nWelcome to Grand Central Car Park, we have a total of " + totalSpaces + " spaces.");
        entryToAppChoice(totalSpaces, carSpaces, largeSpaces, motorcycleSpaces, usedCarSpaces, usedLargeSpaces, usedMotorcycleSpaces);
    }

    public static void countNumberOfParkedVehicles(ArrayList<String> usedCarSpaces, ArrayList<String> usedLargeSpaces, ArrayList<String> usedMotorcycleSpaces) {
        carsInCarSpaces = Collections.frequency(usedCarSpaces, "car");
        carsInVanSpaces = Collections.frequency(usedLargeSpaces, "car");

        vansInCarSpaces = Collections.frequency(usedCarSpaces, "van");
        vansInVanSpaces = Collections.frequency(usedLargeSpaces, "van");

        motorcyclesInMotorcycleSpaces = Collections.frequency(usedMotorcycleSpaces,"motorcycle" );
        motorcyclesInCarSpaces = Collections.frequency(usedCarSpaces, "motorcycle");
        motorcyclesInVanSpaces = Collections.frequency(usedLargeSpaces, "motorcycle");

        totalCarsParked = carsInVanSpaces + carsInCarSpaces + vansInVanSpaces +vansInCarSpaces + motorcyclesInVanSpaces + motorcyclesInCarSpaces + motorcyclesInMotorcycleSpaces;
    }

    public static void entryToAppChoice(int totalSpaces, int carSpaces, int largeSpaces, int motorcycleSpaces, ArrayList<String> usedCarSpaces, ArrayList<String> usedLargeSpaces, ArrayList<String> usedMotorcycleSpaces) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select what you would like to do:" +
                "\n1. Park a vehicle" +
                "\n2. Show all empty spaces" +
                "\n3. Show total vehicles parked."+
                "\n4. Leave.");
        userInput = scanner.nextLine();

        if (Objects.equals(userInput, "1")) {
            vehicleSelection();
        } else if (Objects.equals(userInput, "2")) {
            System.out.println("\nTotal empty spaces: " + totalSpaces +"." +
                    "\nEmpty Motorcycle spaces: " + motorcycleSpaces+"." +
                    "\nEmpty Small car spaces: " + carSpaces+"." +
                    "\nEmpty Large car/van spaces: " + largeSpaces+".");
            entryToAppChoice(totalSpaces, carSpaces, largeSpaces, motorcycleSpaces, usedCarSpaces, usedLargeSpaces, usedMotorcycleSpaces);
        } else if (Objects.equals(userInput, "3")) {
            countNumberOfParkedVehicles(usedCarSpaces, usedLargeSpaces, usedMotorcycleSpaces);
            System.out.println("\nTotal vehicles parked: " + totalCarsParked+"." +
                    "\nCars in small spaces: "+ carsInCarSpaces+"." +
                    "\nCars in large spaces: "+ carsInVanSpaces+"." + "\n"+
                    "\nVans in small spaces: "+vansInCarSpaces+"." +
                    "\nVans in large spaces: "+vansInVanSpaces+"." + "\n"+
                    "\nMotorcycles in motorcycle spaces: " + motorcyclesInMotorcycleSpaces + "." +
                    "\nMotorcycles in small spaces: " + motorcyclesInCarSpaces + "." +
                    "\nMotorcycles in large spaces: " + motorcyclesInVanSpaces + "." +"\n");

            entryToAppChoice(totalSpaces, carSpaces, largeSpaces, motorcycleSpaces, usedCarSpaces, usedLargeSpaces, usedMotorcycleSpaces);
        } else if (Objects.equals(userInput, "4")) {
            System.out.println("\nSee you again soon!");
            gameState = true;
        } else {
            System.out.println("Sorry, I didn't catch that, please try again.");
            entryToAppChoice(totalSpaces, carSpaces, largeSpaces, motorcycleSpaces, usedCarSpaces, usedLargeSpaces, usedMotorcycleSpaces);
        }
    }

    public static void vehicleSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease select what vehicle you are driving:" +
                "\n1. Car" +
                "\n2. Motorcycle" +
                "\n3. Van" +
                "\n4. Other"
        );
        userInput = scanner.nextLine();

        if(Objects.equals(userInput, "1")) {
            selectedVehicle = "car";
        } else if (Objects.equals(userInput, "2")) {
            selectedVehicle = "motorcycle";
        } else if (Objects.equals(userInput, "3")) {
            selectedVehicle = "van";
        } else if (Objects.equals(userInput, "4")) {
            System.out.println("Sorry, we do not have spaces for your type of vehicle.");
        } else {
            System.out.println("Sorry, I didn't catch that, please try again.");
            vehicleSelection();
        };
    }




}

package org.carpark;


import org.carpark.Classes.Methods;
import org.carpark.Classes.Parkinglot;

import java.util.ArrayList;
import java.util.Objects;

public class Carpark {
    private static int totalSpaces;
    private static int carSpaces;
    private static int largeSpaces;
    private static int motorcycleSpaces;

    static ArrayList<String> usedLargeSpaces = new ArrayList<>();
    static ArrayList<String> usedCarSpaces = new ArrayList<>();
    static ArrayList<String> usedMotorcycleSpaces = new ArrayList<>();

    static Parkinglot parkingLot = new Parkinglot(100, 1, 1, 20);

    public void setUpCarPark() {
        totalSpaces = parkingLot.getTotalSpaces();
        carSpaces = parkingLot.getCarSpaces();
        largeSpaces = parkingLot.getLargeSpaces();
        motorcycleSpaces = parkingLot.getMotorcycleSpaces();

        enterCarPark();
    }

    public void enterCarPark() {

        do {
            UserInteraction.welcomeToTheCarPark(totalSpaces, carSpaces, largeSpaces, motorcycleSpaces, usedCarSpaces, usedLargeSpaces, usedMotorcycleSpaces);
            String selectedVehicle = UserInteraction.getSelectedVehicle();

            checkingSpaces(totalSpaces, carSpaces, largeSpaces, motorcycleSpaces, selectedVehicle);
            motorcycleSpaces = parkingLot.getMotorcycleSpaces();
            totalSpaces = parkingLot.getTotalSpaces();
            carSpaces = parkingLot.getCarSpaces();
            largeSpaces = parkingLot.getLargeSpaces();


//            System.out.println("total: " + totalSpaces);
//
//            System.out.println("motorcycle: " + motorcycleSpaces);
//            System.out.println("motorcycle: " + usedMotorcycleSpaces);
//            System.out.println("car: " + carSpaces);
//            System.out.println("car: " + usedCarSpaces);
//            System.out.println("large: " + largeSpaces);
//            System.out.println("large: " + usedLargeSpaces);

        } while (!UserInteraction.isGameState());
    }

    public static void checkingSpaces(int totalSpaces, int carSpaces, int largeSpaces, int motorcycleSpaces, String vehicles) {
        if( totalSpaces < 0) {
            System.out.println("There are no spaces left, sorry!");
        }
        checkingMotorcycle(carSpaces,largeSpaces,motorcycleSpaces,vehicles);
        checkingCar(carSpaces,largeSpaces,vehicles);
        checkingVan(carSpaces,largeSpaces,vehicles);
    }

    public static void checkingMotorcycle(int carSpaces, int largeSpaces, int motorcycleSpaces, String vehicles) {
        if(Objects.equals(vehicles, "motorcycle")) {
            if(motorcycleSpaces > 0) {
                parkingLot.setMotorcycleSpaces(Methods.reduceOne(motorcycleSpaces));
                parkingLot.setTotalSpaces(Methods.reduceOne(totalSpaces));
                usedMotorcycleSpaces.add("motorcycle");
            } else if (carSpaces > 0) {
                parkingLot.setCarSpaces(Methods.reduceOne(carSpaces));
                parkingLot.setTotalSpaces(Methods.reduceOne(totalSpaces));
                usedCarSpaces.add("car");
            } else if (largeSpaces > 0) {
                parkingLot.setLargeSpaces(Methods.reduceOne(largeSpaces));
                parkingLot.setTotalSpaces(Methods.reduceOne(totalSpaces));
                usedLargeSpaces.add("motorcycle");
            }
        }
    } ;

    public static void checkingCar(int carSpaces, int largeSpaces, String vehicles) {
        if(Objects.equals(vehicles, "car")) {
            if(carSpaces > 0) {
                parkingLot.setCarSpaces(Methods.reduceOne(carSpaces));
                parkingLot.setTotalSpaces(Methods.reduceOne(totalSpaces));
                usedCarSpaces.add("car");
            } else if (largeSpaces > 0) {
                parkingLot.setLargeSpaces(Methods.reduceOne(largeSpaces));
                parkingLot.setTotalSpaces(Methods.reduceOne(totalSpaces));
                usedLargeSpaces.add("car");
            } else {
                System.out.println("Sorry, we do not have space for you.");
            }
        }
    } ;

    public static void checkingVan( int carSpaces, int largeSpaces, String vehicles) {
        if(Objects.equals(vehicles, "van")) {
            if (largeSpaces > 0) {
                parkingLot.setLargeSpaces(Methods.reduceOne(largeSpaces));
                parkingLot.setTotalSpaces(Methods.reduceOne(totalSpaces));
                usedLargeSpaces.add("van");
            } else if(carSpaces > 3) {
                parkingLot.setCarSpaces(Methods.reduceThree(carSpaces));
                parkingLot.setTotalSpaces(Methods.reduceThree(totalSpaces));
                usedCarSpaces.add("van");
            } else {
                System.out.println("Sorry, we do not have space for you.");
            }
        }
    } ;

}

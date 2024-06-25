package org.carpark.Classes;

public class Parkinglot {
    private int totalSpaces;
    private int carSpaces;
    private int largeSpaces;
    private int motorcycleSpaces;

    public Parkinglot(int totalSpaces, int carSpaces, int largeSpaces, int motorcycleSpaces) {
        this.totalSpaces = totalSpaces;
        this.carSpaces = carSpaces;
        this.largeSpaces = largeSpaces;
        this.motorcycleSpaces = motorcycleSpaces;
    }

    public void setMotorcycleSpaces(int motorcycleSpaces) {
        this.motorcycleSpaces = motorcycleSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public void setCarSpaces(int carSpaces) {
        this.carSpaces = carSpaces;
    }

    public void setLargeSpaces(int largeSpaces) {
        this.largeSpaces = largeSpaces;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public int getCarSpaces() {
        return carSpaces;
    }

    public int getLargeSpaces() {
        return largeSpaces;
    }

    public int getMotorcycleSpaces() {
        return motorcycleSpaces;
    }
}

package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehiclePlane extends VehicleAbstract {
    public int speed;

    public VehiclePlane(String brand, String model, int kilometers) {
        super(brand, model);
        this.speed = kilometers;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public String getModel() {
        return model;
    }

    @Override
    public String getDescription() {
        return brand + ", " + model + ", " + speed;
    }

    public String getBrand() {
        return brand;
    }
}
package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehiclesCar extends VehicleAbstract {
    public int kilometers;

    public VehiclesCar(String brand, String model, int kilometers) {
        super(brand, model);
        this.kilometers= kilometers;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }



    public String getModel() {
        return model;
    }

    @Override
    public String getDescription() {
        return brand + ", " + model + ", " + kilometers;
    }

    public String getBrand() {
        return brand;
    }
}
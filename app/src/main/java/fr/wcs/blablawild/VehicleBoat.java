package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */


class  VehicleBoat extends VehicleAbstract {
    public int hours;

    public VehicleBoat(String brand, String model, int hours) {
        super(brand, model);
        this.hours=hours;
    }

    @Override
    public String getDescription() {
        return brand + ", " + model + ", " + hours;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
}

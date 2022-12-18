package transport;

public abstract class Transport {
    private final String brand;
    private final String model;
    private Float engineVolume;
    private final String driverLicense;

    private <T> boolean isNotEmpty(T checker){
        return checker == null || checker.equals("");
    }

    public Transport(String brand, String model, Float engineVolume, String driverLicense) {
        this.driverLicense = driverLicense;

        if(isNotEmpty(brand)) {
            this.brand = "default";
        }
        else{
            this.brand = brand;
       }

        if(isNotEmpty(model)) {
            this.model = "default";
        }
        else {
            this.model = model;
        }

        setEngineVolume(engineVolume);
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Float getEngineVolume() {
        return engineVolume;
    }

    public void startMoving(){
        System.out.println("движение начато");
    }

    public void endMoving(){
        System.out.println("движение закончено");
    }

    public void setEngineVolume(Float engineVolume) {
        if(engineVolume == null || engineVolume < 0) {
            this.engineVolume = 1.5f;
        }
        else {
            this.engineVolume = engineVolume;
        }
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                ", driverLicense='" + driverLicense + '\'' +
                '}';
    }

    public abstract void printType();

    public abstract boolean passDiagnostics();
}
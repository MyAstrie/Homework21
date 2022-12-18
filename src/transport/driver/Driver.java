package transport.driver;

import transport.customException.InvalidDriverLicense;
import transport.*;

public class Driver <T extends Transport>{

    private String fullName;
    private final String driverLicense;
    private Integer experience;

    private <V> boolean isNull(V checkObject){
        return checkObject == null || checkObject.equals("");
    }

    public Driver(String fullName, String driverLicense, Integer experience) throws InvalidDriverLicense {
        if(isNull(driverLicense)) {
            throw new InvalidDriverLicense("Необходимо указать тип прав!");
        }

        this.driverLicense = driverLicense;

        setExperience(experience);
        setFullName(fullName);
    }

    public void setFullName(String fullName) {
        if(!isNull(fullName))
            this.fullName = fullName;
    }

    public void setExperience(Integer experience) {
        if(!isNull(experience))
            this.experience = experience;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public Integer getExperience() {
        return experience;
    }

    public void startMoving(T transport){
        System.out.println("Водитель начал движение на "+ transport.getBrand());
    }

    public void stopMoving(T transport){
        System.out.println("Водитель закончил движение на " + transport.getBrand());
    }

    public void refueling(T transport){
        System.out.println("Водитель заправил " + transport.getBrand());
    }
}

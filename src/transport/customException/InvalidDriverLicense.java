package transport.customException;

public class InvalidDriverLicense extends Exception{
    public InvalidDriverLicense(String driverLicense ){
        super(driverLicense);
    }
}

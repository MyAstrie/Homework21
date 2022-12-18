package transport.driver;
import transport.customException.InvalidDriverLicense;
import transport.PassengerCar;

public class ATypeDriver extends Driver<PassengerCar> {

    public ATypeDriver(String fullName, Integer experience) throws InvalidDriverLicense {
        super(fullName, "A", experience);
    }
}

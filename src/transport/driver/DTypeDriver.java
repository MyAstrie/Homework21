package transport.driver;
import transport.customException.InvalidDriverLicense;
import transport.Bus;

public class DTypeDriver extends Driver<Bus>{

    public DTypeDriver(String fullName, Integer experience) throws InvalidDriverLicense {
        super(fullName, "D", experience);
    }
}

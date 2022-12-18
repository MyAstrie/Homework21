package transport.sponsor;

import transport.*;

import java.util.ArrayList;
import java.util.List;

public class Sponsor {

    private final List<Transport> sponsoredCars;
    private String sponsorName;
    private Double amountOfSupport;

    public Sponsor (String sponsorName, Double amountOfSupport) {

        sponsoredCars = new ArrayList<>();

        if(sponsorName != null && !sponsorName.isEmpty()
        && amountOfSupport > 0 && !amountOfSupport.isNaN()){
            this.sponsorName = sponsorName;
            this.amountOfSupport = amountOfSupport;
        }
    }

    public Sponsor (Transport car, String sponsorName, Double amountOfSupport) {

        sponsoredCars = new ArrayList<>();

        if(sponsorName != null && !sponsorName.isEmpty()
        && amountOfSupport > 0 && !amountOfSupport.isNaN()
        && car != null){
            sponsoredCars.add(car);
            this.sponsorName = sponsorName;
            this.amountOfSupport = amountOfSupport;
        }
    }

    public void addTransport(Transport car){
        sponsoredCars.add(car);
    }

    public void removeTransport(Transport car){
        sponsoredCars.remove(car);
    }

    public void sponsoredRoute(){
        System.out.println("Спонсор " + sponsorName + " спонсирует заезд");
    }

    public List<Transport> getSponsoredCars() {
        return sponsoredCars;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public Double getAmountOfSupport() {
        return amountOfSupport;
    }

    public void setSponsorName(String sponsorName) {
        if(sponsorName != null && !sponsorName.isEmpty()) {
            this.sponsorName = sponsorName;
        }
    }

    public void setAmountOfSupport(Double amountOfSupport) {
        if(amountOfSupport > 0 && !amountOfSupport.isNaN()) {
            this.amountOfSupport = amountOfSupport;
        }
    }
}

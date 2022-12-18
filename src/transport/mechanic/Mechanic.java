package transport.mechanic;

import transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class Mechanic<T extends Transport> {

    private String fullName;
    private String workCompany;
    private final List<T> transports;

    public Mechanic(String fullName, String workCompany) {
        this.transports = new ArrayList<>();

        if(fullName != null && !fullName.isEmpty()
        && workCompany != null && !workCompany.isEmpty()) {
            this.fullName = fullName;
            this.workCompany = workCompany;
        }
    }

    public Mechanic(String fullName, String workCompany, T transports) {
        this.transports = new ArrayList<>();

        if(fullName != null && !fullName.isEmpty()
        && workCompany != null && !workCompany.isEmpty()
        && transports != null) {
            this.transports.add(transports);
            this.fullName = fullName;
            this.workCompany = workCompany;
        }
    }

    public void addTransports(T transports){
        this.transports.add(transports);
    }

    public void removeTransports(T transports){
        this.transports.remove(transports);
    }

    public  void doMaintains(){
        for(T car : transports){
            car.passDiagnostics();
        }
    }

    public void cleanTransports(){
        System.out.println("механик чистит транспорт ");
    }

    public String getFullName() {
        return fullName;
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public List<T> getTransports() {
        return transports;
    }

    public void setFullName(String fullName) {
        if(fullName != null && !fullName.isEmpty()) {
            this.fullName = fullName;
        }
    }

    public void setWorkCompany(String workCompany) {
        if(workCompany != null && !workCompany.isEmpty()) {
            this.workCompany = workCompany;
        }
    }
}

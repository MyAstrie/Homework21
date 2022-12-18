package transport.serviceStation;

import transport.Transport;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation <T extends Transport> {
    Queue<T> queue;

    public ServiceStation() {
        this.queue = new LinkedList<>();
    }

    public void addCarToTheQueue(T transport){
        this.queue.add(transport);
    }

    public void conductTechnicalInspection(){
        for(var transport : this.queue){
            if(transport.passDiagnostics()){
                System.out.println("Удачно проведена инспекция у авто" + transport.getBrand());
            } else {
                System.out.println("Не удачно проведена инспекция у авто" + transport.getBrand());
            }
        }
    }
}

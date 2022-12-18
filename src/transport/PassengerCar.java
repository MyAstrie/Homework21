package transport;

import java.util.concurrent.ThreadLocalRandom;

public class PassengerCar extends Transport implements Competing{

    private PassengerCarBodyType bodyType;

    public enum PassengerCarBodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        STATION_WAGON("Универсал"),
        OFF_ROAD("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP_TRUCK("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private String bodyType;

        public String getBodyType() {
            return bodyType;
        }

        PassengerCarBodyType(String bodyType) {
            this.setBodyType(bodyType);
        }

        public static PassengerCarBodyType findByBodyType(String value) {
            for (PassengerCarBodyType bodyType : values()) {
                if (bodyType.getBodyType().equalsIgnoreCase(value)) {
                    return bodyType;
                }
            }
            return null;
        }

        public void setBodyType(String bodyType) {
            this.bodyType = bodyType;
        }
        
        @Override
        public String toString() {
            return "PassengerCarBodyType{" +
                    "bodyType='" + bodyType + '\'' +
                    '}';
        }
    }

    public PassengerCar(String brand, String model, Float engineVolume, String bodyType) {
        super(brand, model, engineVolume, "A");
        this.bodyType = PassengerCarBodyType.findByBodyType(bodyType);
    }

    public PassengerCar(String brand, String model, Float engineVolume) {
        super(brand, model, engineVolume, "A");
    }

    public void setBodyType(String bodyType) {
        this.bodyType = PassengerCarBodyType.findByBodyType(bodyType);
    }

    @Override
    public void pitStop() {
        System.out.println("Легкий автомобиль на питстопе");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучший круг легкового автомобиля");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость легкового автомобиля");
    }

    @Override
    public String toString() {
        return "PassengerCar{" + super.toString() +
                "bodyType=" + bodyType +
                '}';
    }

    public void printType(){
        if(bodyType == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(bodyType);
        }
    }

    @Override
    public boolean passDiagnostics() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100+ 1);
        return randomNum >= 2;
    }
}

package transport;

import java.util.concurrent.ThreadLocalRandom;

public class FreightCar extends Transport implements Competing{

    private LiftingCapacity liftingCapacity;

    public enum LiftingCapacity {
        N1(0, 3.5), N2(3.5, 12), N3(12);

        private double minWeight;
        private double maxWeight;

        LiftingCapacity(double minWeight, double maxWeight){
            if(minWeight >= 0 && maxWeight > 0){
                this.minWeight = minWeight;
                this.maxWeight = maxWeight;
            }
        }

        LiftingCapacity(double minWeight){
            if(minWeight > 0){
                this.minWeight = minWeight;
            }
        }

        public static LiftingCapacity findByWeight(Double weight) {
            for (LiftingCapacity liftingCapacity : values()) {
                if(weight > 0 && weight < 3.5) {
                    return N1;
                } else if ( weight >= 3.5 && weight < 12) {
                    return N2;
                } else if (weight >= 12) {
                    return N3;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            if(minWeight != 12 ) {
                return "LiftingCapacity{" +
                        "minWeight='" + minWeight + '\'' +
                        ", maxWeight='" + maxWeight + '\'' +
                        '}';
            }
            else {
                return "LiftingCapacity{" +
                        "minWeight='" + minWeight + '\'' +
                        '}';
            }
        }
    }

    public FreightCar(String brand, String model, Float engineVolume, Double weight) {
        super(brand, model, engineVolume, "C");
        this.liftingCapacity = LiftingCapacity.findByWeight(weight);
    }

    public FreightCar(String brand, String model, Float engineVolume) {
        super(brand, model, engineVolume, "C");
    }

    public void setLiftingCapacity(Double weight) {
        this.liftingCapacity = LiftingCapacity.findByWeight(weight);
    }

    @Override
    public void pitStop() {
        System.out.println("Тяжелый автомобиль на питстопе");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучший круг тяжелого автомобиля");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость тяжелого автомобиля");
    }

    @Override
    public String toString() {
        return "FreightCar{" + super.toString() +
                "liftingCapacity=" + liftingCapacity +
                '}';
    }

    public void printType(){
        if(liftingCapacity == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(liftingCapacity);
        }
    }

    @Override
    public boolean passDiagnostics() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100+ 1);
        return randomNum >= 2;
    }
}
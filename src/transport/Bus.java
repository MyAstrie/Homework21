package transport;

public class Bus extends Transport implements Competing{

    private Capacity capacity;

    public enum Capacity {
        ESPECIALLY_SMALL(0, 10),
        SMALL(11, 25),
        MEDIUM(26, 40, 50),
        LARGE(51, 60, 80),
        HUGE(81, 100, 120);

        private int minCapacity;
        private int mediumCapacity;
        private int maxCapacity;

        Capacity(int minCapacity, int maxCapacity){
            if(minCapacity >= 0 && maxCapacity > 0){
                this.minCapacity = minCapacity;
                this.maxCapacity = maxCapacity;
            }
        }

        Capacity(int minCapacity, int mediumCapacity, int maxCapacity){
            if(minCapacity >= 0 && mediumCapacity > 0 && maxCapacity > 0){
                this.minCapacity = minCapacity;
                this.mediumCapacity = mediumCapacity;
                this.maxCapacity = maxCapacity;
            }
        }

        public static Capacity findBySeatsNumbers(Integer seatsNumber) {
            for (Capacity capacity : values()) {
                if (seatsNumber > 0 && seatsNumber  <= 10){
                    return ESPECIALLY_SMALL;
                } else if (seatsNumber > 10 && seatsNumber <= 25) {
                    return SMALL;
                } else if (seatsNumber > 25 && seatsNumber <= 50) {
                    return MEDIUM;
                } else if( seatsNumber > 50 && seatsNumber <= 80) {
                    return LARGE;
                } else if (seatsNumber > 80 && seatsNumber <= 120) {
                    return HUGE;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            if(mediumCapacity != 0) {
                return "LiftingCapacity{" +
                        "minCapacity='" + minCapacity + '\'' +
                        ", mediumCapacity='" + mediumCapacity + '\'' +
                        ", maxCapacity='" + maxCapacity + '\'' +
                        '}';
            } else {
                return "LiftingCapacity{" +
                        "minCapacity='" + minCapacity + '\'' +
                        ", maxCapacity='" + maxCapacity + '\'' +
                        '}';
            }
        }
    }

    public Bus(String brand, String model, Float engineVolume, int seatsNumber) {
        super(brand, model, engineVolume, "D");
        this.capacity = Capacity.findBySeatsNumbers(seatsNumber);
    }

    public Bus(String brand, String model, Float engineVolume) {
        super(brand, model, engineVolume, "D");
    }

    public void setCapacity(int seatsNumbers) {
        this.capacity = Capacity.findBySeatsNumbers(seatsNumbers);
    }

    @Override
    public void pitStop() {
        System.out.println("Автобус на питстопе");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучший круг автобуса");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость автобуса");
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() +
                "capacity=" + capacity +
                '}';
    }

    public void printType(){
        if(capacity == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(capacity);
        }
    }

    @Override
    public boolean passDiagnostics() {
        return false;
    }
}
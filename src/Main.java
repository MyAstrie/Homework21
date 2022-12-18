import goverment.*;
import transport.*;
import transport.customException.InvalidDriverLicense;
import transport.driver.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void hw2Task2(){
        List<Integer> list = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(1001));
        }

        System.out.println("Лист до удаления : "+list);

        list.removeIf(i-> i % 2 == 1);

        System.out.println("Лист после удаления : "+list);
    }

    public static void hw3Task1() throws InvalidDriverLicense {
        Bus firstBus = new Bus("ЛиАЗ", "4292",202f);
        Bus secondBus = new Bus("СитиРитм", "5270GH",220f);
        Bus thirdBus = new Bus("НефАЗ", "43101/43114",270f);
        Bus fourthBus = new Bus("Серпантин", "10",300f);

        PassengerCar firstPassengerCar = new PassengerCar("Kia", "Rio",42.2f);
        PassengerCar secondPassengerCar = new PassengerCar("Chevrolet", "Lanos",60.5f);
        PassengerCar thirdPassengerCar = new PassengerCar("Daewoo", "Matiz",60.2f);
        PassengerCar fourthPassengerCar = new PassengerCar("Opel", "Manta",70f);

        FreightCar firstFreightCar = new FreightCar("Тонар", "4292",610f);
        FreightCar seconFreightCar = new FreightCar("БелАЗ", "75320",4360f);
        FreightCar thirdFreightCar = new FreightCar("MAN", "TGX",280f);
        FreightCar fourthFreightCar = new FreightCar("Hyundai", "Xcient",320f);

        ATypeDriver firstCarDriver = new ATypeDriver("Artiom Evgeneevich", 20);
        DTypeDriver secondCarDriver = new DTypeDriver("Dina Grach", 10);
        DTypeDriver thirdCarDriver = new DTypeDriver("Ivan Ivanov", 2);
        DTypeDriver fourthCarDriver = new DTypeDriver("Gleb Ivanov", 7);
        ATypeDriver fifthCarDriver = new ATypeDriver("Gustav Irod", 7);

        HashSet<Driver> drivers = new HashSet<>();
        drivers.add(fifthCarDriver);
        drivers.add(firstCarDriver);
        drivers.add(secondCarDriver);
        drivers.add(thirdCarDriver);
        drivers.add(fourthCarDriver);

        HashSet<Transport> transports = new HashSet<>();
        transports.add(firstBus);
        transports.add(secondBus);
        transports.add(thirdBus);
        transports.add(fourthBus);
        transports.add(firstPassengerCar);
        transports.add(secondPassengerCar);
        transports.add(thirdPassengerCar);
        transports.add(fourthPassengerCar);
        transports.add(firstFreightCar);
        transports.add(seconFreightCar);
        transports.add(thirdFreightCar);
        transports.add(fourthFreightCar);

        transports.add(fourthFreightCar);
        transports.add(fourthPassengerCar);
        transports.add(secondPassengerCar);
        transports.add(firstPassengerCar);
        transports.add(firstBus);

        System.out.println("Names in hashset with foreach:");
        for (Transport vehicles : transports) {
            System.out.println(vehicles.getBrand() + " " + vehicles.getModel());
        }

        // Коллекция без повторов хэшсет -> Он содержит уникальные предметы и в нем не будет одинаковых элементров
        // Спонсоров как и механков можно добавить также с помощью хешсета и тогда улсовие:
        // "Выбрана коллекция, которая удовлетворяет условиям: в списке спонсоров нет повторов." будет выполнено
    }

    public static void hw3Task2(){
        ArrayList<String> studentTasks2 = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < 15; i++){
            boolean isSameNumbers = true;
            while (isSameNumbers) {
                int firstNumber = random.nextInt(10);
                int secondNumber = random.nextInt(10);
                String example = String.format("%d*%d", firstNumber, secondNumber);
                isSameNumbers = studentTasks2.stream().anyMatch(r-> r.charAt(0) == example.charAt(0) && r.charAt(2) == example.charAt(2)
                                                                 || r.charAt(0) == example.charAt(2) && r.charAt(2) == example.charAt(0));
                if(!isSameNumbers)
                    studentTasks2.add(example);
                //else{
                //    System.out.println(example);
                //}
            }
        }

        System.out.println("---------");
        for(var students : studentTasks2){
            System.out.println(students);
        }
    }

    public static void hw3Task3(){
        Passport ivan1 = new Passport("123456", "Иван", "Витязь", 2001, 6, 2);
        Passport ivan2 = new Passport("123456", "неИван", "Горин", 2000, 12, 2);

        PassportOffice<Passport> po = new PassportOffice<>();
        po.add(ivan1);
        po.add(ivan2);

        Passport kolya = new Passport("123456", "Коля", "Фисташка", 2000, 12, 2);
        po.add(kolya);

        Passport dima = new Passport("231234", "Дима", "Ковалев", 2002, 8, 3);
        po.add(dima);

        var retPass1 = po.returnedPassport("123422");
        var retPass2 = po.returnedPassport("123456");

        System.out.println(retPass1);
        System.out.println(retPass2);

        System.out.println("---------");
        for(Passport p : po){
            System.out.println(p);
        }
    }

    private static void process(Collection<BigInteger> firstCollection, List<BigInteger> list) {
        long startTime = System.currentTimeMillis();

        if (firstCollection.containsAll(list)) {
            System.out.println("Первая коллекция содержит все элементы списка");
        } else {
            System.out.println("Некоторые (или все) элементы из списка отсутствуют в первой коллекции");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }

    public static void hw3Task4(){
        ArrayList<BigInteger> list = new ArrayList<>();
        for (long i = 0; i < 10000000L; i++) {
            list.add(BigInteger.valueOf((long) (Math.random() * 100L)));
        }
        process(list, list);

        System.out.println("----------");

        //LinkedList create 10000000000 random items
        LinkedList<BigInteger> linkedList = new LinkedList<>();
        for (long i = 0; i < 10000000L; i++) {
            linkedList.add(BigInteger.valueOf((long) (Math.random() * 100L)));
        }
        process(linkedList, list);

        System.out.println("----------");

        HashSet<BigInteger> set = new HashSet<>();
        for (long i = 0; i < 10000000L; i++) {
            set.add(BigInteger.valueOf((long) (Math.random() * 100L)));
        }
        process(set, list);

        System.out.println("----------");

        // Примерные данные составляют:
        // ArrayList - 5340 milliseconds
        // LinkedList - 5949 milliseconds
        // HashSet - 363 milliseconds

        // Такая разница происходит из-за того, что
        // HashSet дает гораздо лучшую производительность (O(n) по сравнению с O(n^2) для списка),
        // потому что нахождение в наборе (операция contains) является самой целью HashSet.
        // Из-за этого для данного метода быстрее исользовать HashSet, так как
        // contains для HashSet - O(1), А для списка O(n)
    }

    public static void main(String[] args) throws InvalidDriverLicense {
        //hw2Task2();
        //hw3Task1();
        //hw3Task2();
        //hw3Task3();
        hw3Task4();
    }
}
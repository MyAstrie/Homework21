package goverment;

import java.util.HashSet;

public class PassportOffice<E> extends HashSet<E> {

    public PassportOffice() {}

    private boolean isPassport(E passport){
        var temp_passport = (Passport) passport;
        return super.stream().anyMatch(x-> {
            var temp_x = (Passport) x;
            return  temp_x.getNumber().equals(temp_passport.getNumber());
        });
    }

    private Passport returnedPassport(E passport){
        var temp_passport = (Passport) passport;
        return (Passport) super.stream().filter(x-> {
            var temp_x = (Passport) x;
            return temp_x.getNumber().equals(temp_passport.getNumber());
        }).findFirst().orElse(null);
    }

    public Passport returnedPassport(String number){
        return (Passport) super.stream().filter(x-> {
            var temp_x = (Passport) x;
            return temp_x.getNumber().equals(number);
        }).findFirst().orElse(null);
    }

    @Override
    public boolean add(E e) {
        if(isPassport(e)){
            var sameNumberPassport = returnedPassport(e);
            //System.out.println("Добавление : " + e);
            //System.out.println("Удаление: " + sameNumberPassport);
            super.remove(sameNumberPassport);
        }
        return super.add(e);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }
}

package goverment;

import java.time.LocalDate;

public class Passport {
    private String number;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;

    public Passport(String number, String firstName, String middleName, String lastName, int year, int month, int day) {
        setNumber(number);
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        this.birthDate = LocalDate.of(year, month, day);
    }

    public Passport(String number, String firstName, String middleName, int year, int month, int day) {
        setNumber(number);
        setFirstName(firstName);
        setMiddleName(middleName);
        this.birthDate = LocalDate.of(year, month, day);
    }

    private void setNumber(String number) {
        if(!number.matches("^[0-9]{6}$")) {
            throw new IllegalArgumentException("Паспортные данные не соответсвуют");
        }

        this.number = number;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("Фамилия не соответсвует");
        }

        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        if(middleName == null || middleName.isEmpty()){
            throw new IllegalArgumentException("Фамилия не соответсвует");
        }

        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Фамилия не соответсвует");
        }

        this.lastName = lastName;
    }

    public void setBirthDate(int year, int month, int day) {
        this.birthDate = LocalDate.of(year, month, day);
    }

    public String getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number='" + number + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

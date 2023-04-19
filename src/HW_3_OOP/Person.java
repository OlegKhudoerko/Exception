package HW_3_OOP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final LocalDate birthDate;
    private final long phoneNumber;
    private final char gender;

    public Person(String surname, String name, String patronymic, LocalDate birthDate, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static Person fromString(String input) throws IllegalArgumentException {
        String[] parts = input.split(" ");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Ошибка: неверное количество полей");
        }
        String surname = parts[0];
        String name = parts[1];
        String patronymic = parts[2];
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка: неверный формат даты рождения");
        }
        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(parts[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка: неверный формат номера телефона");
        }
        char gender = parts[5].charAt(0);
        if (gender != 'f' && gender != 'm') {
            throw new IllegalArgumentException("Ошибка: неверный формат пола");
        }
        return new Person(surname, name, patronymic, birthDate, phoneNumber, gender);
    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    public String getFormattedBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String getFormattedPhoneNumber() {
        return String.format("%011d", phoneNumber);
    }

    public void writeToFile() throws IOException {
        String fileName = surname + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(getFullName() + " " + getFormattedBirthDate() + " " + getFormattedPhoneNumber() + " " + gender + "\n");
        writer.close();
    }
}
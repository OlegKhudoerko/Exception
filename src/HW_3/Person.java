package HW_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Person {

    private static final int REQUIRED_FIELDS_COUNT = 6;

    private static String lastName = null;
    private static String firstName;
    private static String middleName;
    private static LocalDate birthDate;
    private static long phoneNumber;
    private static char gender;

    public Person(
            String lastName,
            String firstName,
            String middleName,
            LocalDate birthDate,
            long phoneNumber,
            char gender) {

        Person.lastName = lastName;
        Person.firstName = firstName;
        Person.middleName = middleName;
        Person.birthDate = birthDate;
        Person.phoneNumber = phoneNumber;
        Person.gender = gender;
    }

    public static void person() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean err = true;
            String[] fields;
            System.out.println("\nВведите данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол");
            System.out.println("(Для выхода нажмите Enter)");
            String input = scanner.nextLine();
            fields = input.split(" ");

            if (Objects.equals(fields[0], "")) {
                System.out.println("Выход");
                return;
            }
            if (fields.length != REQUIRED_FIELDS_COUNT) {
                System.err.println("Ошибка: неверное количество полей");
                err = false;
            }
            if (err) {
                try {
                    if (!fields[0].matches("^[a-zA-Zа-яА-Я-]+$")) {
                        throw new Exception("Ошибка: неверный формат фамилии");
                    }
                    if (!fields[1].matches("^[a-zA-Zа-яА-Я-]+$")) {
                        throw new Exception("Ошибка: неверный формат имени");
                    }
                    if (!fields[2].matches("^[a-zA-Zа-яА-Я-]+$")) {
                        throw new Exception("Ошибка: неверный формат отчества");
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    err = false;
                }
                lastName = fields[0];
                firstName = fields[1];
                middleName = fields[2];
            }
            if (err) {
                birthDate = null;
                try {
                    birthDate = LocalDate.parse(fields[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                } catch (Exception e) {
                    System.err.println("Ошибка: неверный формат даты рождения");
                    err = false;
                }
            }
            if (err) {
                phoneNumber = 0;
                try {
                    if (!fields[4].matches("\\d{1,15}")) {
                        throw new NumberFormatException("Ошибка: неверный формат номера телефона");
                    } else {
                        phoneNumber = Long.parseLong(fields[4]);
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                    err = false;
                }
            }
            if (err) {
                gender = 0;
                if (fields[5].length() != 1 || !(fields[5].equals("f") || fields[5].equals("m"))) {
                    System.err.println("Ошибка: неверный формат пола");
                    err = false;
                } else {
                    gender = fields[5].charAt(0);
                }
            }
            if (err) {
                Person userData = new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                try {
                    userData.writeToFile();
                } catch (IOException e) {
                    System.out.println("Произошла ошибка при записи в файл");
                    e.printStackTrace();
                }
            }

        }

    }

    private void writeToFile() throws IOException {
        String fileName = lastName + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        String line = (
                lastName + " " + firstName + " " + middleName + " " +
                        birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " +
                        phoneNumber + " " + gender + "\n"
        );

        writer.write(line);
        writer.close();
        System.out.printf("Успешно, в файл %s записана строка \n %s", fileName, line);
    }
}

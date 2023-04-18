package HW_3;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final int REQUIRED_FIELDS_COUNT = 6;

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final LocalDate birthDate;
    private final long phoneNumber;
    private final char gender;

    public Main(
                String lastName,
                String firstName,
                String middleName,
                LocalDate birthDate,
                long phoneNumber,
                char gender) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine();
        String[] fields = input.split(" ");

        if (fields.length != REQUIRED_FIELDS_COUNT) {
            System.err.println("Ошибка: неверное количество полей");
            return;
        }

        try{
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
            return;
        }
        String  lastName = fields[0];
        String firstName = fields[1];
        String middleName = fields[2];

        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(fields[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            System.err.println("Ошибка: неверный формат даты рождения");
            return;
        }

        try {
            if (!fields[4].matches("\\d{1,15}")) {
                throw new NumberFormatException("Ошибка: неверный формат номера телефона");
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return;
        }

        long phoneNumber;
        phoneNumber = Long.parseLong(fields[4]);

        char gender;
        if (fields[5].length() != 1 || !(fields[5].equals("f") || fields[5].equals("m"))) {
            System.err.println("Ошибка: неверный формат пола");
            return;
        } else {
            gender = fields[5].charAt(0);
        }

        Main userData = new Main(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        try {
            userData.writeToFile();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл");
            e.printStackTrace();
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


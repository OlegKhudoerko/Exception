package HW_3_OOP;

import java.io.IOException;
import java.util.Scanner;

public class InputData {

    public static void inputDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            try {
                Person person = Person.fromString(input);
                person.writeToFile();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

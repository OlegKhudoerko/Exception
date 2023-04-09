package HW_2;

import java.util.Scanner;

public class Example_4 {
    public static void main(String[] args) {

        System.out.println("Вы ввели:\n" + inputLine());
    }

    public static String inputLine() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scan.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустую строку вводить нельзя!!!");
        }
        scan.close();
        return input;

    }
}

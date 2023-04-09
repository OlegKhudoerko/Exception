package HW_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example_1 {

    public static void main(String[] args) {

        float fNum = inputFloat();
        System.out.println("Ваше дробное число: " + fNum);
    }

    public static float inputFloat() {

        float input;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите дробное число: "); // Разделитель запятая между целой и дробной части!
            input = scan.nextFloat();
            if (input%1 ==0){
                System.out.println("Число целое, не дробное!\nПовторите ввод: ");
                return inputFloat();
            }
        } catch (InputMismatchException e) {
            System.out.println("Не корретное значение!\nПовторите ввод: ");
            return inputFloat();
        }
        return input;
    }
}

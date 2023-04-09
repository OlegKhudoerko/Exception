package HW_2;

import java.util.Arrays;

public class Example_3 {
    public static void main(String[] args) {

        int a = 90;
        int b = 3;
        int[] abc = new int[]{1, 2};
        printSum(23, 234);

        try {
            System.out.println(a / b);
            abc[3] = 9;
            System.out.println(Arrays.toString(abc));
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}

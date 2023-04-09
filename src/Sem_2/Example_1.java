package Sem_2;

public class Example_1 {
    public static void main(String[] args) {

    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        try {

            for (String[] strings : arr) {
                for (int j = 0; j < 5; j++) {
                    try {
                        int val = Integer.parseInt((strings[j]));
                        sum += val;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Выход за пределы массива");
                    } catch (NumberFormatException e) {
                        System.out.println("Не валидные данные");
                    }
                }
            }
            return sum;
        } catch (NullPointerException e) {
            System.out.println("Переданный масив имеет значение Null");
        }
        return 0;
    }
}

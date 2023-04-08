package HW_1;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subArr(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{7, 6, 5, 4, 3, 2, 1})));

        System.out.println(Arrays.toString(divArr(
                new int[]{10, 20, 30, 40, 50, 60, 70},
                new int[]{7, 6, 5, 4, 3, 2, 1})));

        // Первый метод выброса в исключение - пустой массив:
        System.out.println(Arrays.toString(divArr(
                null, new int[]{7, 0, 5, 4, 3, 2, 1})));

        // Второй метод выброса в исключение - массивы разной длины:
        System.out.println(Arrays.toString(divArr(
                new int[]{10, 20, 30, 40, 50},
                new int[]{7, 6, 5, 0, 3, 2, 1})));

        // Третий метод выброса в исключение - деление на ноль:
        System.out.println(Arrays.toString(divArr(
                new int[]{10, 20, 30, 40, 50, 60, 70},
                new int[]{7, 6, 5, 0, 3, 2, 1})));

    }

    public static int[] subArr(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        errorHandler(arr1, arr2);
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static int[] divArr(int[] arr1, int[] arr2) {
        errorHandler(arr1, arr2);
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            errorHandler(arr2, i);
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }

    private static void errorHandler(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Один из массивов равен null");
        }
        if (arr1.length != arr2.length) {
            throw new RuntimeException(String.format(
                    "Массивы разной длины:  %d не равно %d", arr1.length, arr2.length));
        }
    }

    private static void errorHandler(int[] arr2, int index) {
        if (arr2[index] == 0) {
            throw new RuntimeException(String.format(
                    "%d элемент 2-го массива имеет значение '0', на 0 делить нельзя!", index + 1));
        }
    }
}

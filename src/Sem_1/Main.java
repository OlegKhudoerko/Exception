package Sem_1;

// Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
// Если длина массива меньше некоторого заданного минимума, метод
// возвращает -1, в качестве кода ошибки, иначе - длину массива.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
               int[][] array = new int[][]{
                       {1, 0, 1, 1},
                       {0, 1, 1, 1},
                       {1, 1, 1, 1},
                       {1, 1, 1, 1},
                       {1, 1, 1, 1}
               };
//        int num = 8;
//        System.out.println(meArg(array, num));
//        System.out.println(newArr(new int[]{1, 2, 3}, num));
//        System.out.println(newArr(array, num));
//        System.out.println(newArr(null, num));
//        System.out.println(newArr(array, -4));
//        System.out.println(newArr(array, 8));

        System.out.println(Arrays.toString(sumArr(
                new int[]{1,2,3,3,4,5,6,7},
                new int[]{7,6,5,4,3,2,1})));
        //  System.out.println(sumBinArr(array));
    }


    private static int meArg(int[] array, int num) {
        if (array.length < num) {
            return -1;
        } else {
            return array.length;
        }
    }

    //    Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
//    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
//    если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
//    если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//    если вместо массива пришел null, метод вернет -3
//    придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
//    Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод
//    запросит искомое число у пользователя, вызовет первый, обработает возвращенное значение и покажет
//    читаемый результат пользователю. Например, если вернулся -2, пользователю выведется сообщение:
//    “Искомый элемент не найден”.
//


//    Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//    Необходимо посчитать и вернуть сумму элементов этого массива.
//    При этом накладываем на метод 2 ограничения: метод может работать только с квадратными
//    массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
//    Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.

    public static int newArr(int[] array, int num) {
        if (array == null) {
            return -3;
        }
        int size = 5;
        if (array.length < size) {
            return -1;
        }

        if (num < 0) {
            return -4;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -2;

    }

    public static int sumBinArr(int[][] array) {
        if (array.length != array[0].length) {
            throw new RuntimeException("Массив не квадратный");
        }
        int sum = 0;
        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                sum += ints[j];
                if (ints[j] != 0 && ints[j] != 1) {
                    throw new RuntimeException("Массив не валидный");

                }
            }
        }
        return sum;
    }
//    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//    и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
//    входящих массивов в той же ячейке.
//    Если длины массивов не равны, необходимо как-то оповестить пользователя.

    public static int [] sumArr(int[]arr1, int[]arr2){
        int[] result = new int[arr1.length];
        if(arr1.length != arr2.length){
            throw new RuntimeException(String.format("%d не равно %d", arr1.length, arr2.length));
        }
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];

        }
        return result;
    }
}








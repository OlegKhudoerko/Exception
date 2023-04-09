package HW_2;

public class Example_2 {
    public static void main(String[] args) {

        int[] intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
//        int[] intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7}; //Сработает ArrayIndexOutOfBoundsException
        int d = 2; // Сработает ArithmeticException

        try {
            double catchedRes1 = intArray[7] / d;  // логичнее double catchedRes1 = (double)intArray[8] / d
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (Exception e) {
            System.out.println("Catching exception: " + e);
        }
    }
}

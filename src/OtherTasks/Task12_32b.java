package OtherTasks;
/*
Дан двумерный массив. Вывести на экран:
б) все элементы k-го столбца массива,
начиная с нижнего элемента этого столбца.
 */
import java.util.Arrays;

public class Task12_32b {
    static int k = 3;
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = arr.length*i+j+1;
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        for (int i = arr.length-1; i >=0; i--) {
            System.out.println(arr[i][k]);
        }
    }
}

package OtherTasks;
/*
Дан двумерный массив. Вывести на экран:
а) все элементы третьей строки массива,
начиная с последнего элемента этой строки;
 */
import java.util.Arrays;

public class Task12_32 {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = arr.length*i+j+1;
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        for (int j = arr[2].length-1; j>=0; j--) {
            System.out.print(arr[2][j]+" ");
        }
    }
}

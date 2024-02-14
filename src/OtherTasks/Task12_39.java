package OtherTasks;
/*
Дан двумерный массив. Вывести на экран:
а) все элементы третьей строки массива,
начиная с последнего элемента этой строки;
 */
import java.util.Arrays;
import java.util.Random;

public class Task12_39 {
    public static void main(String[] args) {
        int[][] arr = new int[25][36];
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 36; j++) {
                arr[i][j] = random.nextInt(2);
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        int soldCount = 0;
        for (int seat: arr[12-1]){
            if (seat==1){
                soldCount+=seat;
            }
        }
        System.out.println(soldCount);
    }
}

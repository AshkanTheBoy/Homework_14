package OtherTasks;

import java.util.Arrays;
import java.util.Random;
/*
Дан двумерный массив. Определить:
в) среднее арифметическое всех элементов массива (каждого элемента)
 */
public class Task12_56 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] arr = new int[5][5];
        double avrg;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                avrg = 0;
                arr[i][j] = random.nextInt(10)+1;
                sum+=arr[i][j];
                avrg +=sum/((i+1.)*(j+1));
                if (avrg<10){
                    System.out.printf("%.2f  ",avrg);
                } else {
                    System.out.printf("%.2f ",avrg);
                }

            }
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("FINAL AVERAGE: ");
        System.out.println((double)sum/(arr.length*arr.length));
    }
}

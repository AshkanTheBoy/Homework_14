package OtherTasks;
/*
Дан двумерный массив. Найти:
а) сумму элементов каждой строки;
б) сумму элементов каждого столбца.
Обе задачи решить двумя способами: с использованием дополнительного
одномерного массива и без него.
 */
import java.util.Arrays;

public class Task12_62 {
    public static void main(String[] args) {
        System.out.println("ROWS SUM: ");
        //a (commented out code for aux array)
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            //int[] auxArr = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr.length*i+j+1;
                //auxArr[j] = arr.length*i+j+1;
            }
            //System.out.print(Arrays.stream(auxArr).sum()+" ");
            System.out.print(Arrays.stream(arr[i]).sum()+" ");
            System.out.println(Arrays.toString(arr[i]));
        }
        //b
        System.out.println();
        int[] colSums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int[] auxArr = new int[arr.length];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr.length*i+j+1;
                auxArr[j] = arr[j][i];
            }
            colSums[i] = Arrays.stream(auxArr).sum();
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("COLUMNS SUM: ");
        for (int sum: colSums){
            System.out.print(sum+"  ");
        }
    }
}

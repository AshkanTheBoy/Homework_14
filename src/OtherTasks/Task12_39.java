package OtherTasks;
/*
В зрительном зале 25 рядов, в каждом из которых 36 мест (кресел).
Информация о проданных билетах хранится в двумерном массиве,
номера строк которого соответствуют номерам рядов, а номера столбцов — номерам мест.
Если билет на то или иное место продан, то соответствующий элемент массива имеет значение 1,
в противном случае — 0.
Составить программу, определяющую число проданных билетов на места в 12-м ряду.
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

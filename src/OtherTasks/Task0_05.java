package OtherTasks;
/*
В урне находится 4 карточки с числами от 1 до 4.
При выборе 3-х карточек, карточку можно возвращать обратно в урну и выбирать снова.
Выведите все возможные комбинации такого выбора.
 */
import java.util.Arrays;
import java.util.Random;

public class Task0_05 {
    static Random random = new Random();
    static int[] urn = {1,2,3,4};
    static int[] hand = new int[3];
    public static void main(String[] args) {
        takeRandomCard(0);
        int[][] startHands = makeStartingHands(findRemainingCard());
        System.out.println(findRemainingCard());
        for (int i = 0; i < startHands.length; i++) {
            findUniquePattern(0,startHands[i]);
            System.out.println();
        }

    }

    static void takeRandomCard(int indexInHand){
        int randomUrnCard = random.nextInt(4);
        if (indexInHand>=3){
            return;
        }
        if (indexInHand==0){
            hand[indexInHand]  = urn[randomUrnCard];
            urn[randomUrnCard] = 0;
            takeRandomCard(indexInHand+1);
        } else {
            while (urn[randomUrnCard]==0){
                randomUrnCard = random.nextInt(4);
            }
            hand[indexInHand]  = urn[randomUrnCard];
            urn[randomUrnCard] = 0;
            takeRandomCard(indexInHand+1);
        }

    }

    static int findRemainingCard(){
        for (int card: urn){
            if (card!=0){
                return card;
            }
        }
        return 0;
    }

    static void swap(int i, int j, int[] tempHand) {
        int temp = tempHand[i];
        tempHand[i] = tempHand[j];
        tempHand[j] = temp;
    }

    static void findUniquePattern(int i, int[] tempHand) {
        if (i >= tempHand.length) {
            System.out.print(Arrays.toString(tempHand)+" ");
        }
        for (int j = i; j < tempHand.length; j++) {
            swap(i,j,tempHand);
            findUniquePattern(i + 1, tempHand);
            swap(i,j,tempHand);
        }
    }

    static int[][] makeStartingHands(int remainingCard){
        int[][] startHands = new int[4][3];
        for (int i = 0; i < startHands.length; i++) {
            System.arraycopy(hand, 0, startHands[i], 0, startHands[0].length);
        }
        for (int i = 1; i < startHands.length; i++) {
            startHands[i][i-1] = remainingCard;
        }
        return startHands;
    }
}

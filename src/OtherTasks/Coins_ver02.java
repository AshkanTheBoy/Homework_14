package OtherTasks;

import java.util.ArrayList;
import java.util.Arrays;

/*
В кошельке есть набор монет.
Вывести перебором все возможные подмножества монет для оплаты заданной суммы.
 */
public class Coins_ver02 {
    static Integer[] wallet = {1,2,3,4};
    //[1234,234,34,4,3,24,2,23,134,14,13,124,12,123] - expected result
    static ArrayList<Integer[]> combinations = new ArrayList<>();
    static int sum = 1;

    public static void main(String[] args) {
        Arrays.sort(wallet);
        boolean enoughCoins = checkWallet();
        if (enoughCoins) {
            combinations.add(wallet);
            for (int i = 0; i < combinations.size(); i++) {
                getCombinations(0, combinations.get(i));
            }
            printArr(combinations);
        }
    }

    public static boolean checkWallet() {
        int walletSum = 0;
        for (int coin : wallet) {
            walletSum += coin;
        }
        if (walletSum >= sum) {
            System.out.println("There are enough coins in the wallet");
            return true;
        } else {
            System.out.println("There are not enough coins in the wallet");
            return false;
        }
    }

    public static void getCombinations(int indexToIgnore, Integer[] target){
        if (indexToIgnore>= target.length){
            return;
        }
        ArrayList<Integer> currentResult = new ArrayList<>();
        int combinationSum = 0;
        for (int i = 0; i < target.length; i++) {
            if (i!=indexToIgnore){
                combinationSum+=target[i];
                currentResult.add(target[i]);
            }
        }
        if (combinationSum>=sum){
            Integer[] arr = new Integer[currentResult.size()];
            arr = currentResult.toArray(arr);
            boolean isUnique = true;
            for (int i = 0; i < combinations.size(); i++) {
                if (Arrays.equals(combinations.get(i),arr)){
                    isUnique = false;
                    break;
                }
            }
            if (isUnique){
                combinations.add(arr);
            }
            getCombinations(indexToIgnore+1,target);
        }
    }

    public static void printArr(ArrayList<Integer[]> arr) {
        for (Integer[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }



}

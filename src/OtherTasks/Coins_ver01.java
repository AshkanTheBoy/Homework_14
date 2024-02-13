package OtherTasks;

import java.util.*;

public class Coins_ver01 {
    static int[] wallet = {1,2,3,4,5,6};
    static int sum = 6;
    static ArrayList<Integer> coins = new ArrayList<>();
    static ArrayList<int[]> combs = new ArrayList<>();

    public static void main(String[] args) {
        Arrays.sort(wallet);
        boolean enoughCoins = checkWallet();
        if (enoughCoins){
            printResult(0);
            int[][] combinations = clearCombinations();
            for (int[] comb: combinations){
                System.out.println(Arrays.toString(comb));
            }
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

    static void printResult(int i) {
        if (i >= wallet.length) {
            int combinationSum = 0;
            for (int coin: wallet){
                coins.add(coin);
                combinationSum+=coin;
                if (combinationSum>=sum){
                    int[] arrComb = new int[coins.size()];
                    for (int j = 0; j < coins.size(); j++) {
                        arrComb[j] = coins.get(j);
                    }
                    combs.add(arrComb);
                    coins.clear();
                    break;
                }
            }
        }
        for (int j = i; j < wallet.length; j++) {
            if (i!=j){
                swap(i,j);
            }
            printResult(i + 1);
            if (i!=j){
                swap(i,j);
            }
        }
    }

    static int[][] clearCombinations(){
        for (int[] comb: combs){
            Arrays.sort(comb);
        }
        for (int i = 1; i < combs.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (Arrays.equals(combs.get(i),combs.get(j))){
                    combs.remove(combs.get(i));
                    i--;
                }
            }
        }
        int[][] combinations = new int[combs.size()][];
        for (int i = 0; i < combs.size(); i++) {
            combinations[i] = combs.get(i);
        }
        return combinations;
    }

    static void swap(int i, int j) {
        int temp = wallet[i];
        wallet[i] = wallet[j];
        wallet[j] = temp;
    }

}
package OtherTasks;

import java.util.Arrays;

/*
В кошельке есть набор монет.
Вывести перебором все возможные подмножества монет для оплаты заданной суммы.
 */
public class Coins {
    //{1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 5};
    static int[] wallet = {1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 5,6};
    static int sum = 13;
    static int count = 0;

    public static void main(String[] args) {
        boolean enoughCoins = checkWallet();
        if (enoughCoins) {
            countCombinations(0);
            System.out.println(count);
            int[] combLengths = new int[count];
            getCombinationsLengths(0, combLengths);
            printArr(combLengths);
            int[][] combinations = new int[count][];
            for (int i = 0; i < combinations.length; i++) {
                combinations[i] = new int[combLengths[i]];
            }
            fillCombinations(combinations, 0);
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

    public static void countCombinations(int startingIndex) {
        if (startingIndex >= wallet.length) {
            return;
        }
        int combinationSum = 0;
        for (int i = startingIndex; i < wallet.length; i++) {
            combinationSum += wallet[i];
            if (combinationSum >= sum) {
                break;
            }
        }
        if (combinationSum < sum) {
            for (int i = 0; i < startingIndex; i++) {
                combinationSum += wallet[i];
                if (combinationSum >= sum) {
                    break;
                }
            }
        }
        count++;
        countCombinations(startingIndex + 1);
    }

    public static void getCombinationsLengths(int startingIndex, int[] combLengths) {
        if (startingIndex >= wallet.length) {
            return;
        }
        int combinationSum = 0;
        int length = 0;
        for (int i = startingIndex; i < combLengths.length; i++) {
            combinationSum += wallet[i];
            length++;
            if (combinationSum >= sum) {
                break;
            }
        }
        if (combinationSum < sum) {
            for (int i = 0; i < startingIndex; i++) {
                combinationSum += wallet[i];
                length++;
                if (combinationSum >= sum) {
                    break;
                }
            }
        }
        combLengths[startingIndex] = length;
        getCombinationsLengths(startingIndex + 1, combLengths);
    }

    public static void fillCombinations(int[][] combinations, int startingIndex) {
        if (startingIndex >= combinations.length) {
            return;
        }
        int combinationSum = 0;
        int combCoinIndex = 0;
        for (int i = startingIndex; i < wallet.length; i++) {
            combinationSum += wallet[i];
            combinations[startingIndex][combCoinIndex] = wallet[i];
            combCoinIndex++;
            if (combinationSum >= sum) {
                break;
            }
        }
        if (combinationSum < sum) {
            for (int i = 0; i < startingIndex; i++) {
                combinationSum += wallet[i];
                combinations[startingIndex][combCoinIndex] = wallet[i];
                combCoinIndex++;
                if (combinationSum >= sum) {
                    break;
                }
            }
        }
        fillCombinations(combinations,startingIndex+1);
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }


}

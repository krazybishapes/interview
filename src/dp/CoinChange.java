package dp;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + result);
    }

    public static int coinChange(int[] coins, int amount){

        if(amount == 0){
            return 0;

        }
        if(amount < 0){
            return -1;

        }

        int minCoins = Integer.MAX_VALUE;

        for(int coin: coins){
            int remainingAmount = amount - coin;
            int result = coinChange(coins, remainingAmount);
            if(result >=0 && result < minCoins){
                minCoins = result + 1;

            }
        }
        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }
}

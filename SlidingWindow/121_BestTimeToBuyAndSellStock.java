//Approach: Sliding Window
//We will maintain two variables, minPrice and maxProfit.
//We will iterate through the array of prices and at each step, we will update the minPrice to be the minimum of the current minPrice and the current price.
//We will also update the maxProfit to be the maximum of the current maxProfit and the difference between the current price and the minPrice.
//At the end of the iteration, we will return the maxProfit, which will be the maximum profit that can be achieved by buying and selling the stock.

//Time Complexity: O(n) where n is the length of the input array. We are iterating through the array once.
//Space Complexity: O(1) as we are using only a constant amount of extra space to store the minPrice and maxProfit variables.


class Solution {
    public int maxProfit(int[] prices) {
        
        int maxPro=0;
        int minPrice=Integer.MAX_VALUE;

        for(int num:prices){
            minPrice=Math.min(minPrice,num);
            maxPro=Math.max(maxPro,num-minPrice);
        }

        return maxPro;
    }
}
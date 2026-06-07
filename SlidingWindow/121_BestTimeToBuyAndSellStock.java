
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
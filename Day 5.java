/*
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
Note:
1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:
The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
*/
class Solution {
    double w_probabilities [];
    public Solution(int[] w) {
       w_probabilities = new double[w.length];
        double sum = 0;
        for(int i = 0; i < w.length; i++)
            sum += w[i];
        for(int i = 0; i < w.length; i++){
            w[i] += (i == 0) ? 0 : w[i - 1];
            w_probabilities[i] = w[i] / sum;
        }          
    }    
    public int pickIndex() {
       /* with only sum
       double target = w_sum[w_sum.length - 1] * Math.random() ;
        int left = 0, right = w_sum.length, result = -1;
        while(left <= right){
            int mid = (left + (right - left)) / 2;
            if(target < w_sum[mid]){
                result  = mid;
                right = mid - 1;                
            }
            else
                left = mid + 1;
        }
        return result;
        */
         return Math.abs(Arrays.binarySearch(w_probabilities, Math.random() )) - 1;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
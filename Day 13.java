/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.
Example 1:
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:
Input: [1,2,4,8]
Output: [1,2,4,8]
*/
class Solution {
    List <Integer> result;
    int subset [];
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        subset = new int[nums.length];
        Arrays.fill(subset,-1);
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>(),1);
        return result;      
    }
    void helper(int nums[],int index,List<Integer> curr,int prev){
        if(curr.size() > result.size())
            result = new ArrayList<>(curr);
        for(int i = index;i < nums.length;i++){
            if(curr.size() > subset[i] && nums[i] % prev == 0){                
            subset[i] = curr.size();
            curr.add(nums[i]);
            helper(nums,i + 1,curr,nums[i]);
            curr.remove(curr.size() - 1);
            }
        }
    }
}
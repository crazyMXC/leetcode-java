class Solution {
    public int singleNumber(int[] nums) {
        int i=0;
        int result=0;
        while(i<nums.length){
            result=result^nums[i];
            i++;
        }
        return result;
    }
}
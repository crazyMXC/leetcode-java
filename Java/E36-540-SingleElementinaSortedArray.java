class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length,low=0,high=n/2;
        while(low<high){
            int middle=(low+high)/2;
            if(nums[2*middle]!=nums[2*middle+1])
                high=middle;
            else
                low=middle+1;
        }
        return nums[2*low];
    }
}
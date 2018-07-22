class Solution {
    public int[] singleNumber(int[] nums) {
        int resTwo=0;
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++)
            resTwo^=nums[i];
        resTwo &=-resTwo;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & resTwo) == 0)
                res[0]^=nums[i];
            else
                res[1]^=nums[i];
        }
        return res;
    }
}
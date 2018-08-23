class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int p=quickSelect(nums,0,n-1,n-k+1);
        return nums[p];
    }
    public int quickSelect(int[] nums,int lo,int hi,int k){
        int i=lo,j=hi,pivot=nums[hi];
        while(i<j){
            if(nums[i++]>pivot)
                swap(nums,--i,--j);
        }
        swap(nums,i,hi);
        
        int m=i - lo + 1;
        
        if(m==k)
            return i;
        else if(m>k)
            return quickSelect(nums, lo, i - 1, k);
        else
            return quickSelect(nums, i + 1, hi, k - m);
    }
    public void swap(int[] nums,int i,int j)
    {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
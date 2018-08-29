class Solution {
    public int rob(int[] nums) {
        int preNo=0,preYes=0;
        for(int n:num){
            int temp = preNo;
            preNo = Math.max(preNo,PreYes);
            preYes = n+temp;
        }
        return Math.max(preNo,preYes);
    }
}
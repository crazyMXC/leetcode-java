class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || cost==null || gas.length==0 || cost.length==0)
            return -1;
        int start=0;
        int total=0;
        int sum=0;
        for(int i=0;i<gas.length;i++)
        {
            total+=(gas[i]-cost[i]);
            if(sum<0){
                sum=gas[i]-cost[i];
                start=i;
            }
            else
                sum+=(gas[i]-cost[i]);
        }
        return total>=0 ? start:-1;
    }
}
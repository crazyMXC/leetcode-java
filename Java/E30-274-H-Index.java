class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        if(length == 0)
            return 0;
        int[] arrays=new int[length+1];
        for(int i=0;i<length;i++){
            if(citations[i]>length)
                arrays[length]+=1;
            else
                arrays[citations[i]]+=1;
        }
        int t=0;
        int res=0;
        for(int i=length;i>=0;i--){
            t=t+arrays[i];
            if(t>=i)
                return i;
        }
        return 0;
    }
}
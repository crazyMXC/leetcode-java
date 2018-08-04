class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        for(int i=0; i<input.length();i++)
        {
            if(input.charAt(i)=='-' || input.charAt(i)=='*' || input.charAt(i)=='+'){
                String p1=input.substring(0,i);
                String p2=input.substring(i+1);
                List<Integer> p1Res=diffWaysToCompute(p1);
                List<Integer> p2Res=diffWaysToCompute(p2);
                for(Integer c1:p1Res){
                    for(Integer c2:p2Res){
                        int c=0;
                        switch (input.charAt(i)) {
                            case '+': c = c1+c2;
                                break;
                            case '-': c = c1-c2;
                                break;
                            case '*': c = c1*c2;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if(res.size()==0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
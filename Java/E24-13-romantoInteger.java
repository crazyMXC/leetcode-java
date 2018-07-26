class Solution {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int total = map.get(s.charAt(0));
        int len=s.length();
        for(int i=1;i<len;i++){
            if(map.get(s.charAt(i))>map.get(s.charAt(i-1))){
                total = total + map.get(s.charAt(i)) - 2*map.get(s.charAt(i - 1));
            }else{
                total = total + map.get(s.charAt(i));
            }
        }

        return total;
    }
}
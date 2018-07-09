class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t))
            return true;
        if(s==null||t==null||s.length()!=t.length())
            return false;
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
            num[t.charAt(i)-'a']--;
        }
        for(int i:num ){
            if(i!=0)
                return false;
        }
        return true;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String t = stringToString(line);
            
            boolean ret = new Solution().isAnagram(s, t);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}
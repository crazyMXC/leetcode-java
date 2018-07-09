class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int ans=0,i=0,j=0;
        while(i<n && j<n)
        {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }
            else
                set.remove(s.charAt(i++));
        }
        return ans;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().lengthOfLongestSubstring(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
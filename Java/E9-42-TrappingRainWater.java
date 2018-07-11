class Solution {
     public int trap(int[] height){
        int length = height.length;
        //leftMax数组
        int[] left = new int[length];
        //rightMax数组
        int[] right = new int[length];
        
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0 ; i<length ; i++){
            leftMax = left[i] = Math.max(leftMax,    height[i]);
            rightMax = right[length-i-1] = Math.max(rightMax, height[length-i-1]);
        }
        int result = 0;
        for(int j = 0 ; j<length ; j++){
            result += Math.min(left[j], right[j]) - height[j];
        }
        return result;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);
            
            int ret = new Solution().trap(height);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
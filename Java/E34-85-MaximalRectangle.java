class Solution {
    public int maximalRectangle(char[][] matrix) {
       int rLen = matrix.length, cLen = rLen == 0 ? 0 : matrix[0].length, max = 0;
        int[] h = new int[cLen+1];
   
        for (int row = 0; row < rLen; row++) {
            Stack<Integer> s = new Stack<Integer>();
            s.push(-1);
            for (int i = 0; i <= cLen ;i++) {
                if(i < cLen && matrix[row][i] == '1')
                    h[i] += 1;
                else 
                    h[i] = 0;

                while(s.peek() != -1 && h[i] < h[s.peek()]) {
                    max = Math.max(max, h[s.pop()] * (i - s.peek() - 1));
                }
                s.push(i);
            }
        }
        return max;
    }
}
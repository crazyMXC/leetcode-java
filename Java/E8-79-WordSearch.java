class Solution {
    int[] dh={0,1,0,-1};
    int[] dw={1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(isThisWay(board,word,i,j,0,isVisited))
                    return true;
        return false;
    }
    
    public boolean isThisWay(char[][] board, String word, int row, int column, int index, boolean[][] isVisited) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
            || isVisited[row][column] || board[row][column] != word.charAt(index))
                return false;  //剪枝
        if (++index == word.length()) return true;  //word所有字符均匹配上
        isVisited[row][column] = true;
        for (int i = 0; i < 4; i++)
            if (isThisWay(board, word, row + dh[i], column + dw[i], index, isVisited))
                return true;  //以board[row][column]为起点找到匹配上word路径
        isVisited[row][column] = false;  //遍历过后，将该点还原为未访问过
        return false;
    }
}


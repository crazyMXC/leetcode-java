class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (Math.pow(3, Math.round(Math.log(n) / Math.log(3))) == n) {
            return true;
        } 
        return false;

    }
}
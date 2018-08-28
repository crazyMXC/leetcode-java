class Solution {
public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int left = i + 1, right = num.length - 1, sum = 0 - num[i];
            while (left < right) {
                if (num[left] + num[right] == sum) {
                    // res.add((List<Integer>)Arrays.asList(newInteger[]{num[i], num[left], num[right]})); 和下面效果一样
                    res.add(Arrays.asList(num[i], num[left], num[right]));
                    while (left < right && num[left] == num[left + 1])
                        // 跳过重复数
                        left++;
                    while (left < right && num[right] == num[right - 1])
                        right--;
                    left++;
                    right--; // 如果已经找到一组，在跳过重复数的情况下，只移动某一个指针是绝对找不到下一个的，所以找到后两个指针同时向对方移动
                } else if (num[left] + num[right] < sum) // 这种情况说明 i + left + right < 0，
                                                         // 此时应该增加它们的和，此次循环i不变，right变是变小，所以移动left
                    left++;
                else
                    right--; // 否则则说明和大于0，需要减小和值，此时应该移动right
            }
        }
        return res;
    }
}
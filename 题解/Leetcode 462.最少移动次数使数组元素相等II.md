# Leetcode 462.最少移动次数使数组元素相等II

给你一个长度为`n`的整数数组`nums`，返回使所有数组元素相等需要的最少移动数。

在一步操作中，你可以使数组中的一个元素加`1`或者减`1`。

2022/5/19 第一次见

初见思路：数组的中位数，即为目标值，所有元素移动到该值所需的步数最少

代码如下：

```java
class Solution {
    public int minMoves2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int target = nums[len/2];
        int ans = 0;
        for (int num : nums){
            ans += Math.abs(num-target);
        }
        return ans;
    }
}
```

结果：通过！！ 时间复杂度O(nlogn)，空间复杂度O(logn)

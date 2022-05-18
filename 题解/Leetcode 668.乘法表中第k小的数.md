# Leetcode 668.乘法表中第k小的数

几乎每一个人都有用乘法表。但是你能在乘法表中快速找到第`k`小的数字吗？

给定一个高度`m`、宽度`n`的一张`m*n`的乘法表，以及正整数`k`，你需要返回表中第`k`小的数字。

2022/5/18 第一次见

初见思路：将m*n的乘法表中数值存入哈希表中，然后从头判断第k小的数字

代码如下：

```java
class Solution {
    public int findKthNumber(int m, int n, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                int temp = (i+1)*(j+1);
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        int count = 0;
        int ans = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            count += entry.getValue();
            if (count >= k){
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }
}
```

结果：超出时间限制！ 最后执行输入：m=9895，n=28405，k=100787757

时间复杂度O(mn)，空间复杂度O(mn)。

（参考了题解）考虑使用二分查找法。该题实际上可以化简成一个矩阵双向递增找第k个值的问题，由于乘法表从上到下和从左到右都是递增的，因此二分法判断的入口应该是左下角或右上角。令mid = (1+mn)/2，然后判断有多少个数比mid的小，然后逐渐逼近答案。

代码如下：

```java
class Solution {
    public int findKthNumber(int m, int n, int k){
        int left = 1;
        int right = m*n;
        while (left < right){
            int mid = (left+right)/2;
            if (countNum(mid,m,n) >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int countNum(int num, int m, int n){
        int count = 0;
        int i = m;
        int j = 1;
        while (i > 0 && j <= n){
            if (i*j <= num){
                count += i;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
```

结果：通过！！ 时间复杂度O((m+n)*log(mn))：二分查找为log(mn)，每一次查找为(m+n)

                            空间复杂度O(1)：用了常量的空间



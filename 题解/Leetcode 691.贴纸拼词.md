# Leetcode 691.贴纸拼词

我们有`n`种不同的贴纸。每个贴纸上都有一个小写的英文单词。

您想要拼写出给定的字符串`target`，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个忒只的数量是无限的。

返回你需要拼出`target`的最小贴纸数量。如果任务不可能完成，则返回`-1`。

**注意**：在所有测试用例中，所有的单词都是从`1000`个最常见的美国英语单词中随机选择的，并且`target`被选择为两个随机单词的链接。

2022/5/14 初见（毫无思路）

官方题解：记忆化搜索+状态压缩

记target的长度为m，它一共有2^m个子序列（包括空子序列和target本身，字符相同但是组成的下标不同的子序列视为不同的子序列）。根据动态规划的思路，拼出某个子序列mask所需要的最小贴纸数又可以由mask的子序列来计算，下一段介绍动态规划的思路。

在本题中，定义函数dp(mask)来求解不同状态的最小贴纸数，输入是某个子序列mask，输出是拼出该子序列的最小贴纸数。计算拼出mask所需的最小贴纸数时，需要选取最优的sticker让其贡献部分字符，未被sticker覆盖的其他字符left需要用动态规划继续计算。在选取最优的sticker时，需要遍历所有的sticker。遍历到某个sticker时，计算mask和sticker字符的最大交集（非空），mask中这部分交集由sticker贡献，剩余部分的最小贴纸数由动态规划继续计算，而sticker中不属于最大交集的剩下部分会被舍弃，不会产生任何贡献。遍历完所有sticker后，选取出所有贴纸数的最小值作为本次规划的结果，这一遍历stickers并根据剩余部分的最小贴纸数来计算当前mask的最小贴纸数的步骤完成了状态转移。边界情况是，如果mask为空寂，则贴纸数为0。

在动态规划时，子序列可以用一个二进制数来表示。从低位到高位，某位为0则表示在target中这一位不选取，为1则表示选取这一位，从而完成状态压缩的过程。

代码实现如下：

```java
class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[] memo = new int[1 << m];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int res = dp(stickers, target, memo, (1 << m) - 1);
        return res <= m ? res : -1;
    }

    public int dp(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        if (memo[mask] < 0) {
            int res = m + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        cnt[c - 'a']--;
                        left ^= 1 << i;
                    }
                }
                if (left < mask) {
                    res = Math.min(res, dp(stickers, target, memo, left) + 1);
                }
            }
            memo[mask] = res;
        }
        return memo[mask];
    }
}

```



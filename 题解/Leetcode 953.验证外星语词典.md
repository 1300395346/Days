# Leetcode 953.验证外星语词典

某种外星语也使用英文小写字母，但可能顺序`order`不同。字母表的顺序（`order`）是一些小写字母的排列。

给定一组用外星语书写的单词`words`，以及其字母表的顺序`order`，只有当给定的单词在这种外星语中按字典序排列时，返回`true`；否则，返回`false`。

思路：与剑指Offer 034的题目一样，代码如下：

```java
class Solution {
   public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < 26; ++i){
            map.put(order.charAt(i),i+1);
        }
        for (int i = 1; i < words.length; ++i){
            if (compare(words[i-1],words[i],map)>0){
                return false;
            }
        }
        return true;
    }

    public int compare(String first, String second, HashMap<Character,Integer> map){
        int len1 = first.length();
        int len2 = second.length();
        int len = Math.min(len1,len2);
        for (int i = 0; i < len; ++i){
            if (!map.get(first.charAt(i)).equals(map.get(second.charAt(i)))){
                return map.get(first.charAt(i)) - map.get(second.charAt(i));
            }
        }
        return len1-len2;
    }
}
```



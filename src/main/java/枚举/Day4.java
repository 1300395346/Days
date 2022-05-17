package 枚举;

import java.util.HashMap;

public class Day4 {
    public static void main(String[] args) {
        Day4 day4 = new Day4();
        boolean ans = day4.isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz");
        System.out.println(ans);
    }

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

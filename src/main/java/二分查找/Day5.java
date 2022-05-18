package 二分查找;

import java.util.Map;
import java.util.TreeMap;

public class Day5 {
    public static void main(String[] args) {
        Day5 day5 = new Day5();
        int ans = day5.findKthNumber(9,9,81);
        System.out.println(ans);
    }

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

    //枚举
//    public int findKthNumber(int m, int n, int k) {
//        Map<Integer,Integer> map = new TreeMap<>();
//        for (int i = 0; i < m; ++i){
//            for (int j = 0; j < n; ++j){
//                int temp = (i+1)*(j+1);
//                map.put(temp,map.getOrDefault(temp,0)+1);
//            }
//        }
//        int count = 0;
//        int ans = 0;
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
//            count += entry.getValue();
//            if (count >= k){
//                ans = entry.getKey();
//                break;
//            }
//        }
//        return ans;
//    }
}
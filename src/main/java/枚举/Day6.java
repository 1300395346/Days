package 枚举;

import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) {
        Day6 day6 = new Day6();
        int ans = day6.minMoves2(new int[]{1,0,0,8,6});
        System.out.println(ans);
    }

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

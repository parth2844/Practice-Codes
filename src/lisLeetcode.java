public class lisLeetcode {
    public static void main(String[] args) {
        int[] nums = {};
        int ans = lengthOfLIS(nums);
        System.out.println(ans);
    }

    static int[] dp;
    public static int lengthOfLIS(int[] nums) {
        if(nums.length < 2)
            return nums.length;

        dp = new int[nums.length];

        // for(int i: dp)
        //     System.out.print(i + " ");

        return LIS(nums, 0, Integer.MIN_VALUE);
    }

    private static int LIS(int[] nums, int start, int min) {
        if(start >= nums.length)
            return 0;

        if(dp[start] != 0)
            return dp[start];

        if(nums[start] > min) {
            dp[start] = Math.max(LIS(nums, start + 1, nums[start]) + 1, LIS(nums, start + 1, min));
        }
        else {
            dp[start] = LIS(nums, start + 1, min);
        }

        return dp[start];
    }
}

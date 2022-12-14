package arithmetic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: FourSum_18
 * @Author: LWQ
 * @Data:2023/1/5 15:17
 * @Description: leetcode_practice
 * 
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 
 *
 * 提示：
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> forSum = new ArrayList<>();
        Arrays.sort(nums);
        
        return forSum;
    }

    public static void main(String[] args) {
        FourSum_18 fourSum_18 = new FourSum_18();
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> fourSum = fourSum_18.fourSum2(nums, target);
        for (List<Integer> list : fourSum) {
            System.out.println(list);
        }
    }

    /**
     * 执行用时：12 ms, 在所有 Java 提交中击败了70.87%的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了32.74%的用户
     * 通过测试用例：292 / 292
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // 用例中存在四数之和int溢出的场景
        if (nums[0] > target && nums[0] > 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}

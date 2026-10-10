import java.util.*;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        List<int[]> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3) return new int[0][0];
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        int[][] result = new int[resultList.size()][3];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[][] res1 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.print("[");
        for (int[] r : res1) System.out.print(Arrays.toString(r) + " ");
        System.out.println("]");
        
        int[][] res2 = threeSum(new int[]{0, 0, 0});
        System.out.print("[");
        for (int[] r : res2) System.out.print(Arrays.toString(r) + " ");
        System.out.println("]");
    }
}

import java.util.HashMap;

public class Twosum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[]{1,1,1,1,1,4,1,1,1,
                1,1,7,1,1,1,1,1}, 11);
    }
}

class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] nums2 = new int[2];
        HashMap<Integer, Integer> hashMapIntegers = new HashMap<>();
        //check if value exists in the hashmap
        // if it exists check if their is a value that matches this value
        //push it into the hashmap
        for (int i = 0; i < nums.length ; i++) {
                int substract = target - nums[i];
                if (hashMapIntegers.get(substract) != null){
                    nums2[0] = i;
                    nums2[1] = hashMapIntegers.get(substract);
                    return nums2;
                }
                hashMapIntegers.put(nums[i], i);
        }
        return nums2;
    }
}
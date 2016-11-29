package problems;

import java.util.*;

public class SingleNumber_136 {
    // # 136 Single Number
    // Given an array of integers, every element appears twice except for one. Find that single one.
    // Status: passed.  240ms.   0.79%      singleNumber
    // Status: passed.  1ms.     43.19%     singleNumber_op
    
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++){
            // Be careful here! list.remove (Object O) and list.remove(int i)
            // Those two methods can create ambiguity and when the integers are stored in the list.
            // To actually remove a integer from the list, create a actual object. like below.
            if(list.contains(nums[i])) list.remove(new Integer(nums[i]));
            else list.add(nums[i]);
        }
        return list.get(0);
    }
    
    
    public int singleNumber_op(int[] nums){
        //
        // Using bitwise XOR (for XOR, if two are same, false. if two are different, true.)
        // For XOR, 0 ^ N = N    N ^ N = 0
        int result = 0;
        for (int i=0; i<nums.length; i++){
            result ^=nums[i];  // Same as result = result ^ nums[i]
        }
        // Eventually, result = 0 ^ 1 ^ 5 ^ 8 ^ 2 ^ 4 ^ 8 ^ 1 ^ 4 ^ 5
        return result;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SingleNumber_136 t = new SingleNumber_136();
        int[] test1  ={1,5,8,2,4,8,1,4,5};  // Find 
        int[] test2 = {4,1,5,1,5};
        System.out.println("Original: " + t.singleNumber(test1));
        
        System.out.println("op: " + t.singleNumber_op(test2));
    }

}

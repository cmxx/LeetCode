package problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    // # 217 Contains Duplicate
    // Status: Passed. (Finished in 6 minutes) 9ms. 68.64 %
    // November 30, 2016
    
    // Given an array of integers, find if the array contains any duplicates. 
    // Your function should return true if any value appears at least twice in
    // the array, and it should return false if every element is distinct.
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i=0; i < nums.length; i++){
            if (!hs.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

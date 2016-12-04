package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutation {
	
	// Passed. 2ms. 46.21%
	public boolean op(String s) {
		Set<Character> set = new HashSet<>();
		for(char c:s.toCharArray()){
			// If same char appears again, remove it from set.
			// So only chars with odd number is in the set
			if(set.contains(c)) set.remove(c); 
			else set.add(c);
		}
		return set.size() <=1;
	}
	
	
	
	/* Status: Passed. 1ms. 73.29%
	 * Rule: The Palindrome only allows one kind of char to be odd, 
	 * others have to have even numbers.
	 */
    public boolean canPermutePalindrome(String s) {
    	if (s == null) return true;
        char[] p = s.toCharArray();
        Arrays.sort(p);
        
        int isPal = 0;		// This this number>1, then s is not palindrome.
        int counter = 1;
        char c = p[0];
        for (int i=1; i<p.length;i++){
        	if(isPal > 1) return false;
        	if(p[i] == c) counter++;
        	else{
        		//if number of previous char is odd
        		if(counter%2 ==1) isPal++;
        		counter=1;
        		c = p[i];
        		
        	}
        }
        // Check the last char
        if(counter%2 ==1) isPal++;
        if (isPal >1) return false;
        else return true;
    }
}

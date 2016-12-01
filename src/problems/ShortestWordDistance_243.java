package problems;

import java.util.*;

public class ShortestWordDistance_243 {
    
    // 
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                start.add(i);
            else if (words[i].equals(word2))
                end.add(i);
            else
                continue;
        }
        
        int ans = 999999 ;
        for (int i=0; i < start.size(); i++){
            for (int j=0; j < end.size(); j++){
                int diff = Math.abs(start.get(i)-end.get(j));
                if ( diff < ans){
                    ans = diff;
                }
            }
        }
        return ans;
    }
    
    public int op(String[] words, String word1, String word2) {
        return 0;
    }

    public static void main(String[] args) {
        ShortestWordDistance_243 t = new ShortestWordDistance_243();

        String[] w = { "a", "c", "d", "b", "e", "a", "b" };

        System.out.println(t.shortestDistance(w, "a", "b"));

    }
}

package problems;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	
	// #359 Logger Rate Limiter. Problem from Google
	// Status: Passed. 151ms. 88.73%	Finished by myself.
	
    /** Initialize your data structure here. */
    private Map<String,Integer> hm;
    public LoggerRateLimiter() {
        hm = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!hm.containsKey(message)){
            hm.put(message,timestamp);
            return true;
        }
        else{
            int oldVal = hm.get(message);
            if (timestamp > oldVal+9){
                hm.put(message,timestamp);
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    public void printing(int t, String m){
    	System.out.println("String is: "+ m + "  and time is: " + t);
    	System.out.println("Result is: "+shouldPrintMessage(t,m) + "\n");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerRateLimiter t = new LoggerRateLimiter();
		
		t.printing(1,"Zhang");
		t.printing(3, "Zou");
		t.printing(7, "Zou");
		t.printing(10, "Zhang");
		t.printing(11, "Zhang");
		t.printing(12, "Zou");

	}

}

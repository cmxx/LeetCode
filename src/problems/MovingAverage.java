package problems;

import java.util.*;

public class MovingAverage {
	/** Initialize your data structure here. */
	
	// #346 Moving Average from Data Stream
	
	/* This way is too Slow. Caused Error: Time Limit Exceeded.
	List<Integer> l = new LinkedList<>();
	int l_size = l.size();
	int size = 0;
	int totalNumber = 0;

	public MovingAverage(int size) {

		this.size = size;

	}

	public double next(int val) {
		totalNumber++;
		l.add(0, val);
		double total = 0;
		double ans;
		if (totalNumber < size) {
			for (int i = 0; i < totalNumber; i++) {
				total += l.get(i);
			}
			ans = total / totalNumber;
			System.out.println(ans);
			return ans;
		} else {
			for (int i = 0; i < size; i++) {
				total += l.get(i);
			}
			ans = total / size;
			System.out.println(ans);
			return ans;
		}
	}
	*/
	
	// Status: passed. 228ms.  5.63%.  Tooooo Slow.
	/*
	Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
	int size;
	int index = 0;
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
    	hm.put(index, val);
    	int sum = 0;
    	if (hm.size()<size){
    		for (int i=0; i < hm.size(); i++){
    			sum += hm.get(i);
    		}
    		index++;
    		return (double)sum / hm.size();
    	}
    	else {
			for (int i= index; i>index-size; i--){
				sum+= hm.get(i);
			}
			index++;
			return (double) sum / size;
		}
    	
    }
    
    */
	
	
	// Status: Passed. 146 ms. 78.11%
	
	private int[] numArray;
	private int n,index;
	private long sum;

	public MovingAverage(int size) {
		numArray = new int[size];
	}

	public double next(int val) {
		if (n < numArray.length)
			n++; // n will add up until numArray is filled up.
		sum -= numArray[index];  // subtract the old value from sum
		sum += val;		// add new value to sum
		numArray[index] = val;  // replace old value to new at the array
		index = (index + 1) % numArray.length;  // Each round add 1 to index. then get reminder.
		
		return (double) sum / n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
	}

}

package problems;

public class ReverseString {
	
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        char[] c_new = new char[c.length];
        int counter = c.length;
        for (int i=0; i<c.length; i++){
        	c_new[i] = c[--counter];
        }
        return String.valueOf(c_new);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString t = new ReverseString();
		System.out.println(t.reverseString("Zhang"));
	}

}

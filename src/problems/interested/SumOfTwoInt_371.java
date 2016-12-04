package problems.interested;

public class SumOfTwoInt_371 {
    
    // # 371 Sum of Two Integers
    // Status: Passed.  0ms 7.04%
    
    
    // Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
    /* Use of Bitwise Operation. 
     * https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
     * https://en.wikipedia.org/wiki/Bitwise_operation
     * https://www.tutorialspoint.com/java/java_basic_operators.htm
     * AND  &       0010 & 0111 => 0010
     * OR   |       0010 OR 0111 => 0111
     * XOR  ^       0010 XOR 0111 => 0101
     * NOT (Compliment) ~   ~0010 = 1101
     * The bitwise complement is equal to the two's complement of the value minus one. 
     * If two's complement arithmetic is used, then NOT x = -x - 1.
     * 
     * Arithmetic shift
     * left shift   <<    Zeros are shifted in on the right
     *          8bit example        00010111 <<  1 =  00101110
     * right shift  >>    sign bit (left most bit) is shifted in on the left. 
     *          8bit example        00010111 >> 1 = 00001011 
     *                              10010111 >> 1 =  11001011  (this is a negative number)
     * zero fill right shift    >>>
     * 
     * 
     * 
     * Bitwise Applications:
     * Addition:
     * while a != 0
     *      carry  = b AND a
     *      b =  b XOR a
     *      left shift c by 1
     *      a = c
     * return b
     * 
     */

    
    // Addition-Iterative
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        
        while (a != 0){
            int carry = a & b;
            //System.out.println("Carry: " + carry);
            b = b ^ a;
            //System.out.println("b: " + b);
            a = carry << 1;
            //System.out.println("a: " + a);
            //System.out.println();
        }
        return b;
    }
    
    // Subtraction - Iterative
    public int getSubtraction(int a, int b){
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
    
    // Addition - Recursive
    public int getSumR(int a, int b) {
        return (b == 0) ? a : getSumR(a ^ b, (a & b) << 1);
    }

    // Subtraction - Recursive
    public int getSubtractionR(int a, int b) {
        return (b == 0) ? a : getSubtractionR(a ^ b, (~a & b) << 1);
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        SumOfTwoInt_371 t = new SumOfTwoInt_371();
        System.out.println(t.getSum(3, 5));
    }

}

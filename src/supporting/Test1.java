package supporting;

public class Test1 {
	
	private int k;
	
	private Test1(){
		
	}

    private void printSingleInt() {
        int k = 123456789;
        while (k > 0) {
            int x = k % 10;
            k = k/10;
            System.out.println(x);
        }
    }
    
    private void plusplus(){
        int p = 0;
        for(int i=0; i<3;i++){
            System.out.println("++p: " + ++p);
        }
        int k = 0;
        for(int i=0; i<3;i++){
            System.out.println("k++: " + k++);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test1 t = new Test1();

        //t.plusplus();
        System.out.println(t.k);

    }
}

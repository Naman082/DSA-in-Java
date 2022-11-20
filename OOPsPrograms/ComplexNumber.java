/*
Sample Input1:
4 5 // 4, 5i
6 7 // 6, 7i
1
Sample Output1:
10 + i12

Sample Input1:
4 5 // 4, 5i
6 7 // 6, 7i
2
Sample Output1:
-11 + 58i

*/

package OOPsPrograms;
import java.util.Scanner;

public class ComplexNumber {
	
	private int r;
	private int i;
	private ComplexNumber(int r, int i) { // constructor
		this.r = r;
		this.i = i;
	}
	
	private void plus(ComplexNumber c) {
		this.r = this.r + c.r;
		this.i = this.i + c.i;
	}
	
	private void multiply(ComplexNumber c) {
		int x = (this.r*c.r) - (this.i*c.i);
		int y = (this.r*c.i) + (this.i*c.r);
		this.r = x;
		this.i = y;
	}
	
	private void print() {
		System.out.println(r +" "+ i + "i");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r1 = s.nextInt();
		int i1 = s.nextInt();
		int r2 = s.nextInt();
		int i2 = s.nextInt();
		
		ComplexNumber c1 = new ComplexNumber(r1, i1);
		ComplexNumber c2 = new ComplexNumber(r2, i2);
		
		int choice = s.nextInt();
		if(choice == 1) {
			c1.plus(c2);
			c1.print();
		}else if(choice == 2) {
			c1.multiply(c2);
			c1.print();
		}else {
			return;
		}
	}
}

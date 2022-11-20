/*
Sample Input 1:
3 // len of polynomial
3 1 7
1 2 3 // x3, 2x, 3x7
2 // len of polynomial
2 1
7 8 // 7x2, 8x
1 // choice
Sample Output 1:
10x1 7x2 1x3 3x7

Sample Input 2:
3 // len of polynomial
3 1 7
1 2 3 // x3, 2x, 3x7
2 // len of polynomial
2 1
7 8 // 7x2, 8x
2 // choice
Sample Output 2:
-6x1 -7x2 1x3 3x7

Sample Input 3:
3 // len of polynomial
3 1 7
1 2 3 // x3, 2x, 3x7
2 // len of polynomial
2 1
7 8 // 7x2, 8x
3 // choice
Sample Output 3:
16x2 14x3 8x4 7x5 24x8 21x9
*/


package OOPsPrograms;
import java.util.Scanner;

public class Polynomial {
	
	private int degCoeff[];
	
	private Polynomial(){ // constructor
		degCoeff = new int[10];
	}
	
	private void setCoeff(int deg, int coeff) {
		if(deg > degCoeff.length-1) {
			int[] temp = degCoeff;
			degCoeff = new int[deg+1]; // Creating a new array of size = deg+1
			for(int i=0; i<temp.length; i++) {
				degCoeff[i] = temp[i]; // Copy values from temp to degCoeff
			}
		}
		degCoeff[deg] = coeff;
	}
	private int getCoeff(int deg) {
		if(deg < this.degCoeff.length) {
			return degCoeff[deg];
		}else {
			return 0;
		}
	}
	
	private void print() { // print all terms with non zero coefficients in inc order of deg
		for(int i=0; i<degCoeff.length; i++) {
			if(degCoeff[i] != 0) {
				System.out.print(degCoeff[i] + "x" +i+ " ");
			}
		}
	}
	
	private Polynomial add(Polynomial p) { // Add two polynomial and return a new polynomial which has the ans
		Polynomial ans = new Polynomial();
		int p_len1 = this.degCoeff.length;
		int p_len2 = p.degCoeff.length;
		int len = Math.min(p_len1, p_len2);
		int i=0;
		while(i<len) {
			ans.setCoeff(i, this.degCoeff[i]+p.degCoeff[i]);
			i++;
		}
		while(i<p_len1) {
			ans.setCoeff(i, this.degCoeff[i]);
			i++;
		}
		while(i<p_len2) {
			ans.setCoeff(i, p.degCoeff[i]);
			i++;
		}
		return ans;	
	}
	
	private Polynomial sub(Polynomial p) { // Subtract two polynomial and return a new polynomial which has the ans
		Polynomial ans = new Polynomial();
		int p_len1 = this.degCoeff.length;
		int p_len2 = p.degCoeff.length;
		int len = Math.min(p_len1, p_len2);
		int i=0;
		while(i<len) {
			ans.setCoeff(i, this.degCoeff[i]-p.degCoeff[i]);
			i++;
		}
		while(i<p_len1) {
			ans.setCoeff(i, this.degCoeff[i]);
			i++;
		}
		while(i<p_len2) {
			ans.setCoeff(i, -p.degCoeff[i]);
			i++;
		}
		return ans;	
	}
	
	private Polynomial mul(Polynomial p) { // Multiply two polynomial and return a new polynomial which has the ans
		Polynomial ans = new Polynomial();
		for(int i=0; i<this.degCoeff.length; i++) {
			for(int j=0; j<p.degCoeff.length; j+=1) {
				int termDeg = i + j;
				int termCoeff = this.degCoeff[i]*p.degCoeff[j];
				int oldCoeff = ans.getCoeff(termDeg);
				ans.setCoeff(termDeg, termCoeff + oldCoeff);
			}
		}
		return ans;	
	}
	
	private static Polynomial takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] deg = new int[n];
		for(int i=0; i<n; i++)
			deg[i] = s.nextInt();

		int[] coeff = new int[n];
		for(int i=0; i<n; i++)
			coeff[i] = s.nextInt();

		Polynomial p = new Polynomial();
		for(int i=0; i<n; i++)
			p.setCoeff(deg[i], coeff[i]);
		return p;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Polynomial first = takeInput();
		Polynomial second = takeInput();
		
		int choice = s.nextInt();
		Polynomial result;
		
		switch(choice) {
		case 1: // add
			result = first.add(second);
			result.print();
			break;
		case 2: // sub
			result = first.sub(second);
			result.print();
			break;
		case 3: // mul
			result = first.mul(second);
			result.print();
			break;
		}
	}
}

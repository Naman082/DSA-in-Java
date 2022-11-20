package OOPsPrograms;

public class Fraction {
	
	private int nr;
	private int dr;
	private Fraction(int nr, int dr) { // constructor
		if(dr==0) {
			dr = 1; // Alternatively it could throw error
		}
		this.nr = nr;
		this.dr = dr;
		simplify();
	}
	
	private void simplify() {
		int gcd = 1;
		int smaller = Math.min(nr, dr);
		for(int i=2; i<=smaller; i++) {
			if(nr%i==0  && dr%i==0) {
				gcd = i;
			}
		}
		nr = nr/gcd;
		dr = dr/gcd;
	}
	
	private void increment() {
		nr += dr;
		simplify();
	}
	
	private void add(Fraction f2) {
		this.nr = (this.nr*f2.dr) + (this.dr*f2.nr);
		this.dr = this.dr*f2.dr;
		simplify();
	}
	
	private static Fraction add(Fraction f1, Fraction f2) {
		int newNR = (f1.nr*f2.dr) + (f1.dr*f2.nr);
		int newDR = (f1.dr*f2.dr);
		Fraction f3 = new Fraction(newNR ,newDR);
		return f3; // return new Fraction(newNR ,newDR);
	}
	
	private static Fraction sub(Fraction f1, Fraction f2) {
		int newNR = (f1.nr*f2.dr) - (f1.dr*f2.nr);
		int newDR = (f1.dr*f2.dr);
//		Fraction f4 = new Fraction(newNR ,newDR);
//		return f4; 
		return new Fraction(newNR ,newDR);
	}
	
	private static Fraction mul(Fraction f1, Fraction f2) {
		int newNR = f1.nr*f2.nr;
		int newDR = (f1.dr*f2.dr);
		Fraction f5 = new Fraction(newNR ,newDR);
		return f5; // return new Fraction(newNR ,newDR);
	}
	
	private void print() {
//		simplify();
		System.out.println(nr+"/"+dr);
	}
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(4,6);
		f1.print();// 2/3
		f1.increment();
		f1.print(); // 5/3 [2/3+1]
		Fraction f2 = new Fraction(4,8);
		f2.print();// 1/2
		f1.add(f2);
		f1.print(); // 13/6 [5/3+1/2]
		Fraction f3 = Fraction.add(f1, f2);
		f3.print(); // 8/3 [13/6+1/2]
		Fraction f4 = Fraction.sub(f1, f2);
		f4.print(); // 5/3 [13/6-1/2]
		Fraction f5 = Fraction.mul(f1, f2);
		f5.print(); // 13/12 [13/6*1/2]
		
	}
}

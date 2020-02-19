package abdeckung;

public class MyClass {


	int l,s,e;
	private int m = 400;
	private int n = 50;
	
	public MyClass (int L, int S, int E) {
		this.l = L;
		this.s = S;
		this.e = E;
	}
	
	public void validate (int L, int S, int E) {
		while(this.l > 0) {
			if(this.s + this.e > m) {
				System.out.print("Fehler 1");
			}else if (this.e > this.n) {
				System.out.print("Fehler 2");
			}else {
				this.s += this.e;
			}
			this.l --;
		}
	}

	public int getS() {
		return s;
	}
}

import java.util.Scanner;

public class Bai_4 {

	public static void main(String[] args) {
		double a,b,c,delta;
		Scanner Delta = new Scanner(System.in);
		System.out.print("Nhập a: ");
		a = Delta.nextDouble();
		System.out.print("Nhập b: ");
		b = Delta.nextDouble();
		System.out.print("Nhập c: ");
		c = Delta.nextDouble();
		delta = Math.pow(b, 2) - 4 * a * c;
		System.out.printf("Delta: %.2f \nCăn Delta: %.2f", delta, Math.sqrt(delta));
	}

}

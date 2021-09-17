import java.util.Scanner;

public class Bai_3 {

	public static void main(String[] args) {
		double canh,the_tich;
		System.out.print("Nhập độ dài cạnh của khối lập phương: ");
		Scanner V = new Scanner(System.in);
		canh = V.nextDouble();
		the_tich = Math.pow(canh, 3);
		System.out.printf("Thể tích hình lập phương: %.2f", the_tich);
	}

}

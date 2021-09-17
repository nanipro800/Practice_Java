import java.util.Scanner;

public class Bai_1 {

	public static void main(String[] args) {
		String hoTen;
		double diemTB;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Họ và Tên: ");
		hoTen = scanner.nextLine();
		System.out.print("Điểm trung bình: ");
		diemTB = scanner.nextDouble();
		System.out.printf("%s  %.2f điểm",hoTen,diemTB);
	}

}

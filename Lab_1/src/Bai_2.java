import java.util.Scanner;

public class Bai_2 {

	public static void main(String[] args) {
		double d,r,CV,DT,canh_nho_nhat;
		Scanner canh_hcn = new Scanner(System.in);
		System.out.print("Nhập chiều dài: ");
		d = canh_hcn.nextDouble();
		System.out.print("Nhập chiều rộng: ");
		r = canh_hcn.nextDouble();
		CV = (d+r)*2;
		DT = d*r;
		canh_nho_nhat = Math.min(d, r);
		System.out.printf("Chu vi HCN là: %.2f \n", CV);
		System.out.printf("Diện tích HCN là: %.2f \n", DT);
		System.out.printf("Cạnh nhỏ nhất là: %.2f", canh_nho_nhat);
	}

}

package nguyen_thanhnhan;

public class SanPham {
	// Các thuộc tính
	private String MaSP;
	private String TenSP;
	private Double DonGia;
	
	// Xây hàm tạo (được gọi khi ta khai báo một đối tượng của lớp SanPham, từ khoá new)
	
	// Hàm không có tham số
	public SanPham() {
		this.MaSP = "";
		this.TenSP = "";
		this.DonGia = 0.0;
	}
	
	// Hàm có tham số
	public SanPham(String MaSP, String TenSP, Double DonGia) {
		this.MaSP = MaSP;
		this.TenSP = TenSP;
		this.DonGia = DonGia;
	}

	// Các Getter (để lấy giá trị các thuộc tính)
	public String getMaSP() {
		return MaSP;
	}

	public String getTenSP() {
		return TenSP;
	}

	public Double getDonGia() {
		return DonGia;
	}

	// Các setter (để gán giá trị cho các thuộc tính)
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public void setDonGia(Double donGia) {
		DonGia = donGia;
	}
	
}

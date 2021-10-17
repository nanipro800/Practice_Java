package nguyen_thanhnhan;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.spec.DSAGenParameterSpec;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ChuongTrinhChinh {
	// Khai báo danh sách ở đây
	ArrayList<SanPham> dsSP;
	
	// Khai báo các điều khiển
	
	private JFrame frame;
	private JLabel lblMaSP;
	private JLabel lblTenSP;
	private JLabel lblDonGia;
	private JLabel lblTrangThai, lblDanhSachSP;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtDonGia;
	private JButton btnThem, btnTimKiem, btnXoa, btnSua;
	private JTextArea textAreaDanhSachSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuongTrinhChinh window = new ChuongTrinhChinh();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChuongTrinhChinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EA3n ph\u1EA9m", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(49, 24, 435, 181);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblMaSP = new JLabel("Mã sản phẩm");
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSP.setBounds(21, 44, 87, 16);
		panel.add(lblMaSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(126, 44, 151, 20);
		panel.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		lblTenSP = new JLabel("Tên sản phẩm:");
		lblTenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenSP.setBounds(21, 81, 87, 16);
		panel.add(lblTenSP);
		
		txtTenSP = new JTextField();
		txtTenSP.setBounds(126, 81, 151, 20);
		panel.add(txtTenSP);
		txtTenSP.setColumns(10);
		
		lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDonGia.setBounds(21, 120, 87, 16);
		panel.add(lblDonGia);
		
		txtDonGia = new JTextField();
		txtDonGia.setBounds(126, 120, 151, 20);
		panel.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			// Sự kiện xảy ra khi nhấn nút Thêm
			public void actionPerformed(ActionEvent e) {
				ThemSanPham(dsSP);
				HienDanhSachSP(dsSP);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.setBounds(298, 26, 99, 23);
		panel.add(btnThem);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			// Sự kiện xảy ra khi nhấn nút Tìm kiếm
			public void actionPerformed(ActionEvent e) {
				TimKiemSanPham(dsSP);
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiem.setBounds(298, 60, 99, 23);
		panel.add(btnTimKiem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			// Sự kiện xảy ra khi nhấn nút Xoá
			public void actionPerformed(ActionEvent e) {
				XoaSanPham(dsSP);
				HienDanhSachSP(dsSP);
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.setBounds(298, 94, 99, 23);
		panel.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			// Sự kiện xảy ra khi nhấn nút Sửa
			public void actionPerformed(ActionEvent e) {
				SuaSanPham(dsSP);
				HienDanhSachSP(dsSP);
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSua.setBounds(298, 128, 99, 23);
		panel.add(btnSua);
		
		// Xin mới danh sách
		dsSP = new ArrayList<SanPham>();
		
		textAreaDanhSachSP = new JTextArea();
		textAreaDanhSachSP.setEditable(false);
		textAreaDanhSachSP.setBounds(49, 272, 435, 165);
		frame.getContentPane().add(textAreaDanhSachSP);
		
		lblTrangThai = new JLabel("...");
		lblTrangThai.setForeground(Color.RED);
		lblTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(309, 216, 175, 22);
		frame.getContentPane().add(lblTrangThai);
		
		lblDanhSachSP = new JLabel("Danh sách sản phẩm");
		lblDanhSachSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDanhSachSP.setBounds(49, 242, 133, 16);
		frame.getContentPane().add(lblDanhSachSP);
	}
	// End initialize()
	
	public void ThemSanPham(ArrayList<SanPham> dsSP) {
		String maSP = txtMaSP.getText();
		String tenSP = txtTenSP.getText();
		String strdonGia = txtDonGia.getText();
		boolean checkmaSP = false;
		try {
			if(maSP.isBlank() || tenSP.isBlank() || strdonGia.isBlank()) {
				throw new Exception();
			}
			else {
				// Chuyển chuỗi sang số và báo lỗi nếu nhập số âm
				double donGia = Double.parseDouble(strdonGia);
				if(donGia<0) {
					throw new Exception();
				}
				// Kiểm tra maSP có tồn tại chưa
				for(int i=0; i<dsSP.size(); i++) {
					if(maSP.equals(dsSP.get(i).getMaSP())) {
						checkmaSP = true;
					}
				}
				// Thông báo
				if(checkmaSP == true) {
					JOptionPane.showMessageDialog(frame, "Mã sản phẩm đã tồn tại", "Kết quả", JOptionPane.ERROR_MESSAGE);
				}
				else {
					// Gói vào một biến kiểu SanPham
					SanPham sp = new SanPham(maSP, tenSP, donGia);
					// Thêm vào danh sách
					dsSP.add(sp);
					lblTrangThai.setText("Đã thêm vào danh sách");
					txtMaSP.setText("");
					txtTenSP.setText("");
					txtDonGia.setText("");				
				}
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			lblTrangThai.setText("Dữ liệu không hợp lệ");
		}
	}
	
	public void HienDanhSachSP(ArrayList<SanPham> dsSP) {
		if(dsSP.isEmpty()) {
			textAreaDanhSachSP.setText("Danh sách rỗng");
		}
		else {
			textAreaDanhSachSP.setText("");
			for(SanPham sp: dsSP) {
				String dongTrenTextArea = "";
				dongTrenTextArea = sp.getMaSP() + " --- " + sp.getTenSP() + " --- " + sp.getDonGia() + "\n";
				// Đưa lên TextArea
				textAreaDanhSachSP.append(dongTrenTextArea);}
			}
		}

	public void TimKiemSanPham(ArrayList<SanPham> dsSP) {
		String strMaSP = txtMaSP.getText();
		boolean result = false;
		int pos = 0;
		for(int i=0; i<dsSP.size(); i++) {
			if(strMaSP.equals(dsSP.get(i).getMaSP())){
				result = true;
				pos = i;
				break;
			}
		}
		if(result == true) {
			lblTrangThai.setText("");
			JOptionPane.showMessageDialog(frame, "Sản phẩm có trong danh sách", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			lblTrangThai.setText("");
			JOptionPane.showMessageDialog(frame, "Sản phẩm không có trong danh sách", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void XoaSanPham(ArrayList<SanPham> dsSP) {
		String strMaSP = txtMaSP.getText();
		boolean result = false;
		for(int i=0; i<dsSP.size(); i++) {
			if(strMaSP.equals(dsSP.get(i).getMaSP())){
				dsSP.remove(i);
				result = true;
				break;
			}
		}
		if(result == true) {
			lblTrangThai.setText("");
			JOptionPane.showMessageDialog(frame, "Xoá thành công", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			lblTrangThai.setText("");
			JOptionPane.showMessageDialog(frame, "Sản phầm cần xoá không có trong danh sách", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void SuaSanPham(ArrayList<SanPham> dsSP) {
		try {
			String strMaSP = txtMaSP.getText();
			boolean result = false;
			for(int i=0; i<dsSP.size(); i++) {
				if(strMaSP.equals(dsSP.get(i).getMaSP())){
					// Kiểm tra dữ liệu nhập vào không trống mới sửa thông tin
					// Có thể sửa riêng hoặc sửa cả 2
					String strDonGia = txtDonGia.getText();
					if(!strDonGia.isBlank()) {
						Double donGia = Double.parseDouble(strDonGia);
						// Nếu donGia không phải là kiểu số dương thì không sửa
						if(donGia<0) {
							throw new Exception();
						}
						else {
							dsSP.get(i).setDonGia(donGia);;
						}
					}
					String strTenSP = txtTenSP.getText();
					if(!strTenSP.isBlank()) {
						dsSP.get(i).setTenSP(strTenSP);
					}
					result = true;
					break;
				}
			}
			if(result==true) {
				lblTrangThai.setText("");
				JOptionPane.showMessageDialog(frame, "Sửa thành công", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				lblTrangThai.setText("");
				JOptionPane.showMessageDialog(frame, "Sản phầm cần sửa không có trong danh sách", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			lblTrangThai.setText("Đơn giá phải là kiểu số dương");
		}
	}
}

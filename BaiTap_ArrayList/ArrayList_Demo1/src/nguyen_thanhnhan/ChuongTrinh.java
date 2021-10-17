package nguyen_thanhnhan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChuongTrinh {
	// Khai báo ArrayList ở đây
	ArrayList <String> dsTen;
	
	// Khai báo các điều khiển
	JLabel lblHoVaTen, lblTimKiem;
	JButton btnThemTen, btnTimKiem;
	JButton btnHienDanhSach;
	JTextArea textAreaDanhSachTen;
	JLabel lblTrangThai_Ten, lblTrangThai_TimKiem;
	
	private JFrame frameMain;
	private JTextField txtHoVaTen;
	private JTextField txtTimKiem;
	private JTextArea textAreaDanhSachTen_2;
	private JLabel lblHienDanhSachTen_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuongTrinh window = new ChuongTrinh();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChuongTrinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setForeground(Color.RED);
		frameMain.setTitle("Demo ArrayList");
		frameMain.setBounds(100, 100, 524, 400);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		
		lblHoVaTen = new JLabel("Họ và Tên:");
		lblHoVaTen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoVaTen.setBounds(10, 27, 104, 37);
		frameMain.getContentPane().add(lblHoVaTen);
		
		txtHoVaTen = new JTextField();
		txtHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHoVaTen.addKeyListener(new KeyAdapter() {
			@Override
			// Chữ thông báo trạng thái thay đổi khi đang nhập từ bàn phím
			public void keyPressed(KeyEvent e) {
				lblTrangThai_Ten.setText("Tôi đang đợi bạn...");
			}
		});
		txtHoVaTen.setBounds(124, 35, 226, 20);
		frameMain.getContentPane().add(txtHoVaTen);
		txtHoVaTen.setColumns(10);
		
		// Khởi tạo ArrayList
		dsTen = new ArrayList<String>();
		
		btnThemTen = new JButton("Thêm");
		btnThemTen.addActionListener(new ActionListener() {
			// Sự kiện xảy ra khi nhấn nút Thêm
			public void actionPerformed(ActionEvent e) {
				// Sử dụng ArrayList là biến toàn cục
				ThemVaoDanhSach(dsTen);
				HienDanhSach(dsTen, textAreaDanhSachTen_2);
				
			}
		});
		btnThemTen.setBounds(370, 34, 89, 23);
		frameMain.getContentPane().add(btnThemTen);
		
		btnHienDanhSach = new JButton("Hiện danh sách");
		btnHienDanhSach.addActionListener(new ActionListener() {
			// Sự kiện xảy ra khi nhấn nút Hiện danh sách
			public void actionPerformed(ActionEvent e) {
				HienDanhSach(dsTen, textAreaDanhSachTen);
			}
		});
		btnHienDanhSach.setBounds(60, 142, 134, 23);
		frameMain.getContentPane().add(btnHienDanhSach);
		
		textAreaDanhSachTen = new JTextArea();
		textAreaDanhSachTen.setBounds(10, 176, 226, 153);
		frameMain.getContentPane().add(textAreaDanhSachTen);
		
		lblTrangThai_Ten = new JLabel("Hiện trạng thái thêm");
		lblTrangThai_Ten.setForeground(Color.RED);
		lblTrangThai_Ten.setBounds(237, 66, 114, 14);
		frameMain.getContentPane().add(lblTrangThai_Ten);
		
		lblTimKiem = new JLabel("Tìm Họ và Tên:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTimKiem.setBounds(10, 88, 104, 14);
		frameMain.getContentPane().add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTimKiem.setBounds(124, 85, 226, 20);
		frameMain.getContentPane().add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			// Sự kiện xảy ra khi nhấn nút Tìm kiếm
			public void actionPerformed(ActionEvent e) {
				boolean result = false;
				if(txtTimKiem.getText().isEmpty()) {
					lblTrangThai_TimKiem.setText("Chưa nhập tên");
				}
				else {
					lblTrangThai_TimKiem.setText("");
					String sName = txtTimKiem.getText();
					for(int i=0; i<dsTen.size(); i++)
					{
						String sTen = dsTen.get(i);
						if(sTen.equals(sName))
						{
							result = true;
							break;
						}
						else {
							result = false;
						}
					}
					if(result== true) {
						JOptionPane.showMessageDialog(frameMain, sName + " " + "có trong danh sách", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(frameMain, sName + " " + "không có trong danh sách", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnTimKiem.setBounds(370, 84, 89, 23);
		frameMain.getContentPane().add(btnTimKiem);
		
		textAreaDanhSachTen_2 = new JTextArea();
		textAreaDanhSachTen_2.setBounds(261, 176, 226, 153);
		frameMain.getContentPane().add(textAreaDanhSachTen_2);
		
		lblHienDanhSachTen_2 = new JLabel("Hiện ngay khi nhấn Thêm");
		lblHienDanhSachTen_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHienDanhSachTen_2.setBounds(298, 142, 161, 23);
		frameMain.getContentPane().add(lblHienDanhSachTen_2);
		
		lblTrangThai_TimKiem = new JLabel("");
		lblTrangThai_TimKiem.setForeground(Color.RED);
		lblTrangThai_TimKiem.setBounds(236, 116, 114, 14);
		frameMain.getContentPane().add(lblTrangThai_TimKiem);
		// End of initialize()
	}
	
	// Đưa các khai báo ở trong Frame ra bên ngoài initialize() để sử dụng được trong phương thức
	
	public void ThemVaoDanhSach(ArrayList<String> ds) {
		// Lấy dữ liệu từ điều khiển
		String hoten = txtHoVaTen.getText();
		if(hoten.isEmpty()) {
			lblTrangThai_Ten.setText("Chưa nhập tên");
		}
		else {
			// Thêm vào danh sách 
			ds.add(hoten);
			// Xoá nội dung trên điều khiển đi, để cho việc thêm sau được dễ dàng
			txtHoVaTen.setText("");
			// Cập nhật trạng thái
			lblTrangThai_Ten.setText("Đã thêm xong vào danh sách");
		}
		
	}
	public void HienDanhSach(ArrayList<String> ds, JTextArea textAreaDanhSachTen) {
		if(ds.isEmpty()) {
			textAreaDanhSachTen.setText("Danh sách rỗng");
		}
		else {
			textAreaDanhSachTen.setText("");
			for (int index=0; index<ds.size(); index++) {
				// Lấy giá trị ở vị trí index, cất vào biến sTen
				String sTen = ds.get(index);
				// Nạp vào điều khiển hiển thị TextArea
				textAreaDanhSachTen.append(sTen + "\n");
		}
		}
	//  Cách 2
	//  for (String sTen: ds) {
	//		textAreaDanhSachTen.append(sTen);
	// }
	}
}

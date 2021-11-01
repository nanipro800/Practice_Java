import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CuaSoChinh {

	private JFrame frame;
	private JTable tableKhoa;
	DefaultTableModel dataModel_Khoa;
	private JTextField txtMaKhoa;
	private JTextField txtTenKhoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuaSoChinh window = new CuaSoChinh();
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
	public CuaSoChinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnKetNoi = new JButton("Kết nối DB");
		btnKetNoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection KN = KetNoiDB.MoKetNoi("qlsinhvien", "root", "");
				if(KN==null)
					JOptionPane.showMessageDialog(frame, "Kết nối thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(frame, "Kết nối thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnKetNoi.setBounds(390, 24, 98, 23);
		frame.getContentPane().add(btnKetNoi);
		
		JButton btnLayDuLieu = new JButton("Lấy toàn bộ dữ liệu ở bảng Khoa");
		// DefaultTableModel - Các phương thức addColumn - addRow
		DefaultTableModel dataModel_Khoa = new DefaultTableModel();
		// Qui định Cột
		dataModel_Khoa.addColumn("Mã Khoa");
		dataModel_Khoa.addColumn("Tên Khoa");
		
		btnLayDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Phải mở XAMPP Control Panel và Start Apache + MySQL mới kết nối được CSDL
				// Nhớ đảm bảo rằng, đã kết nối đến CSDL
				// Nếu sợ quên
				// B1. Kết nối lại
				Connection ketnoiDB = KetNoiDB.MoKetNoi("qlsinhvien", "root", "");
				try 
				{
					// B2. Tạo đối tượng Statement để tương tác với CSDL
					// Import java.sql.Statement;
					Statement stmt = ketnoiDB.createStatement();
					// B3. Tạo xâu chứa câu truy vấn
					String sqlSelectKhoa = "Select * FROM khoa";
					// B4. Thực thi truy vấn
					// Import java.sql.ResultSet;
					ResultSet tblKhoa = stmt.executeQuery(sqlSelectKhoa);
					// B5. Hiện kết quả, hiện ra màn hình Console và JTable
					while(tblKhoa.next()) // Trong khi mà còn next được (còn dòng)
					{
						// Xử lý mỗi dòng
						// Lấy dữ liệu từng cột
						String maKhoa = tblKhoa.getString("MaKhoa"); // Cột số 0
						String tenKhoa = tblKhoa.getString("TenKhoa"); // Cột số 1
						System.out.println(maKhoa + " - " + tenKhoa + "\n");

						// Thêm các dòng dữ liệu - In vào bảng
						Vector row = new Vector<>(); // Thêm dữ liệu từng cột
						row.add(maKhoa);
						row.add(tenKhoa);
						dataModel_Khoa.addRow(row);
					}
					// Cập nhật Model cho bảng
					tableKhoa.setModel(dataModel_Khoa);
					tableKhoa.updateUI();
					
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// B6. Đóng kết nối
				try 
				{
					ketnoiDB.close();
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLayDuLieu.setBounds(60, 92, 218, 23);
		frame.getContentPane().add(btnLayDuLieu);
		
		tableKhoa = new JTable();
		tableKhoa.addMouseListener(new MouseAdapter() {
			// Xử lý sự kiện khi nhấn vào một hàng trong bảng
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lấy vị trí
				int vitri = tableKhoa.getSelectedRow();
				// Lấy giá trị ở vị trí được chọn theo cột
				txtMaKhoa.setText((String) dataModel_Khoa.getValueAt(vitri, 0));
				txtTenKhoa.setText((String) dataModel_Khoa.getValueAt(vitri, 1));
		}});
		tableKhoa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableKhoa.setBounds(60, 126, 326, 189);
		frame.getContentPane().add(tableKhoa);
		
		JLabel lblMaKhoa = new JLabel("Mã Khoa:");
		lblMaKhoa.setBounds(28, 28, 60, 14);
		frame.getContentPane().add(lblMaKhoa);
		
		JLabel lblTenKhoa = new JLabel("Tên Khoa:");
		lblTenKhoa.setBounds(28, 64, 60, 14);
		frame.getContentPane().add(lblTenKhoa);
		
		txtMaKhoa = new JTextField();
		txtMaKhoa.setBounds(98, 25, 132, 20);
		frame.getContentPane().add(txtMaKhoa);
		txtMaKhoa.setColumns(10);
		
		txtTenKhoa = new JTextField();
		txtTenKhoa.setBounds(98, 61, 288, 20);
		frame.getContentPane().add(txtTenKhoa);
		txtTenKhoa.setColumns(10);
		
		JButton btnThemKhoa = new JButton("Thêm mới Khoa");
		btnThemKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu
				String maKhoa = txtMaKhoa.getText();
				String tenKhoa = txtTenKhoa.getText();
				// Thao tác với CSDL
				// B1.
				Connection ketnoiDB = KetNoiDB.MoKetNoi("qlsinhvien", "root", "");
				try 
				{
					if(maKhoa.isBlank() || tenKhoa.isBlank()) {
						throw new Exception();
					}
					else 
					{
						// B2.
						Statement lenh = ketnoiDB.createStatement();
						// B3.
						// Copy bên localhost bỏ dấu `
						String sqlThemKhoa = "INSERT INTO khoa(MaKhoa, TenKhoa) VALUES ('" + maKhoa + "','" + tenKhoa +"')";
						// B4.
						lenh.executeUpdate(sqlThemKhoa);
						// B5. Hiện lên bảng
						Vector row = new Vector<>(); // Thêm dữ liệu từng cột
						row.add(maKhoa);
						row.add(tenKhoa);
						dataModel_Khoa.addRow(row);
						// Hiện thông báo
						JOptionPane.showMessageDialog(frame, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						// Cập nhật Model cho bảng
						tableKhoa.setModel(dataModel_Khoa);
						tableKhoa.updateUI();
						// Hoặc
						// tableKhoa.fireTableDataChanged();
					}
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (Exception ex1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "Nhập đầy đủ các ô trước khi nhấn Thêm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnThemKhoa.setBounds(240, 24, 126, 23);
		frame.getContentPane().add(btnThemKhoa);
		
		JButton btnXoaKhoa = new JButton("Xóa");
		btnXoaKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu
				String maKhoa = txtMaKhoa.getText();
				boolean result = false;
				// Thao tác với CSDL
				// B1.
				Connection ketnoiDB = KetNoiDB.MoKetNoi("qlsinhvien", "root", "");
				// Nhâp mã cần xoá hoặc click vào hàng trong table rồi bấm Xóa vì có sự kiện mouseClicked khi nhấn vào hàng trong table ở trên
				try 
				{
					if(maKhoa.isBlank()) {
						throw new Exception();
					}
					for(int i=0; i<tableKhoa.getRowCount(); i++) {
						// Phải nhấn Lấy toàn bộ dữ liệu ở bảng Khoa trước mới hiện maKhoa để so sánh
						// Nếu maKhoa nhập vào = maKhoa trong bảng thì ngắt vòng lặp
						if(maKhoa.equals(dataModel_Khoa.getValueAt(i, 0))) // i là vị trí hàng, 0 là cột 0 = Mã Khoa, 
						{
							result = true;
							break;
						}
					}
					if(result == true) {
						// B2.
						Statement lenh = ketnoiDB.createStatement();
						// B3.
						// Copy bên localhost bỏ dấu `
						String sqlXoaKhoa = "DELETE FROM khoa WHERE MaKhoa ='" + maKhoa +"'";
						// B4.
						lenh.executeUpdate(sqlXoaKhoa);
						JOptionPane.showMessageDialog(frame, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(frame, "Nhấn Lấy toàn bộ dữ liệu ở bảng Khoa để cập nhật lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						// Cập nhật Model cho bảng
					//	tableKhoa.setModel(dataModel_Khoa);
					//	tableKhoa.updateUI();
						// Hoặc
						// tableKhoa.fireTableDataChanged();
					}
					else {
						JOptionPane.showMessageDialog(frame, "Mã khoa không tồn tại trong bảng", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (Exception ex1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "Nhập mã khoa hoặc chọn hàng cần xoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnXoaKhoa.setBounds(297, 92, 89, 23);
		frame.getContentPane().add(btnXoaKhoa);
	}
}

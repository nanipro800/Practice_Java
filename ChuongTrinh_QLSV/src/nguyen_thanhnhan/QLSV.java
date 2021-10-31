package nguyen_thanhnhan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class QLSV {

	JPanel panel_Info, panel_DS;
	JButton btnThem, btnLuu, btnXoa;
	JComboBox<String> comboLop;
	private JFrame frame;
	private JTextField txtMaSV;
	private JTextField txtTen;
	private JTextField txtNamSinh;
	private JTextField txtDiaChi;
	private JTable table_DSSV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSV window = new QLSV();
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
	public QLSV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(178, 11, 277, 22);
		frame.getContentPane().add(lblTitle);
		
		panel_Info = new JPanel();
		panel_Info.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 255)), "Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Info.setBounds(10, 50, 616, 233);
		frame.getContentPane().add(panel_Info);
		panel_Info.setLayout(null);
		
		JLabel lblMaSV = new JLabel("Mã: ");
		lblMaSV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaSV.setBounds(134, 28, 46, 14);
		panel_Info.add(lblMaSV);
		
		JLabel lblTen = new JLabel("Tên:");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen.setBounds(134, 53, 31, 17);
		panel_Info.add(lblTen);
		
		JLabel lblNamSinh = new JLabel("Năm sinh:");
		lblNamSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNamSinh.setBounds(111, 81, 69, 17);
		panel_Info.add(lblNamSinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiaChi.setBounds(121, 109, 50, 17);
		panel_Info.add(lblDiaChi);
		
		JLabel lblLop = new JLabel("Lớp:");
		lblLop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLop.setBounds(134, 137, 31, 17);
		panel_Info.add(lblLop);
		
		txtMaSV = new JTextField();
		txtMaSV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaSV.setBounds(190, 27, 245, 20);
		panel_Info.add(txtMaSV);
		txtMaSV.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTen.setColumns(10);
		txtTen.setBounds(190, 53, 245, 20);
		panel_Info.add(txtTen);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(190, 81, 182, 20);
		panel_Info.add(txtNamSinh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(190, 109, 245, 20);
		panel_Info.add(txtDiaChi);
		
		JLabel lblNamsinh_Notes = new JLabel("(dd/MM/yyyy)");
		lblNamsinh_Notes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNamsinh_Notes.setBounds(382, 82, 82, 16);
		panel_Info.add(lblNamsinh_Notes);
		
		comboLop = new JComboBox<String>();
		comboLop.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboLop.setBounds(190, 136, 182, 22);
		panel_Info.add(comboLop);
		// DefaultComboBoxModel - Các phương thức add - remove
		DefaultComboBoxModel<String> lop = new DefaultComboBoxModel<String>();
		lop.addElement("60CNTT-1");
		lop.addElement("60CNTT-2");
		lop.addElement("61CNTT-CLC");
		lop.addElement("61CNTT-1");
		lop.addElement("61CNTT-2");
		comboLop.setModel(lop);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(176, 174, 75, 33);
		panel_Info.add(btnThem);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuu.setBounds(261, 174, 75, 33);
		panel_Info.add(btnLuu);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(346, 174, 69, 33);
		panel_Info.add(btnXoa);
		
		panel_DS = new JPanel();
		panel_DS.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 255)), "Danh s\u00E1ch sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_DS.setBounds(10, 294, 614, 203);
		frame.getContentPane().add(panel_DS);
		panel_DS.setLayout(null);
		
		table_DSSV = new JTable();
		table_DSSV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_DSSV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_DSSV.setBounds(10, 22, 594, 170);
		panel_DS.add(table_DSSV);
		
		DefaultTableModel data = new DefaultTableModel();
		// Qui định Cột
		data.addColumn("Mã");
		data.addColumn("Tên");
		data.addColumn("Năm sinh");
		data.addColumn("Địa chỉ");
		data.addColumn("Lớp");
		// Thêm các dòng dữ liệu
		Vector<String> title = new Vector<String>(); // Thêm dữ liệu từng cột
		title.add("Mã");
		title.add("Tên");
		title.add("Năm sinh");
		title.add("Địa chỉ");
		title.add("Lớp");
		data.addRow(title);
		
		Vector<String> hangX = new Vector<String>();
		hangX.add("60234060");
		hangX.add("Lâm Sung");
		hangX.add("01/01/2000");
		hangX.add("Nha Trang");
		hangX.add("60CNTT-1");
		data.addRow(hangX);
		
		hangX = new Vector<String>();
		hangX.add("61234050");
		hangX.add("Tống Giang");
		hangX.add("21/02/2001");
		hangX.add("Hồ Chí Minh");
		hangX.add("61CNTT-1");
		data.addRow(hangX);
		
		hangX = new Vector<String>();
		hangX.add("60334040");
		hangX.add("Lý Quỳ");
		hangX.add("01/01/2000");
		hangX.add("Hà Nội");
		hangX.add("60CNTT-1");
		data.addRow(hangX);
		
		table_DSSV.setModel(data);
		
		// Xử lý sự kiện cho nút Thêm
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. Lấy dữ liệu
				String maSV = txtMaSV.getText();
				String ten = txtTen.getText();
				String diachi = txtDiaChi.getText();
				String lop = comboLop.getSelectedItem().toString();
				try 
				{
					if(maSV.isBlank() || ten.isBlank() || diachi.isBlank()) {
						throw new Exception();
					}
					else 
					{
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				        String strDate = txtNamSinh.getText();
				        Date namsinh;
						namsinh = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
						
						// 2. Tạo một dòng để thêm vào bảng
						Vector hangX = new Vector<>();
						hangX.add(maSV);
						hangX.add(ten);
						hangX.add(strDate);
						hangX.add(diachi);
						hangX.add(lop);
						// 3. Thêm dữ liệu vào bảng, để khai báo DefaultTableModel data ở trên để chạy được
						data.addRow(hangX);
						// Hiện thông báo
						JOptionPane.showMessageDialog(frame, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						// 4. Update lại View = fireTableDataChanged
						data.fireTableDataChanged();
						
						txtMaSV.setText("");
						txtTen.setText("");
						txtNamSinh.setText("");
						txtDiaChi.setText("");
						comboLop.setSelectedIndex(0);
					}
				}
				catch (ParseException e1) {
					// TODO Auto-generated catch block
					txtNamSinh.setText("Nhập sai định dạng");
				} 
				catch (Exception ex1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "Nhập đầy đủ các ô trước khi nhấn Thêm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		// Xử lý sự kiện cho nút Lưu
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// Xử lý sự kiện cho nút Xóa
		btnXoa.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				try 
				{
					// Lấy vị trí
					int vitri = table_DSSV.getSelectedRow();
					// Xoá hàng tại vị trí đang chọn
					data.removeRow(vitri);
					// Hiện thông báo
					JOptionPane.showMessageDialog(frame, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					// Update lại View = fireTableDataChanged
					data.fireTableDataChanged();
				}
				catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame, "Chọn hàng cần xoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		// Xử lý sự kiện khi lia chuột vào một hàng trong bảng
		table_DSSV.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
				// Lấy vị trí
				int vitri = table_DSSV.getSelectedRow();
				// Lấy giá trị ở vị trí được chọn theo cột
				txtMaSV.setText((String) data.getValueAt(vitri, 0));
				txtTen.setText((String) data.getValueAt(vitri, 1));
				txtNamSinh.setText((String) data.getValueAt(vitri, 2));
				txtDiaChi.setText((String) data.getValueAt(vitri, 3));
				comboLop.setSelectedItem(data.getValueAt(vitri, 4));	
			}
		});
	}
}

package nguyen_thanhnhan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.*;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DSSV_main {

	//Khai báo danh sách ArrayList
	ArrayList<String> dsTen ;
	
	//Khai báo các điều khiển
	private JFrame frameMain;
	private JTextField txtHoten;
	JLabel lbHoten, lbTrangThai;
	JButton btnThem, btnHienDs;
	JTextArea textAreaDanhSach;
	private JLabel lbDanhSach;
	private JTextArea textAreaDanhSach2;
	private JLabel lbTimkiem;
	private JTextField txtTimkiem;
	private JButton btnTimkiem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DSSV_main window = new DSSV_main();
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
	public DSSV_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("DemoArrayList");
		frameMain.setBounds(100, 100, 645, 499);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		
		lbHoten = new JLabel("Họ và tên:");
		lbHoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbHoten.setHorizontalAlignment(SwingConstants.TRAILING);
		lbHoten.setBounds(34, 35, 91, 27);
		frameMain.getContentPane().add(lbHoten);
		
		txtHoten = new JTextField();
		//Bắt sự kiện nhấn phím 
		txtHoten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lbTrangThai.setText("Đang đợi nhập vào......");
			}
		});
		txtHoten.setBounds(196, 37, 217, 27);
		frameMain.getContentPane().add(txtHoten);
		txtHoten.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		dsTen = new ArrayList<String>();
		
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemVaoDanhSach(dsTen); 
				HienDanhSach(dsTen, textAreaDanhSach2);
			}
		});
		btnThem.setBounds(434, 37, 88, 27);
		frameMain.getContentPane().add(btnThem);
		
		btnHienDs = new JButton("Hiện danh sách");
		btnHienDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienDanhSach(dsTen, textAreaDanhSach);
			}
		});
		btnHienDs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHienDs.setBounds(59, 198, 181, 27);
		frameMain.getContentPane().add(btnHienDs);
		
		textAreaDanhSach = new JTextArea(5,20);
		textAreaDanhSach.setBounds(22, 235, 256, 170);
		frameMain.getContentPane().add(textAreaDanhSach);
		
		lbTrangThai = new JLabel("Đang đợi nhập xong......");
		lbTrangThai.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbTrangThai.setForeground(Color.BLUE);
		lbTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		lbTrangThai.setBounds(252, 72, 146, 20);
		frameMain.getContentPane().add(lbTrangThai);
		
		lbDanhSach = new JLabel("Danh sách tên");
		lbDanhSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbDanhSach.setBounds(404, 200, 105, 23);
		frameMain.getContentPane().add(lbDanhSach);
		
		textAreaDanhSach2 = new JTextArea();
		textAreaDanhSach2.setBounds(316, 235, 288, 169);
		frameMain.getContentPane().add(textAreaDanhSach2);
		
		lbTimkiem = new JLabel("Nhập họ tên cần tìm:");
		lbTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTimkiem.setBounds(59, 102, 217, 27);
		frameMain.getContentPane().add(lbTimkiem);
		
		txtTimkiem = new JTextField();
		txtTimkiem.setColumns(10);
		txtTimkiem.setBounds(196, 102, 217, 27);
		frameMain.getContentPane().add(txtTimkiem);
		
		btnTimkiem = new JButton("Tìm kiếm");
		//Sự kiện tìm kiếm
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTimkiem = false;
				if (txtTimkiem.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frameMain, "Bạn chưa nhập tên cần tìm!", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
				} else {
					for(int i=0; i<dsTen.size(); i++) {
						String ten = dsTen.get(i);
						if (ten.equalsIgnoreCase(txtTimkiem.getText())){
							isTimkiem = true;
							break;
						}
					}
					if(isTimkiem) {
						JOptionPane.showMessageDialog(frameMain, "Tên bạn cần tìm có trong danh sách!", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frameMain, "Tên bạn cần tìm không có trong danh sách!", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				txtTimkiem.setText("");
			}
		});
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimkiem.setBounds(434, 102, 91, 28);
		frameMain.getContentPane().add(btnTimkiem);
	}
	//Hàm thêm danh sách
	public void ThemVaoDanhSach(ArrayList<String> ds) {
		//Lấy dữ liệu từ điều khiển txtHoten
		String hoten = txtHoten.getText();
		if (hoten.isEmpty()) {
			lbTrangThai.setText("Bạn chưa nhập tên!");
		} else {
			//Thêm vào danh sách tên
			ds.add(hoten);
			//Xóa nội dung trên txtHoten
			txtHoten.setText("");
			//Cập nhập trạng thái
			lbTrangThai.setText("Đã thêm vào danh sách!");
		}

	}
	public void HienDanhSach(ArrayList<String> ds, JTextArea textAreaDS) {			
		textAreaDS.setText("");
		for(int i=0; i< ds.size(); i++) {
			String ten = ds.get(i);
			//đưa ten vào điều khiển thị textArea
			textAreaDS.append(ten + "\n");
		}
		//Cách 2
//		for(String ten : ds) {
//			textAreaDanhSach.append(ten);
//		}
	}
}
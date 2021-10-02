package nguyen_thanhnhan;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;

public class Operator extends Frame {
	// Các thuộc tính
	Label lblA, lblB, lblKQ;
	TextField txtA, txtB, txtKQ;
	Button btnCong, btnTru, btnNhan, btnChia;
	
	// Tạo ra 1 font để setFont cho các thuộc tính
	Font font = new Font("Courier", Font.PLAIN,18);
	// Hàm khởi tạo
	public Operator() {
		// Sử dụng BoxLayout theo trục dọc
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(650, 200, 450, 450);
		setTitle("Operator");
		setVisible(true);
		
		// Khởi tạo các điều khiển
		lblA = new Label("Nhập số A:");
		lblA.setFont(font);
		lblA.setBackground(Color.gray);
		lblA.setForeground(Color.white);
		
		lblB = new Label("Nhập số B:");
		lblB.setFont(font);
		lblB.setBackground(Color.gray);
		lblB.setForeground(Color.white);
		
		lblKQ = new Label("Kết quả:");
		lblKQ.setFont(font);
		lblKQ.setBackground(Color.gray);
		lblKQ.setForeground(Color.white);
		
		txtA = new TextField();
		txtA.setFont(font);
		txtA.setBackground(Color.white);
		txtA.setForeground(Color.black);
		
		txtB = new TextField();
		txtB.setFont(font);
		txtB.setBackground(Color.white);
		txtB.setForeground(Color.black);
		
		txtKQ = new TextField();
		txtKQ.setFont(font);
		txtKQ.setBackground(Color.white);
		txtKQ.setForeground(Color.black);

		btnCong = new Button("+");
		btnCong.setFont(font);
		btnCong.setBackground(Color.cyan);
		
		btnTru = new Button("-");
		btnTru.setFont(font);
		btnTru.setBackground(Color.cyan);
		
		btnNhan = new Button("*");
		btnNhan.setFont(font);
		btnNhan.setBackground(Color.cyan);
		
		
		btnChia = new Button("/");
		btnChia.setFont(font);
		btnChia.setBackground(Color.cyan);
		
		// Đưa các điều khiển vào Frame
		add(lblA);	add(txtA);
		add(lblB);	add(txtB);
		add(btnCong);
		add(btnTru);
		add(btnNhan);
		add(btnChia);
		add(lblKQ);	add(txtKQ);
		
		// Thêm bộ lắng nghe và xử lý sự kiện cho các nút + - * /
		btnCong.addActionListener(new bolangnghe_cong());
		btnTru.addActionListener(new bolangnghe_tru());
		btnNhan.addActionListener(new bolangnghe_nhan());
		btnChia.addActionListener(new bolangnghe_chia());
		
		// Thêm bộ lắng nghe và xử lý sự kiện cho cửa sổ Frame
		addWindowListener(new bolangnghe_cuaso());
	
	}
	// Cộng
	class bolangnghe_cong implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Code xử lý sự kiện ở đây
			
			// Lấy A,B
			String strA = txtA.getText();
			String strB = txtB.getText();
			
			// Đổi sang con số để tính toán
			try {
				double a = Double.parseDouble(strA);
				double b = Double.parseDouble(strB);
				
				// Tính A + B
				double c = a + b;
				
				// Xuất kết quả ra điều khiển
				txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("Nhap Lai");
			}
		}
	}
	// Trừ
	class bolangnghe_tru implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Code xử lý sự kiện ở đây
			
			// Lấy A,B
			String strA = txtA.getText();
			String strB = txtB.getText();
			
			// Đổi sang con số để tính toán
			try {
				double a = Double.parseDouble(strA);
				double b = Double.parseDouble(strB);
				
				// Tính A - B
				double c = a - b;
				
				// Xuất kết quả ra điều khiển
				txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("Nhap Lai");
			}
		}
	}
	// Nhân
	class bolangnghe_nhan implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Code xử lý sự kiện ở đây
			
			// Lấy A,B
			String strA = txtA.getText();
			String strB = txtB.getText();
			
			// Đổi sang con số để tính toán
			try {
				double a = Double.parseDouble(strA);
				double b = Double.parseDouble(strB);
				
				// Tính A * B
				double c = a * b;
				
				// Xuất kết quả ra điều khiển
				txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("Nhap Lai");
			}
		}
	}
	// Chia
	class bolangnghe_chia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Code xử lý sự kiện ở đây
			
			// Lấy A,B
			String strA = txtA.getText();
			String strB = txtB.getText();
			
			// Đổi sang con số để tính toán
			try {
				double a = Double.parseDouble(strA);
				double b = Double.parseDouble(strB);
				
				// Tính A / B
				double c = a / b;
				
				// Xuất kết quả ra điều khiển
				txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("Nhap Lai");
			}
		}
	}
	class bolangnghe_cuaso implements WindowListener{
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			
		}
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public static void main(String[] args) {
		
	}

}

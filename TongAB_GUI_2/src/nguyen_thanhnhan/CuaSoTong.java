package nguyen_thanhnhan;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CuaSoTong extends Frame {
	// Các thuộc tính
	Label lblA, lblB, lblKQ;
	TextField txtA, txtB, txtKQ;
	Button btnCong;
	// Hàm khởi tạo
	public CuaSoTong() {
		// Sử dụng null Layout để bố trí lại (Cần phải setBounds cho từng cái)
		setLayout(null);
		setBounds(450, 150, 350, 250);
		setTitle("Tổng 2 số A,B");
		setVisible(true);
		// Đưa các điều khiển vào Frame
		lblA = new Label("A:");
		lblA.setBounds(100, 30, 30, 30);
		
		lblB = new Label("B:");
		lblB.setBounds(100, 80, 30, 30);
		
		lblKQ = new Label("KQ:");
		lblKQ.setBounds(100, 165, 30, 30);
	
		txtA = new TextField();
		txtA.setBounds(130, 30, 100, 30);
		
		txtB = new TextField();
		txtB.setBounds(130, 80, 100, 30);
		
		txtKQ = new TextField();
		txtKQ.setBounds(130, 165, 100, 30);
		
		btnCong = new Button("+");
		btnCong.setBounds(155, 125, 45, 25);
		
		add(lblA);	add(txtA);
		add(lblB);	add(txtB);
		add(btnCong);
		add(lblKQ);	add(txtKQ);
		
		// Thêm bộ lắng nghe và xử lý sự kiện cho nút tính tổng
		btnCong.addActionListener(new bolangnghe_cong());
		// Thêm bộ lắng nghe và xử lý sự kiện cho cửa sổ Frame
		addWindowListener(new bolangnghe_cuaso());
	
	}
	//
	class bolangnghe_cong implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// Code xử lý sự kiện ở đây
			
			// Lấy A,B
			String strA = txtA.getText();
			String strB = txtB.getText();
			
			// Đổi sang con số để tính toán
			try {
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
				
				// Tính tổng A + B
				int c = a + b;
				
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

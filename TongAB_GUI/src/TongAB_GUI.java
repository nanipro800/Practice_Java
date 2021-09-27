import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TongAB_GUI {

	public static void main(String[] args) {
		
		Frame fr = new Frame("Tổng 2 số A B");
		fr.setBounds(450, 150, 350, 250);
		fr.setLayout(null);
		fr.setVisible(true);
		
		//
		Label lblA = new Label("A:");
		lblA.setBounds(100, 30, 30, 30);
		Label lblB = new Label("B:");
		lblB.setBounds(100, 80, 30, 30);
		Label lblKQ = new Label("KQ:");
		lblKQ.setBounds(100, 165, 30, 30);
		
		TextField txtA = new TextField();
		txtA.setBounds(130, 30, 100, 30);
		TextField txtB = new TextField();
		txtB.setBounds(130, 80, 100, 30);
		TextField txtKQ = new TextField();
		txtKQ.setBounds(130, 165, 100, 30);
		
		Button btnCong = new Button("+");
		btnCong.setBounds(155, 125, 45, 25);
		
		// Gắn vào Frame
		fr.add(lblA);	fr.add(txtA);
		fr.add(lblB);	fr.add(txtB);
		fr.add(btnCong);
		fr.add(lblKQ);	fr.add(txtKQ);
		
		// Tạo bộ lắng nghe để xử lý sự kiện
		ActionListener bolangnghe = new ActionListener() {
			
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
		};
		// Xử lý sự kiện nút tính tổng được nhấn
		btnCong.addActionListener(bolangnghe);
		
		// Xử lý đóng cửa sổ
		fr.addWindowListener( new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) 
			{ 
				System.exit(0); 
			}
	});		
}
}
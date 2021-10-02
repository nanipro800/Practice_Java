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

public class BMI_Calculator extends Frame {
	// Các thuộc tính
	Label lblW, lblH, lblBMI, lblAdvances;
	TextField txtW, txtH, txtBMI, txtAdvances;
	Button btnCal;
	Font font = new Font("Courier", Font.PLAIN,18);
	// Hàm khởi tạo
	public BMI_Calculator() {
		// Sử dụng BoxLayout theo trục dọc
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(650, 200, 550, 450);
		setTitle("BMI Calculator");
		setVisible(true);
		// Khởi tạo các điều khiển
		lblW = new Label("Nhập cân nặng (kg):");
		lblW.setFont(font);
		lblW.setBackground(Color.gray);
		lblW.setForeground(Color.white);
		
		lblH = new Label("Nhập chiều cao (cm):");
		lblH.setFont(font);
		lblH.setBackground(Color.gray);
		lblH.setForeground(Color.white);
		
		lblBMI = new Label("Chỉ số BMI của bạn là:");
		lblBMI.setFont(font);
		lblBMI.setBackground(Color.gray);
		lblBMI.setForeground(Color.white);
		
		lblAdvances = new Label("Lời khuyên giành cho bạn:");
		lblAdvances.setFont(font);
		lblAdvances.setBackground(Color.gray);
		lblAdvances.setForeground(Color.white);
		
		txtW = new TextField();
		txtW.setFont(font);
		txtW.setForeground(Color.black);
		
		txtH = new TextField();
		txtH.setFont(font);
		txtH.setForeground(Color.black);
		
		txtBMI = new TextField();
		txtBMI.setFont(font);
		txtBMI.setForeground(Color.black);
		
		txtAdvances = new TextField();
		txtAdvances.setFont(font);
		txtAdvances.setForeground(Color.black);
		
		btnCal = new Button("Tính BMI");
		btnCal.setFont(font);
		btnCal.setBackground(Color.cyan);
		btnCal.setForeground(Color.black);
		// Đưa các điều khiển vào Frame
		add(lblW);	add(txtW);
		add(lblH);	add(txtH);
		add(btnCal);
		add(lblBMI);		add(txtBMI);
		add(lblAdvances);	add(txtAdvances);
		// Tạo bộ lắng nghe để xử lý sự kiện cho nút bấm và cửa sổ
		btnCal.addActionListener(new cal_bmi());
		addWindowListener(new bolangnghe_cuaso());
	}
	//
	class cal_bmi implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strW = txtW.getText();
			String strH = txtH.getText();
			try 
			{
				double W = Double.parseDouble(strW);
				double H = Double.parseDouble(strH);
				if(H <= 40 || W <= 0)
				{
					throw new Exception("Exception message");
				}
				else {
					// Tính BMI
					double BMI = W / (Math.pow(H/100, 2));
					// Xuất kết quả
					txtBMI.setText(String.valueOf("" + String.format("%.2f", BMI)));
					// Phân loại dựa theo chỉ số BMI và đưa ra lời khuyên
					if(BMI < 18.5) {
						txtAdvances.setText(String.valueOf("Bạn bị gầy, bạn nên tăng cân"));
					}
					else if(BMI >= 18.5 && BMI <= 24.9) {
						txtAdvances.setText(String.valueOf("Bạn bình thường, chúc mừng bạn"));
					}
					else if(BMI >= 25 && BMI <= 29.9) {
						txtAdvances.setText(String.valueOf("Bạn bị thừa cân, bạn nên giảm cân"));
					}
					else if(BMI >= 30) {
						txtAdvances.setText(String.valueOf("Bạn bị béo phì, bạn nên giảm cân"));
					}
				}
				
			}
			catch (Exception ex) {
				txtBMI.setText("Nhap Lai");
				
			}
		}
		
	}
	class bolangnghe_cuaso implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
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
		// TODO Auto-generated method stub

	}

}

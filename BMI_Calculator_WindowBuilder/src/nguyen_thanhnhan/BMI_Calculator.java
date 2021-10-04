package nguyen_thanhnhan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMI_Calculator {

	private JFrame frame;
	private JTextField txtH;
	private JTextField txtW;
	private JPanel panel;
	private JRadioButton radAsian;
	private JRadioButton radNonAsian;
	private JButton btnBMI;
	private JTextField txtBMI;
	private JTextField txtAdvice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI_Calculator window = new BMI_Calculator();
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
	public BMI_Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = 	new JFrame();
		frame.setBounds(100, 100, 573, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTittle = new JLabel("Chương trình tính BMI");
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(114, 21, 305, 20);
		frame.getContentPane().add(lblTittle);
		
		JLabel lblH = new JLabel("Chiều cao:");
		lblH.setBounds(59, 54, 59, 14);
		frame.getContentPane().add(lblH);
		
		txtH = new JTextField();
		txtH.setBounds(128, 51, 86, 20);
		frame.getContentPane().add(txtH);
		txtH.setColumns(10);
		
		JLabel lblW = new JLabel("Cân nặng:");
		lblW.setBounds(59, 95, 59, 14);
		frame.getContentPane().add(lblW);
		
		txtW = new JTextField();
		txtW.setBounds(128, 92, 86, 20);
		frame.getContentPane().add(txtW);
		txtW.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Region", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(128, 136, 172, 64);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		radAsian = new JRadioButton("Asian");
		radAsian.setBounds(6, 20, 56, 23);
		panel.add(radAsian);
		
		radNonAsian = new JRadioButton("Non Asian");
		radNonAsian.setBounds(82, 20, 79, 23);
		panel.add(radNonAsian);
		
		btnBMI = new JButton("Tính BMI");
		btnBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy chiều cao
				String strH = txtH.getText();
				// Lấy cân nặng
				String strW = txtW.getText();
				// Lấy về region
				// Tính BMI
				boolean isAsian = false;
				if (radNonAsian.isSelected() == true) // Nếu nút này được chọn
				{
					isAsian = false;
					try 
					{
						double H = Double.parseDouble(strH);
						double W = Double.parseDouble(strW);
						if(H <= 40 || W <= 0)
						{
							throw new Exception("Exception message");
						}
						else {
							double BMI = W / (Math.pow(H/100, 2));
							// Xuất kết quả
							txtBMI.setText(String.valueOf("" + String.format("%.2f", BMI)));
							// Phân loại dựa theo chỉ số BMI và đưa ra lời khuyên
							if(BMI < 18.5) {
								txtAdvice.setText(String.valueOf("Bạn bị gầy, bạn nên tăng cân"));
							}
							else if(BMI >= 18.5 && BMI <= 24.9) {
								txtAdvice.setText(String.valueOf("Bạn bình thường, chúc mừng bạn"));
							}
							else if(BMI >= 25 && BMI <= 29.9) {
								txtAdvice.setText(String.valueOf("Bạn bị thừa cân, bạn nên giảm cân"));
							}
							else if(BMI >= 30) {
								txtAdvice.setText(String.valueOf("Bạn bị béo phì, bạn nên giảm cân"));
							}
						}
						
					}
					catch (Exception ex) {
						txtBMI.setText("Nhap Lai");
						txtAdvice.setText("");
					}
				}
				else if (radNonAsian.isSelected() == false) {
					isAsian = true;
					try 
					{
						double H = Double.parseDouble(strH);
						double W = Double.parseDouble(strW);
						if(H <= 40 || W <= 0)
						{
							throw new Exception("Exception message");
						}
						else {
							double BMI = W / (Math.pow(H/100, 2));
							// Xuất kết quả
							txtBMI.setText(String.valueOf("" + String.format("%.2f", BMI)));
							// Phân loại dựa theo chỉ số BMI và đưa ra lời khuyên
							if(BMI < 18.5) {
								txtAdvice.setText(String.valueOf("Bạn bị gầy, bạn nên tăng cân"));
							}
							else if(BMI >= 18.5 && BMI <= 22.9) {
								txtAdvice.setText(String.valueOf("Bạn bình thường, chúc mừng bạn"));
							}
							else if(BMI >= 23 && BMI <= 24.9) {
								txtAdvice.setText(String.valueOf("Bạn bị thừa cân, bạn nên giảm cân"));
							}
							else if(BMI >= 30) {
								txtAdvice.setText(String.valueOf("Bạn bị béo phì, bạn nên giảm cân"));
							}
						}
						
					}
					catch (Exception ex) {
						txtBMI.setText("Nhap Lai");
						txtAdvice.setText("");
					}
				}
				
					// Nếu Asian thì áp dụng công thức cho Asian và ngược lại
			}
		});
		btnBMI.setBounds(128, 211, 89, 23);
		frame.getContentPane().add(btnBMI);
		
		JLabel lblBMI = new JLabel("BMI:");
		lblBMI.setBounds(59, 258, 46, 14);
		frame.getContentPane().add(lblBMI);
		
		txtBMI = new JTextField();
		txtBMI.setBounds(128, 255, 86, 20);
		frame.getContentPane().add(txtBMI);
		txtBMI.setColumns(10);
		
		JLabel lblAdvice = new JLabel("Lời khuyên:");
		lblAdvice.setBounds(59, 303, 59, 14);
		frame.getContentPane().add(lblAdvice);
		
		txtAdvice = new JTextField();
		txtAdvice.setBounds(128, 300, 235, 20);
		frame.getContentPane().add(txtAdvice);
		txtAdvice.setColumns(10);
	}
}

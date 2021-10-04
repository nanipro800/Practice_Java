package nguyen_thanhnhan;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 426, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTittle = new JLabel("BMI Calculator");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTittle.setForeground(Color.RED);
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(114, 11, 193, 20);
		frame.getContentPane().add(lblTittle);
		
		JLabel lblH = new JLabel("Chiều cao:");
		lblH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblH.setBounds(52, 54, 73, 20);
		frame.getContentPane().add(lblH);
		
		txtH = new JTextField();
		txtH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtH.setBounds(142, 56, 187, 20);
		frame.getContentPane().add(txtH);
		txtH.setColumns(10);
		
		JLabel lblW = new JLabel("Cân nặng:");
		lblW.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblW.setBounds(52, 95, 73, 20);
		frame.getContentPane().add(lblW);
		
		txtW = new JTextField();
		txtW.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtW.setBounds(142, 97, 187, 20);
		frame.getContentPane().add(txtW);
		txtW.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Region", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(124, 136, 222, 64);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		radAsian = new JRadioButton("Asian");
		radAsian.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(radAsian);
		radAsian.setBounds(25, 20, 62, 23);
		panel.add(radAsian);
		
		radNonAsian = new JRadioButton("Non Asian");
		radNonAsian.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(radNonAsian);
		radNonAsian.setBounds(117, 20, 84, 23);
		panel.add(radNonAsian);
		
		btnBMI = new JButton("Tính BMI");
		btnBMI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strH = txtH.getText();
				String strW = txtW.getText();
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
						txtAdvice.setText(String.valueOf("Chọn region"));
						// Phân loại và đưa ra lời khuyên dựa theo region
						if(radAsian.isSelected()==true)  // Nếu button Asian được chọn
						{
							if(BMI < 18.5) {
								txtAdvice.setText(String.valueOf("Bạn bị gầy, bạn nên tăng cân"));
							}
							else if(BMI >= 18.5 && BMI <= 22.9) {
								txtAdvice.setText(String.valueOf("Bạn bình thường, chúc mừng bạn"));
							}
							else if(BMI >= 23 && BMI <= 24.9) {
								txtAdvice.setText(String.valueOf("Bạn bị thừa cân, bạn nên giảm cân"));
							}
							else if(BMI >= 25 && BMI <= 29.9) {
								txtAdvice.setText(String.valueOf("Bạn bị tiền béo phì, bạn nên giảm cân"));
							}
							else if(BMI >= 30) {
								txtAdvice.setText(String.valueOf("Bạn bị béo phì, bạn nên giảm cân"));
							}
						}
						else if(radNonAsian.isSelected()==true) // Nếu button Non Asian được chọn
						{
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
				}
				catch (Exception ex) {
					txtBMI.setText("Nhap Lai");
					txtAdvice.setText("");
				}
			}});
		btnBMI.setBounds(187, 211, 96, 23);
		frame.getContentPane().add(btnBMI);
		
		JLabel lblBMI = new JLabel("BMI:");
		lblBMI.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBMI.setBounds(52, 257, 46, 14);
		frame.getContentPane().add(lblBMI);
		
		txtBMI = new JTextField();
		txtBMI.setForeground(Color.RED);
		txtBMI.setBounds(142, 255, 187, 23);
		frame.getContentPane().add(txtBMI);
		txtBMI.setColumns(10);
		txtBMI.setEditable(false);
		
		JLabel lblAdvice = new JLabel("Lời khuyên:");
		lblAdvice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdvice.setBounds(52, 299, 80, 22);
		frame.getContentPane().add(lblAdvice);
		
		txtAdvice = new JTextField();
		txtAdvice.setForeground(Color.RED);
		txtAdvice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAdvice.setBounds(142, 300, 187, 23);
		frame.getContentPane().add(txtAdvice);
		txtAdvice.setColumns(10);
		txtAdvice.setEditable(false);
}
}

package nguyen_thanhnhan;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class guiarrayy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtHo;
	JButton btnAdd;
	JButton btnShow;
	JLabel lbHo;
	Label lblstt;
	TextArea trShow;
	TextArea trShowNonClick;
	Label label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiarrayy frame = new guiarrayy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiarrayy() {
		setTitle("Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		


		lbHo = new JLabel("Nhập họ và tên");
		lbHo.setHorizontalAlignment(SwingConstants.LEFT);
		lbHo.setBounds(251, 41, 78, 13);
		contentPane.add(lbHo);
		
		txtHo = new JTextField();
		
		txtHo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblstt.setText("");
			}
		});
		
		
		txtHo.setBounds(251, 55, 247, 19);
		contentPane.add(txtHo);
		txtHo.setColumns(10);
		
		ArrayList<String> dsTen = new ArrayList<String>();
		ArrayList<String> dsPhu = new ArrayList<String>();
		
		btnAdd = new JButton("Thêm");
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				themVaoDanhSach(dsTen,dsPhu);
			
			
			}
		});
		
		
		btnAdd.setBounds(251, 84, 102, 21);
		contentPane.add(btnAdd);
		btnShow = new JButton("Hiển thị");
		
		
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiDanhSach(dsTen);
				
			}
		});
		
		
		btnShow.setBounds(65, 133, 85, 21);
		contentPane.add(btnShow);

		 trShow = new TextArea();
		trShow.setBounds(65, 160, 270, 150);
		contentPane.add(trShow);
		
		lblstt = new Label("");
		lblstt.setForeground(Color.RED);
		lblstt.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		lblstt.setBounds(246, 106, 252, 21);
		contentPane.add(lblstt);
		
		trShowNonClick = new TextArea();
		trShowNonClick.setBounds(432, 160, 285, 150);
		contentPane.add(trShowNonClick);
		
		label = new Label("Hiện ngay khi thêm");
		label.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		label.setBounds(431, 133, 185, 21);
		contentPane.add(label);
		
		JButton btnFind = new JButton("Tìm Kiếm");
		
		
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = false;
				String strName = txtHo.getText();
				if(strName.isEmpty()) {
					lblstt.setText("Vui lòng nhập vào khung");
				}
				else
				{	
					for(String sTen:dsPhu)
				{
					if(sTen.equals(strName)) {
						result = true;
						break;
					}
					else {
						result = false;
					}
					
					
				}
				
				if(result == true) {
					JOptionPane.showMessageDialog(guiarrayy.this, "Có tồn tại tên " + strName , "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(guiarrayy.this, "Không tồn tại tên " + strName , "Lỗi tìm kiếm", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			}
		});
		
		
		btnFind.setBounds(380, 84, 118, 21);
		contentPane.add(btnFind);
	}



	void hienThiDanhSach(ArrayList<String> dsTen) {
		// TODO Auto-generated method stub
		
		
		if(dsTen.isEmpty()) {
			lblstt.setText("Danh sách rỗng");
		}
		else {
			for(String sTen: dsTen) {
				trShow.append(sTen + "\n");				
		}	
				dsTen.remove(0);
			
		}
	}

	void themVaoDanhSach(ArrayList<String> dsTen,ArrayList<String> dsPhu) {
		// TODO Auto-generated method stub
		String strName = txtHo.getText();
		
		
		if(strName.isBlank()) {
			lblstt.setText("Vui lòng nhập vào khung");
		}
		else {
			dsTen.add(strName);
			dsPhu.add(strName);
			trShowNonClick.append(strName + "\n");
			lblstt.setText("Đã thêm xong vào danh sách");
			txtHo.setText("");
		}
	
	}
}
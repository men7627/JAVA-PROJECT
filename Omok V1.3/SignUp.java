import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame implements ActionListener{

	private ImageIcon im1;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	MainController main;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/users?useSSL=false";

	static final String USERNAME = "root";
	static final String PASSWORD = "1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SignUp signup = new SignUp();
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		Connection conn = null;
		Statement stmt = null;
		im1 = new ImageIcon("가입배경.png");
		setTitle("SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S I G N   U P");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 34));
		lblNewLabel.setBounds(133, 28, 212, 74);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("I                      D");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_1.setBounds(30, 127, 232, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("P A S S    W O R D");
		lblPassword.setFont(new Font("굴림", Font.BOLD, 24));
		lblPassword.setBounds(30, 197, 232, 21);
		contentPane.add(lblPassword);
		
		JLabel lblChrckPassword = new JLabel("CHRCK PASSWORD ");
		lblChrckPassword.setFont(new Font("굴림", Font.BOLD, 24));
		lblChrckPassword.setBounds(30, 265, 232, 21);
		contentPane.add(lblChrckPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(279, 120, 156, 40);
		contentPane.add(textField);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(279, 190, 156, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(279, 254, 156, 40);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 27));
		btnNewButton.setBounds(170, 345, 125, 66);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 466, 473);
		contentPane.add(label);
		label.setIcon(im1);
		btnNewButton.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if("OK".equals(e.getActionCommand())) {
			if(textField.getText().equals("") || textField_1.getText().equals("")||textField_2.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"데이터를 모두 입력해주세요.","아이디나 비밀번호 입력",JOptionPane.INFORMATION_MESSAGE);
				
			}
			else if(!textField_1.getText().equals(textField_2.getText())) {
				JOptionPane.showMessageDialog(null,"비밀번호 불일치","비밀번호 불일치",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				System.out.println("데이터베이스에 접근....");
				database.signin_db(textField_1.getText(), textField_2.getText());
				JOptionPane.showMessageDialog(null, "회원가입 성공","회원가입 성공",JOptionPane.INFORMATION_MESSAGE);
				main.ShowLoginFrame(this);
			}
		}
	}
	public void setMain(MainController main) {
		this.main = main;		
	}
}

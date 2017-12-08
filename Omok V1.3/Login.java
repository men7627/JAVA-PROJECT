
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Login extends JFrame implements ActionListener{
	private ImageIcon im1;
	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	MainController main;
	private JPasswordField passwordField;
	
	
	public static void main(String[] args) {
		Login login = new Login();
	}

	public Login() {
		im1 = new ImageIcon("배경.jpg");
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		textField = new JTextField();
		textField.setBounds(245, 137, 116, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID : ");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(183, 145, 45, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("L  O  G  I  N");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 35));
		lblNewLabel_1.setBounds(201, 66, 217, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(85, 187, 131, 19);
		contentPane.add(lblNewLabel_2);
		
/*		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 124, 116, 21);
		contentPane.add(textField_1);*/
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(245, 240, 116, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnSignIn = new JButton("Sign In"); // btnSignIn = new JButton(new ImageIcon("img/btLisdsafg df.png"));
		btnSignIn.setFont(new Font("굴림", Font.BOLD, 20));
		/*btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				dispose();
			}
		});*/
		btnSignIn.setBounds(396, 137, 97, 74);
		contentPane.add(btnSignIn);
		btnSignIn.addActionListener(this); //액션 걸림
		
		passwordField = new JPasswordField();
		passwordField.setBounds(245, 182, 116, 29);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("Gulim", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(0, 0, 616, 366);
		contentPane.add(lblNewLabel_3);
		setVisible(true);
		lblNewLabel_3.setIcon(im1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("Sign In".equals(e.getActionCommand())) {
			System.out.println("액션 체크 됨");
			System.out.println(textField.getText());
			System.out.println(passwordField.getText());
			if(textField.getText().equals("") || passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"아이디나 비밀번호를 입력해주세요","아이디나 비밀번호 입력",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				System.out.println("데이터베이스에 접근....");
				//if(logincheck) 로그인 성공한 경우
				JOptionPane.showMessageDialog(null, "로그인 성공","로그인 성공",JOptionPane.INFORMATION_MESSAGE);
				//main에 이거는 닫아주고, 오목화면 요청
				main.showOmokFrame(this);
			}
		}
		else if("Sign Up".equals(e.getActionCommand())) {
			main.showSignUpFrame(this);
		}
	}
/*	public void actionPerformed_(ActionEvent arg0) {
		main.showSignUpFrame(this);
	}
*/
	public void setMain(MainController main) {
		this.main = main;		
	}
}
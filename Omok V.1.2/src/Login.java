
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Login extends JFrame implements ActionListener{
	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	MainController main;
	
	public static void main(String[] args) {
		Login login = new Login();
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 93, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID : ");
		lblNewLabel.setBounds(103, 96, 33, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("L O G I N");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 26));
		lblNewLabel_1.setBounds(148, 37, 126, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setBounds(47, 127, 93, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 124, 116, 21);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(152, 168, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSignIn = new JButton("Sign In"); // btnSignIn = new JButton(new ImageIcon("img/btLisdsafg df.png"));
		/*btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				dispose();
			}
		});*/
		btnSignIn.setBounds(294, 93, 97, 53);
		contentPane.add(btnSignIn);
		btnSignIn.addActionListener(this); //액션 걸림
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("액션 체크 됨");
		System.out.println(textField.getText());
		System.out.println(textField_1.getText());
		if(textField.getText().equals("") || textField_1.getText().equals("")) {
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

	public void setMain(MainController main) {
		this.main = main;		
	}
}
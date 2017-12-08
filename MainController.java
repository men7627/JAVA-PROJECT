import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MainController {
	static MainController main;
	static Login loginframe;
	static OmokClient client;
	static SignUp signup;
	static Clip clip;
	static void PlaySound(File Sound) {
		  try {
			  clip = AudioSystem.getClip();
			  clip.open(AudioSystem.getAudioInputStream(Sound));
			  clip.start();
			  clip.loop(5);
		  }
		  catch(Exception e) {
			  
		  }
	  }
  static File lo = new File("�α�.wav");
	
	public static void main(String[] args) {
		main =  new MainController();
		PlaySound(lo);
		loginframe = new Login();
		loginframe.setMain(main);
		/*signup = new SignUp();
		signup.setMain(main);*/
		
		//�����ͺ��̽� �ʱ�ȭ
		//�α��� ���� ������ �׼��� ������Ʈ ����� ������Է�
		//�����ӿ� dao����
	}
	public void showOmokFrame(Login login) {
		clip.stop();
		login.dispose();
		//new OmokClient("�������!");
		client=new OmokClient("���� ����");
	    client.setSize(800,700);
	    client.setVisible(true);
	    client.connect();
	    client.setMain(main);
	}
	public void showSignUpFrame(Login login) {
		login.dispose();
		signup=new SignUp();
		signup.setMain(main);
	}
	public void ShowLoginFrame(SignUp Sign) {
		signup.dispose();
		loginframe=new Login();
		loginframe.setMain(main);
	}
}

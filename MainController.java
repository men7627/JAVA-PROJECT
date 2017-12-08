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
  static File lo = new File("로그.wav");
	
	public static void main(String[] args) {
		main =  new MainController();
		PlaySound(lo);
		loginframe = new Login();
		loginframe.setMain(main);
		/*signup = new SignUp();
		signup.setMain(main);*/
		
		//데이터베이스 초기화
		//로그인 위한 데이터 액세스 오브젝트 만들고 사용자입력
		//프레임에 dao주입
	}
	public void showOmokFrame(Login login) {
		clip.stop();
		login.dispose();
		//new OmokClient("오목게임!");
		client=new OmokClient("오목 게임");
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

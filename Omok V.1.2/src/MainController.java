
public class MainController {
	static MainController main;
	static Login loginframe;
	static OmokClient client;
	public static void main(String[] args) {
		main =  new MainController();
		loginframe = new Login();
		loginframe.setMain(main);
		//데이터베이스 초기화
		//로그인 위한 데이터 액세스 오브젝트 만들고 사용자입력
		//프레임에 dao주입
	}
	public void showOmokFrame(Login login) {
		login.dispose();
		//new OmokClient("오목게임!");
		client=new OmokClient("네트워크 오목 게임");
	    client.setSize(760,560);
	    client.setVisible(true);
	    client.connect();
	    client.setMain(main);
	}
}

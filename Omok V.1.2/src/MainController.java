
public class MainController {
	static MainController main;
	static Login loginframe;
	static OmokClient client;
	public static void main(String[] args) {
		main =  new MainController();
		loginframe = new Login();
		loginframe.setMain(main);
		//�����ͺ��̽� �ʱ�ȭ
		//�α��� ���� ������ �׼��� ������Ʈ ����� ������Է�
		//�����ӿ� dao����
	}
	public void showOmokFrame(Login login) {
		login.dispose();
		//new OmokClient("�������!");
		client=new OmokClient("��Ʈ��ũ ���� ����");
	    client.setSize(760,560);
	    client.setVisible(true);
	    client.connect();
	    client.setMain(main);
	}
}

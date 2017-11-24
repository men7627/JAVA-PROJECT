import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server;
	private Manager manager = new Manager();
	
	public void start() {
		try {
			server= new ServerSocket(9999);
			System.out.println("���� ������ �����Ǿ����ϴ�.");
			while(true) {
				Socket socket = server.accept();
				new Chat(socket).start();
				manager.add(socket);
				manager.sendClientInformation();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public class Chat extends Thread{
		
		private Socket socket;
		private BufferedReader reader;
		
		public Chat(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String message;
				while((message = reader.readLine())!= null) {
					System.out.println(message);
					manager.sendToAll(message);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					manager.remove(socket);
					if(reader != null)reader.close();
					if(socket != null)socket.close();
					System.out.println("Ŭ���̾�Ʈ�� �������ϴ�.");
					manager.sendClientInformation();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

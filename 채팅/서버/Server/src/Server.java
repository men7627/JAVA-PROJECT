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
			System.out.println("서버 소켓이 생성되었습니다.");
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
					System.out.println("클라이언트가 나갔습니다.");
					manager.sendClientInformation();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

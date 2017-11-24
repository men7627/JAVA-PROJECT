import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class Manager extends Vector{
	
	void add(Socket socket) {
		super.add(socket);
	}
	
	void remove(Socket socket) {
		super.remove(socket);
	}
	
	synchronized void sendToAll(String message) {
		PrintWriter writer = null;
		Socket socket;
		
		for(int i = 0; i< size(); i++) {
			socket = (Socket) elementAt(i);
			try {
				writer = new PrintWriter(socket.getOutputStream(),true);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(writer != null)writer.println(message);
		}
	}
	synchronized void sendClientInformation() {
		String information = "현재 채팅 인원 : " +size();
		System.out.println(information);
		sendToAll(information);
	}
}

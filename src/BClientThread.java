import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class BClientThread extends Thread {
	private Socket client_socket = null;
	private Socket friend_socket = null;

	private String clientMsg;
	boolean run = true;

	public BClientThread(Socket client_socket) {
		this.client_socket = client_socket;
	}

	public void run() {

		while (run) {

			DataInputStream inFromClient;
			try {
				inFromClient = new DataInputStream(
						client_socket.getInputStream());
				clientMsg = inFromClient.readUTF();
				if (clientMsg == null)
					break;
				System.out.println(clientMsg);
				// check is client answer right
				if (clientMsg.equalsIgnoreCase(Info.currentQuestion.answer)) {
					Info.broadCast("Winner is: "
							+ client_socket.getInetAddress());
					Info.currentQuestion.isAnswer = true;
				}
				Info.broadCast(clientMsg);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
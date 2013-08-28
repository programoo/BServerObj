import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BServer {

	private int port;
	private ServerSocket serverSocket;

	public BServer() {
		port = 50000;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new QuestionFeeder();

	}

	public void start() {
		try {

			System.out.println("Server start with port: " + port);
			while (true) {

				Socket clientSocket = serverSocket.accept();
				BClientThread bt = new BClientThread(clientSocket);
				bt.start();

				Info.clientList.add(new Client(serverSocket, clientSocket, bt));
				System.out.println("Client connect");

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		new BServer().start();

	}// end main

}

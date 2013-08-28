import java.net.ServerSocket;
import java.net.Socket;


public class Client {
	ServerSocket serverSocket;
	Socket clientSocket;
	Socket friendSocket;
	BClientThread bt;
	public Client(ServerSocket serverSocket,Socket clientSocket,BClientThread bt){
		this.serverSocket = serverSocket;
		this.clientSocket = clientSocket;
		this.bt = bt;
	}
}
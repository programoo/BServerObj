import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Info {
	public static ArrayList<Client> clientList = new ArrayList<Client>();

	public static void broadCast(String msg) {
		ArrayList<Client> nullClientList = new ArrayList<Client>();
		for (int i = 0; i < Info.clientList.size(); i++) {
			try {
				if (msg == null)
					throw new IOException();
				else {
					new DataOutputStream(
							Info.clientList.get(i).clientSocket
									.getOutputStream()).writeBytes("[" + msg
							+ "]\n");
					
					new DataOutputStream(
							Info.clientList.get(i).clientSocket
									.getOutputStream()).writeBytes("[" + Info.clientList.size()
							+ "]\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("msg: " + msg);
				Info.clientList.get(i).bt.run = false;
				nullClientList.add(Info.clientList.get(i));
			}

		}
		
		//remove null item
		for(int i=0;i<nullClientList.size();i++){
			Info.clientList.remove(nullClientList.get(i));
		}
	}

}
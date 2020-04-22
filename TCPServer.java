import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class TCPServer  {
	
	static ArrayList<ClientThread> clientsArray = new ArrayList<ClientThread>();

	public static ArrayList<ClientThread> getClientsArray() {
		return clientsArray;
	}

	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String sentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		String capitilizedSent;
		
		
		
		 
		while (true) {
            
			Socket connectionSocket = welcomeSocket.accept();
			
			ClientThread clientNew = new ClientThread(connectionSocket);
			
			getClientsArray().add(clientNew);
						
		
		}
	}}
	



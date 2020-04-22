import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable{
	Socket clientSocket;
	BufferedReader inFromClient;
	PrintWriter outToClient;
	Thread thread;
	int id=0;
		
     public ClientThread (Socket socket){
		thread = new Thread(this);
		thread.start();
		this.clientSocket = socket;
		
        try{
			outToClient = new PrintWriter(clientSocket.getOutputStream());
			outToClient.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
           }
	
	
	public void run() {
		try {
			if(clientSocket.isClosed()){
				return;
			}
			inFromClient= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		    while(true){
		    	if(inFromClient.ready()){
		    		String clientSentence = inFromClient.readLine();
		    		System.out.println("From CLient "  + id + ":" + " " + clientSentence );
					outToClient.println(clientSentence.toUpperCase());
					outToClient.flush();
					}
		    }
             }
		catch (IOException e){
			e.printStackTrace();
	} 
		id = id+1;
	}

}

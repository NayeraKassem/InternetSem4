import java.io.*; 
import java.net.*;

public class TCPClient {
	public static void main(String args[]) throws Exception {
		String sentence;
		String receivedSentence;
		
		while(true){
         BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));

       
			
			Socket clientSocket = new Socket("localhost", 6789);
		
			while (true) {
				if(inFromUser.ready()){
				
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				
				sentence = inFromUser.readLine();
				outToServer.writeBytes(sentence + '\n');
				}
                        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        
				if(inFromServer.ready()){

				receivedSentence = inFromServer.readLine();

				System.out.println("FROM SERVER: " + receivedSentence);
				}
                 }
			      }
	               }
                     }
	

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// BIG IDEA- take string input from client and turns it uppercase and sends it back to client
public class EchoServer 
{

	public static void main(String[] args) throws IOException 
	{
		//choosing random port to listen to
		int port = 9999;
		ServerSocket server = new ServerSocket(port);
		//server is now waiting to recieve messages from port 9999
		
		while(true)
		{
			System.out.println("Listening for connections....");
			//socket is intended to be a client, which initiates communication
			Socket client = server.accept();
			//.accept() is a blocking method call, meaning at this point the program is waiting for someone to connect (idle)
			
			//  CONNECTION FOUND
			//if program gets to this point,  then a connection has been made
			System.out.println("Connection made");
			
			//how we create our input stream, how we get input FROM the client
			BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			//how we are going to send info BACK TO the client
			PrintWriter output = new PrintWriter(client.getOutputStream(), true);
			
			String message = input.readLine();
			
			while(message != null)
			{
				System.out.println("RECEIEVED: " + message);
				//creating a new string object which is message uppercase
				String out = message.toUpperCase();
				output.println(message.toUpperCase());
				System.out.println("SENT: "+out);
				message = input.readLine();
			}
			
			output.println(message.toUpperCase());
			
			//closing connection to client
			client.close();
			output.close();
			input.close();
			
		}
		

	}

}

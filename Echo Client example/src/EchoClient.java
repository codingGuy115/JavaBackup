import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


//we are now the client that the server is listening to 
public class EchoClient 
{

	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		Socket client = new Socket("10.30.29.10", 9999);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
		//have now way to get info
		
		//now need way to send info out
		PrintWriter output = new PrintWriter(client.getOutputStream());
		
		Scanner kb = new Scanner(System.in);
		System.out.println("message: ");
		String message = kb.nextLine();
		
		while(!message.equals("done"))
		{
			output.println(message);
			String msgRcv = input.readLine();
			
			System.out.println("RECEIEVED: " + msgRcv);
			System.out.print("next message: ");
			message = input.readLine();
		}
		
		output.println(message);
		
		String msgRcv = input.readLine();
		
		System.out.println("RECEIEVED: " + msgRcv);
		
		client.close();
		output.close();
		input.close();

	}

}

package com.example.APJ2_Ass2_Chess.models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Connectable {
	Packet packet;
    Socket requestSocket;
    
    Client(){
    	super();
    	setColor("black");
    }
    
    /**
     * The main functionality for the Client.  Defines the input and output streams and receives packets.
     */
    void run()
    {
        try{



            requestSocket = new Socket("localhost", 2004);            //1. creating a socket to connect to the server

//            chat_client client1=new chat_client("127.0.0.1");
//            client1.startRunning();

            System.out.println("Connected to localhost in port 2004");
            //2. get Input and Output streams
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            //3: Communicating with the server
            do{
                try{
                	packet = (Packet) in.readObject();
    				handlePacket(packet);
                }
                catch(ClassNotFoundException classNot){
                    System.err.println("data received in unknown format");
                }
            }while(!packet.isExit());  //need to send some kind of closing signal
        }
        catch(UnknownHostException unknownHost){
            System.err.println("You are trying to connect to an unknown host!");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                closeConnections();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }

	/** Closes the connections
	 * @throws IOException
	 */
	public void closeConnections() throws IOException {
		in.close();
		out.close();
		requestSocket.close();
	}
    
    public static void main(String args[])
    {

        Client client = new Client();
        client.run();
    }
}

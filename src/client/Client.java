package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket socket = null;
	private String dirPath;
	private BufferedReader input;
	private BufferedWriter output;
	private String logPath;
	
	public Client() {
		super();

	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void connectServer(String address, int port) {
		try {
			this.socket = new Socket(address, port);
			if (this.socket != null) {
				this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Check IP or port again");
			e.printStackTrace();
		}
	}
	
	public void close() {
		if (this.socket != null) {
			try {
				if (this.input != null)
					this.input.close();
				if (this.output != null)
					this.output.close();
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

}

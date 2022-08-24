package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private ServerSocket serverSocket = null;
	private int port = 12345;
	private Socket clientSocket = null;
	private BufferedReader input;
	private BufferedWriter output;
	private String pathDir;
	private List<Socket> clientList;
	
	public static void main(String[] args) {
		new Server().startServer();
	}
	
	public Server() {
		super();
		try {
			serverSocket = new ServerSocket(port, 0, InetAddress.getByName(null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void startServer() {
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);

		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				try {
					
					System.out.println("Waiting for clients to connect...");
					while (true) {
						clientSocket = serverSocket.accept();
						clientProcessingPool.submit(new ClientTask());
					}
				} catch (IOException e) {
					System.err.println("Unable to process client request");
					e.printStackTrace();
				}
			}
		};
		Thread serverThread = new Thread(serverTask);
		serverThread.start();
	}

	private class ClientTask implements Runnable {

		@Override
		public void run() {
			System.out.println("Got a client !");
			clientList.add(clientSocket);
			
			
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void stopServer() {
		
		if (this.serverSocket != null) {
			try {
				if (this.input != null)
					this.input.close();
				if (this.output != null)
					this.output.close();
				if (this.clientSocket != null)
					this.clientSocket.close();
				this.serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

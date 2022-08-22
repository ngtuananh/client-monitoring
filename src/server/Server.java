package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private ServerSocket serverSocket = null;
	private int port;
	private Socket clientSocket = null;
	private String pathDir;
	
	public static void main(String[] args) {
		new Server().startServer();
	}
	
	public Server() {
		super();

	}

	public void startServer() {
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);

		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(port);
					System.out.println("Waiting for clients to connect...");
					while (true) {
						clientSocket = serverSocket.accept();
						clientProcessingPool.submit(new ClientTask(clientSocket));
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
		private final Socket clientSocket;

		public ClientTask(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			System.out.println("Got a client !");

            // Do whatever required to process the client's request
			
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}

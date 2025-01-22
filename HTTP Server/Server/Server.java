import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ServerSocket serverSocket;
    private final ExecutorService executorService;
    private static final int TOTAL_THREADS = 8;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.executorService = Executors.newFixedThreadPool(TOTAL_THREADS);
        System.out.println("Server Started, waiting for Clients...");
    }

    private void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                // new Client Connected
                Socket clientSocket = serverSocket.accept();
                System.out.println("Added a client");
                // Initialize IO streams by Handler Constructor
                Handler clientHandler = new Handler(clientSocket);
                executorService.execute(clientHandler::handleClientPerThread);
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    private void closeServerSocket() {
        try {
            if (serverSocket != null) serverSocket.close();
            executorService.shutdown();
        } catch (IOException e) {
            System.out.println("Error closing server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Server server = new Server(serverSocket);
            server.startServer();
        } catch(IOException io) {
            System.out.println("IO exception on server: " + io.getMessage());
        }
    }

}
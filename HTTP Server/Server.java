import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket serverSocket;
    
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    // Will need to execute it to open the server
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Server server = new Server(serverSocket);
            server.handleClient();
        } catch(IOException io){
            System.out.println("IO exception on server");
        }
    }

    private void handleClient() {
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.handleClientPerThread();
            } catch (IOException io) {
                System.out.println("Cannot bind the socket server to the client");
                break;
            }
        }
    }
}

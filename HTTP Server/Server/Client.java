import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;
    private final Scanner sc = new Scanner(System.in);
    private volatile boolean running = true;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void startCommunication() {
        Thread receiveThread = new Thread(this::receiveMessages);
        receiveThread.setDaemon(true);
        // Start Receiver thread
        receiveThread.start();

        // Enter message Loop by Main Thread
        while (running && !socket.isClosed()) {
            try {
                String message = sc.nextLine();
                sendMessage(message);
            } catch (IOException e) {
                System.out.println("Error sending message: " + e.getMessage());
                break;
            }
        }
        closeResources();
    }

    // Running on a separate thread i.e. Receiver Thread
    private void receiveMessages() {
        try {
            String message;
            while (running && !socket.isClosed() && (message = bufferedReader.readLine()) != null) {
                System.out.println("Server: " + message);
            }
        } catch (IOException e) {
            if (running) {
                throw new RuntimeException("Connection to server lost: " + e.getMessage());
            }
        } finally {
            running = false;
        }
    }

    private void sendMessage(String message) throws IOException {
        if (!socket.isClosed()) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("You: " + message);
        }
    }

    private void closeResources() {
        running = false;
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
            sc.close();
        } catch (IOException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            Client client = new Client(socket);
            client.startCommunication();
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }

}
import java.io.*;
import java.net.Socket;

public class Handler {
    private static final int BUFFER_SIZE = 4096;
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;

    public Handler(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()),
                BUFFER_SIZE
        );
        this.bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()),
                BUFFER_SIZE
        );
        System.out.println("Initialized the handler constructor for the handler class");
    }

    public String readClientInput() {
        try {
            String request = bufferedReader.readLine();
            if (request == null) {
                System.out.println("Client disconnected");
                return null;
            }
            System.out.println("client: " + request);
            return request;
        } catch (IOException io) {
            System.out.println("Cannot read from client: " + io.getMessage());
            return null;
        }
    }

    public void processedClientOutput(String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println("Sent response to client: " + message);
    }

    public void handleClientPerThread() {
        try {
            // Send Initial message to client
            processedClientOutput("Connected to server!");

            while (!socket.isClosed()) {
                // If bufferReader is ready or have data from client then only the condition will be true'
                // System.out.println("I am waiting for a message from the client");
                if (bufferedReader.ready()) {
                    String message = readClientInput();
                    if (message != null) {
                        processedClientOutput("Server: " + message);
                    } else {
                        System.out.println("Client has closed the connection");
                        break;
                    }
                } else {
                    Thread.sleep(100);
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Handler interrupted");
        } finally {
            closeResources();
        }
    }

    public void closeResources() {
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
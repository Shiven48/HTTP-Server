import Implementation.RequestHandler;

import java.io.*;
import java.net.Socket;

public class Handler {

    private static final int BUFFER_SIZE = 4096;
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;
    private final RequestHandler requestHandler;

    // Constructing the Handler Object
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
        this.requestHandler = new RequestHandler();
        System.out.println("Initialized the handler constructor for the handler class");
    }

    public String readClientInput() {
        try {
            String request = bufferedReader.readLine();
            String response = requestHandler.handleClientRequest(request);
            if (request == null) {
                System.out.println("Client disconnected");
                return null;
            }
            System.out.println("client: " + request);
            return response;
        } catch (IOException io) {
            System.out.println("Cannot read from client: " + io.getMessage());
            return null;
        }
    }

    public void processedClientOutput(String response) throws IOException {
        bufferedWriter.write(response);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println("Sent response to client: " + response);
    }

    public void handleClientPerThread() {
        try {
            // Send Initial message to client
            processedClientOutput("Connected to server!");

            while (!socket.isClosed()) {
                // If bufferReader is ready or have data from client then only the condition will be true (Blocking)
                if (bufferedReader.ready()) {
                    String response = readClientInput();
                    if (response != null) {
                        processedClientOutput("Server: " + response);
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
import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;

public class Handler {

    private static final int BUFFER_SIZE = 4096;
    private static final int TOTAL_THREADS = 8;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS);

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;


    public Handler(Socket socket) throws IOException{
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()),BUFFER_SIZE);
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()),BUFFER_SIZE);
        System.out.println("Initialized the handler constructor for the handler class");
    }

    // Server is reading the client message
    public String readClientInput() {
        try {
            String request = bufferedReader.readLine();
            if (request == null) {
                System.out.println("Client request empty");
                return null;
            }
            return request;
        } catch (IOException io) {
            System.out.println("Cannot read the buffer from the Handler: " + io);
            return null;
        }
    }

    public void processedClientOutput(String message) throws IOException {
        bufferedWriter.write(message.length());
        bufferedWriter.flush();
        System.out.println("Sent response to client: " + message);
    }

    //Allocating a thread to the client
    public void handleClientPerThread() {
        try{
            while(!socket.isClosed()) {
                System.out.println("I am being called");
                Future<String> input = executorService.submit(this::readClientInput);
                try {
                    String message = input.get(4000, TimeUnit.MILLISECONDS);
                    if(message != null) {
                        processedClientOutput(message);
                    }else {
                        System.out.println("Client has closed the connection");
                        break;
                    }
                } catch (TimeoutException e) {
                    System.out.println("Timeout waiting for client input.");
                } catch (ExecutionException e) {
                    System.out.println("Error executing client input task: " + e.getCause());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error in handling client: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    public void parseHttpRequest(String request) {
        // For parsing the request
    }

    public void closeResources() {
        try(
                BufferedReader reader = bufferedReader;
                BufferedWriter writer = bufferedWriter;
                Socket socketToClose = socket
        ) {
        } catch (IOException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}


//    public void readClientInput() {
//        while (!socket.isClosed()) {
//            try {
//                String request = bufferedReader.readLine();
//                parseHttpRequest(request);
//
//            } catch (IOException io) {
//                System.out.println("Cannot read the buffer from the Handler" + io);
//                // closeEverything();
//                break;
//            }
//        }
//    }
import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Handler {

    private static final int BUFFER_SIZE = 4096;
    private static final int TOTAL_THREADS = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS);

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;


    public Handler(Socket socket) throws IOException{
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()),BUFFER_SIZE);
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()),BUFFER_SIZE);
    }

    // Server is reading the client message
    public void readClientInput() {
        while(!socket.isClosed()) {
            try {
                String request = bufferedReader.readLine();
                parseHttpRequest(request);
            } catch (IOException io) {
                System.out.println("Cannot read the buffer from the Handler" + io);
                // closeEverything();
                break;
            }
        }
    }

    //Allocating a thread to the client
    public void handleClientPerThread(){
        executorService.submit(this::readClientInput);
    }

    public void parseHttpRequest(String request){

    }
}

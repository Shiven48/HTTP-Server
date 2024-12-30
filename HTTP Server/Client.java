import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    // Will need to execute it to open the client connection
    // NOTE :- Should be invoked only after starting the server
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            Client c = new Client(socket);
            c.connect();
        } catch(UnknownHostException unknownHost) {
            System.out.println("Unknown Host "+unknownHost);
        } catch(IOException e){
            System.out.println("IO Exception while connect to socket"+e);
        }
    }

    public void connect(){
        try {
            bufferedWriter.write("Hello from the Client");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Message Sent");
        } catch(IOException io){
            System.out.println("Cannot write to the buffer");
        }
    }
}

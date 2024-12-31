import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;
    private final Scanner sc = new Scanner(System.in);

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
            c.sendMessage();
        } catch(UnknownHostException unknownHost) {
            System.out.println("Unknown Host "+unknownHost);
        } catch(IOException e){
            System.out.println("IO Exception while connect to socket"+e);
        }
    }

    public void sendMessage(){
        while(!socket.isClosed()) {
            try {
                String MessageToPass;
                MessageToPass = sc.nextLine();
                bufferedWriter.write(MessageToPass);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                System.out.println("Message Sent");
            } catch (IOException io) {
                System.out.println("Cannot write to the buffer");
                break;
            }
        }
    }
}

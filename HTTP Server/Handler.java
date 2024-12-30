import java.io.*;
import java.net.Socket;

public class Handler {

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;


    public Handler(Socket socket) throws IOException{
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void sendConnectionMessage(){
        String message;
        message = "Connected";
        try {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch(IOException io){
            System.out.println("Cannot write to the socket in from the Handler "+io);
        }
    }

    public void readMessage() {
        try {
            String message = bufferedReader.readLine();
            System.out.println(message);
        } catch (IOException io){
            System.out.println("Cannot read the buffer from the Handler"+io);
        }
    }
}

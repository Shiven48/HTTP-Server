package Implementation;

import Common.RequestBody;
import Common.RequestHeader;
import Common.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestHandler {

    private RequestLine requestLine;
    private RequestHeader header;
    private RequestBody body;
    private final BufferedReader bufferedReader;
    private final List<String> requestHeaders;

    public RequestHandler(BufferedReader reader) {
        this.bufferedReader = reader;
        this.requestHeaders = new ArrayList<>();
    }

    public String handleClientRequest() throws IOException {
        processRequest();
        // This is just to check the console output
        return requestHeaders.toString();
    }

    private void processRequest() throws IOException {
        String line;
        int contentLength = 0;
        String requestBody;

        if(bufferedReader.ready()){
            while((line = bufferedReader.readLine()) != null && !line.isEmpty()){
                if(line.startsWith("Content-Length")){
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
                requestHeaders.add(line);
            }
        }

        if(contentLength != 0){
            char[] body = new char[contentLength];
            int charRead = bufferedReader.read(body,0,contentLength);
            requestBody = new String(body,0,charRead);
            requestHeaders.add(requestBody);
        }
        print();
    }

    // These are requestLine and requestBody
    private void print(){
        System.out.println("First :"+requestHeaders.getFirst());
        System.out.println("Last :"+requestHeaders.getLast());
    }
}

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
        RequestLineHandler handler = new RequestLineHandler();
        String requestLine;
        String requestHeader;
        String requestBody;

        readRequest();

        // Print the client request
        System.out.println(requestHeaders);

        requestLine = requestHeaders.getFirst();

//        if(!requestLine.isEmpty()){
//            handler.processRequestLine();
//        }
//        if(){
//
//        }
        return "";
    }

    // For reading the request form the buffer
    private void readRequest() throws IOException {
        String line;
        int contentLength = 0;
        String requestBody;

        // Read request and add in request Header
        if(bufferedReader.ready()){
            while((line = bufferedReader.readLine()) != null && !line.isEmpty()){
                if(line.startsWith("Content-Length")){
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
                requestHeaders.add(line);
            }
        }

        // Read content Body explicitly
        if(contentLength > 0){
            char[] body = new char[contentLength];
            int charRead = bufferedReader.read(body,0,contentLength);
            requestBody = new String(body,0,charRead);
            requestHeaders.add(requestBody);
        }
    }
}

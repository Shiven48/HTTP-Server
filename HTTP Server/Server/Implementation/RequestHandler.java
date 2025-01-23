package Implementation;

import Common.RequestBody;
import Common.RequestHeader;
import Common.RequestLine;

public class RequestHandler {

    private RequestLine requestLine;
    private RequestHeader header;
    private RequestBody body;

    public RequestHandler() { }

    public String handleClientRequest(String request) {
        return request+"FromRequestHandler";
    }
}

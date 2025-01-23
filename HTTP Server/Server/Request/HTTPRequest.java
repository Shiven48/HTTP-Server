package Request;

import Common.RequestBody;
import Common.RequestHeader;
import Common.RequestLine;

public class HTTPRequest {

    private RequestLine requestLine;
    private RequestHeader header;
    private RequestBody body;
    // private ConcurrentHashMap<String, ResourceData<T>> resources;

    public HTTPRequest(RequestLine line){
        this.requestLine = line;
    }

    public HTTPRequest(RequestLine line, RequestHeader header){
        this.requestLine = line;
        this.header = header;
    }

    public HTTPRequest(RequestLine line, RequestHeader header, RequestBody body){
        this.requestLine = line;
        this.header = header;
        this.body = body;
    }

    public RequestLine getRequestLine() {
        return requestLine;
    }

    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HTTPRequest{" +
                "requestLine=" + requestLine +
                ", header=" + header +
                ", body=" + body +
                '}';
    }
}

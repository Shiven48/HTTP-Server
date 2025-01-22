package Request;

import Common.RequestBody;
import Common.RequestHeader;
import Common.RequestLine;

public class HTTPRequest<T> {

    private RequestLine requestLine;
    private RequestHeader header;
    private RequestBody<T> body;

    // private ConcurrentHashMap<String, ResourceData<T>> resources;

}

package Request;

import Common.RequestBody;
import Common.RequestHeader;
import Common.RequestLine;

import java.util.concurrent.ConcurrentHashMap;

public class HTTPRequestHeader<T> {

    private RequestLine requestLine;
    private RequestHeader header;
    private RequestBody<T> body;

    // private ConcurrentHashMap<String, ResourceData<T>> resources;

}

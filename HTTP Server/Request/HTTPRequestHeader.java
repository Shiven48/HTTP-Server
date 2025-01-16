package Request;

import Builder.BodyBuilderImpl;
import Builder.HeaderBuilderImpl;
import Builder.RequestLineBuilderImpl;

import java.util.concurrent.ConcurrentHashMap;

public class HTTPRequestHeader<T> {

    private RequestLineBuilderImpl requestLine;
    private HeaderBuilderImpl header;
    private BodyBuilderImpl<T> body;

    private ConcurrentHashMap<String, ResourceData<T>> resources;

}

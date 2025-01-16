package Request;

import java.util.concurrent.ConcurrentHashMap;

public class HTTPRequestHeader<T> {

    private ConcurrentHashMap<String, ResourceData<T>> resources;

}

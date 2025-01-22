package Common;

import Request.ResourceData;

import java.util.concurrent.ConcurrentHashMap;

public interface RequestBody<T> {

    public ConcurrentHashMap<String, ResourceData<T>> resources();

}

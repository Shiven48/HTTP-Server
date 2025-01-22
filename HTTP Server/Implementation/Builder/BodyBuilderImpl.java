package Builder;

import Request.ResourceData;

import java.util.concurrent.ConcurrentHashMap;

// This is a temporary implementation for just making a structure
public class BodyBuilderImpl<T> {

    private ResourceData<T> resourceData;
    private String resource;
    private ConcurrentHashMap<String, ResourceData<T>> resources;

    public BodyBuilderImpl(
            String resource,
            ResourceData<T> resourceData
    ){
        resources.put(resource,resourceData);
    }

    private ConcurrentHashMap<String, ResourceData<T>> resources(){
        return null;
    }

}

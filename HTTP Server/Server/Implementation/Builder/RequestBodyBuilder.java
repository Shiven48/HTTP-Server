package Implementation.Builder;

import Common.RequestBody;
import Implementation.RequestBodyImpl;
import Request.ResourceData;

import java.util.concurrent.ConcurrentHashMap;

// This class is having a map of resource path and the actual resource
public class RequestBodyBuilder {

    // This two fields are the path and the data(json)
    private String resourceFileSystemAddress;
    private ResourceData resource;

    // This is the concurrent map for mapping the path and data(json)
    private ConcurrentHashMap<String, ResourceData> resources;

    public RequestBodyBuilder(){
        this.resources = new ConcurrentHashMap<>();
    }

    public RequestBodyBuilder setResources(String resourceFileSystemAddress, ResourceData resource){
        if((!(resourceFileSystemAddress.trim().isEmpty()) && resource != null)){
            this.resources.put(resourceFileSystemAddress, resource);
            return this;
        }
        return this;
    }

    public ConcurrentHashMap<String, ResourceData> getResources(){
        return resources;
    }

    public RequestBody build(){
        return new RequestBodyImpl(this);
    }

}

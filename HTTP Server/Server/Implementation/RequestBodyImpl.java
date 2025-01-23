package Implementation;

import Common.RequestBody;
import Implementation.Builder.RequestBodyBuilder;
import Request.ResourceData;

import java.util.concurrent.ConcurrentHashMap;

public class RequestBodyImpl implements RequestBody {

    private final ConcurrentHashMap<String, ResourceData> resources;

    public RequestBodyImpl(RequestBodyBuilder builder){
        this.resources = builder.getResources();
    }

    @Override
    public ConcurrentHashMap<String, ResourceData> resources() {
        return resources;
    }

    @Override
    public String toString() {
        return "RequestBodyImpl{" +
                "resources=" + resources +
                '}';
    }
}

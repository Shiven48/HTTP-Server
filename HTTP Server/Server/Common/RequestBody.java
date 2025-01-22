package Common;

import Request.ResourceData;

import java.util.concurrent.ConcurrentHashMap;

public interface RequestBody {

    public ConcurrentHashMap<String, ResourceData> resources();

}

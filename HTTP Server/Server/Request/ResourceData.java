package Request;

import java.util.HashMap;
import java.util.Map;

// This part will be provided by user like json data we just need to validate
public class ResourceData{

    private final Map<String,Object> requestData;

    public ResourceData(){
        this.requestData = new HashMap<>();
    }

    public void setRequestData(String key, Object value){
        this.requestData.put(key, value);
    }

    public Map<String,Object> getRequestData(){
        return requestData;
    }

    @Override
    public String toString() {
        return "ResourceData{" +
                "requestData=" + requestData +
                '}';
    }
}

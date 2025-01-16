package Builder;

import Interfaces.RequestLine;
import Interfaces.RequestType;

public class RequestLineBuilderImpl implements RequestLine {

    private Enum<RequestType> requestType;

    private String requestResourcePath;

    private String requestVersion;

    public RequestLineBuilderImpl(
            Enum<RequestType> requestType,
            String requestResourcePath,
            String requestVersion
    ){
        this.requestType = requestType;
        this.requestResourcePath = requestResourcePath;
        this.requestVersion = requestVersion;
    }

    public Enum<RequestType> requestType(){
        return null;
    }


    public String requestResourcePath(){
        return null;
    }

    public String requestVersion(){
        return null;
    }
}

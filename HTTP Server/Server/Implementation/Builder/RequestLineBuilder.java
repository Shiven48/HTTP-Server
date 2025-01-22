package Implementation.Builder;

import Common.RequestLine;
import Common.Enums.RequestType;
import Implementation.RequestLineImpl;

public class RequestLineBuilder {

    private final Enum<RequestType> requestType;
    private final String requestVersion;

    // Optional
    private String requestResourcePath;

    public RequestLineBuilder(
            Enum<RequestType> requestType,
            String requestVersion
    ){
        this.requestType = requestType;
        this.requestVersion =  requestVersion;
    }

    public Enum<RequestType> getRequestType(){
        return requestType;
    }

    public String getRequestVersion(){
        return requestVersion;
    }

    public String getRequestResourcePath(){
        return requestResourcePath;
    }

    public RequestLineBuilder setRequestResourcePath(String requestResourcePath){
        this.requestResourcePath = requestResourcePath;
        return this;
    }

    public RequestLine build() {
        return new RequestLineImpl(this);
    }




}

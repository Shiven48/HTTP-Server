package Implementation;

import Common.RequestLine;
import Common.RequestType;
import Implementation.Builder.RequestLineBuilder;

public class RequestLineImpl implements RequestLine {

    private Enum<RequestType> requestType;

    private String requestResourcePath;

    private String requestVersion;

    public RequestLineImpl(RequestLineBuilder builder){
        this.requestType = builder.getRequestType();
        this.requestResourcePath = builder.getRequestResourcePath();
        this.requestVersion = builder.getRequestVersion();
    }

    @Override
    public Enum<RequestType> requestType() {
        return requestType;
    }

    @Override
    public String requestResourcePath() {
        return requestResourcePath;
    }

    @Override
    public String requestVersion() {
        return requestVersion;
    }
}

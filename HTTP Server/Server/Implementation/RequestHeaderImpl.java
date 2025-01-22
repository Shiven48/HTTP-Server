package Implementation;

import Common.RequestHeader;
import Implementation.Builder.RequestHeaderBuilder;

import java.util.List;

public class RequestHeaderImpl implements RequestHeader {

    private String host;
    private int port;
    private String contentType;
    private List<String> acceptFormats;
    private String userAgent;

    public RequestHeaderImpl(RequestHeaderBuilder builder){
        this.host = builder.getHost();
        this.port = builder.getPort();
        this.contentType = builder.getContentType();
        this.acceptFormats = builder.getAcceptFormats();
        this.userAgent = builder.getUserAgent();
    }

    @Override
    public String host() {
        return host;
    }

    @Override
    public int port() {
        return port;
    }

    @Override
    public String contentType() {
        return contentType;
    }

    @Override
    public List<String> acceptFormats() {
        return acceptFormats;
    }

    @Override
    public String userAgent() {
        return userAgent;
    }
}

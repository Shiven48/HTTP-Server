package Implementation.Builder;

import Common.RequestHeader;
import Implementation.RequestHeaderImpl;

import java.util.List;

public class RequestHeaderBuilder {

    private final String host;
    private final int port;
    private String contentType;
    private List<String> acceptFormats;
    private String userAgent;

    public RequestHeaderBuilder(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public RequestHeaderBuilder setContentType(String contentType){
        this.contentType = contentType;
        return this;
    }

    public RequestHeaderBuilder setAcceptFormats(List<String> acceptFormats){
        this.acceptFormats = acceptFormats;
        return this;
    }

    public RequestHeaderBuilder setUserAgent(String userAgent){
        this.userAgent = userAgent;
        return this;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getContentType() {
        return contentType;
    }

    public List<String> getAcceptFormats() {
        return acceptFormats;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public RequestHeader build(){
     return new RequestHeaderImpl(this);
    }
}

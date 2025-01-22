package Builder;

import Common.RequestHeader;

import java.util.List;

public class HeaderBuilderImpl implements RequestHeader {

    private String host;

    private int port;

    private String contentType;

    private List<String> acceptFormats;

    private String userAgent;

    public HeaderBuilderImpl(
            String host,
            int port,
            String contentType,
            List<String> acceptFormats,
            String userAgent
    ){
        this.host = host;
        this.port = port;
        this.contentType = contentType;
        this.acceptFormats = acceptFormats;
        this.userAgent = userAgent;
    }

    public String host(){
        return null;
    }


    public int port() {
        return 0;
    }

    public String contentType(){
        return null;
    }

    public List<String> acceptFormats(){
        return null;
    }

    public String userAgent(){
        return null;
    }

}

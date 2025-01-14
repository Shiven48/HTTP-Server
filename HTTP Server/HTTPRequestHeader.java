import java.util.List;

public class HTTPRequestHeader {

    private Enum<RequestType> requestType;

    private String requestResource;

    private String requestVersion;

    private String host;

    private int port;

    private String userAgent;

    private List<String> acceptFormats;

    private List<String> acceptLanguage;

    private List<String> acceptEncoding;

    private String connection;

}

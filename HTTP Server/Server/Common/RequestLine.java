package Common;

public interface RequestLine {

    public Enum<RequestType> requestType();

    public String requestResourcePath();

    public String requestVersion();
}

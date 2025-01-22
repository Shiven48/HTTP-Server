package Interfaces;

public interface RequestLine {

    public Enum<RequestType> requestType();

    public String requestResourcePath();

    public String requestVersion();
}

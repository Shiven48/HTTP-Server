package Interfaces;

import java.util.List;

public interface RequestHeader {

    public Enum<RequestType> requestType();

    public String requestResource();

    public String requestVersion();

    public String host();

    public int port();

    public String userAgent();

    public List<String> acceptFormats();

    public List<String> acceptLanguage();

    public List<String> acceptEncoding();

    public String connection();

}

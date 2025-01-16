package Interfaces;

import java.util.List;

public interface Header {

    public String host();

    public int port();

    public String contentType();

    public List<String> acceptFormats();

    public String userAgent();

}

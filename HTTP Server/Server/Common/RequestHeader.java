package Common;

import java.util.List;

public interface RequestHeader {

    public String host();

    public int port();

    public String contentType();

    public List<String> acceptFormats();

    public String userAgent();

}

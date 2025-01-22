package Common;

import Common.Enums.RequestType;

public interface RequestLine {

    public Enum<RequestType> requestType();

    public String requestResourcePath();

    public String requestVersion();
}

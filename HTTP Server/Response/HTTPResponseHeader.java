package Response;

public class HTTPResponseHeader {

    private int statusCode;  // HTTP Status Code (e.g., 200, 404)

    private String statusMessage;  // HTTP Status Message (e.g., "OK", "Not Found")

    private String version;  // HTTP version (e.g., "HTTP/1.1")

    private String contentType;  // The content type of the response (e.g., "text/html", "application/json")

    private long contentLength;  // The length of the response body in bytes

    private String date;  // The date and time when the response was generated

}

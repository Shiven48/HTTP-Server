package Implementation;

import Common.Enums.Formats;
import Common.Enums.RequestType;

import java.util.Arrays;

public class RequestLineHandler {

    public native void initialize();
    public native void insert(String path, String data);
    public native String lookup(String path);

    private RequestType requestType;
    private String format;

    static {
        System.loadLibrary("trie");
    }

    public RequestLineHandler(){}

    // POST /some/path HTTP/1.1
    public void processRequestLine(String RequestLine){
        String[] requestLineComponents = RequestLine.split(" ");
        if(requestLineComponents.length != 3){
            // Error response code Invalid request
        }
        parseFirstComponent(requestLineComponents[0]);
        parseSecondComponent(requestLineComponents[1]);
    }

    private void parseFirstComponent(String component){
        String response = "";
        if(component != null && !component.isEmpty()){
            component = component.trim().toUpperCase();
            switch(component) {
                case "GET":
                    requestType = RequestType.GET;
                    break;
                case "POST":
                    requestType = RequestType.POST;
                    break;
                case "PUT":
                    requestType = RequestType.PUT;
                    break;
                case "DELETE":
                    requestType = RequestType.DELETE;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid request type");
                    // response code for invalid request
            }
        }
    }

    // some/path/sometime.txt
    private void parseSecondComponent(String unProcessedPath){
        StringBuilder processedUrl = new StringBuilder();
        if(unProcessedPath == null){
            // Error response code Invalid request
            return;
        }
        Arrays.stream(unProcessedPath.split("/"))
                .map(url -> {
                    if(url.contains(".")){
                        String[] fileName_and_format = url.split("\\.");
                        if(fileName_and_format.length == 2){
                            String file = fileName_and_format[0].trim().toLowerCase();
                            format = checkFormat(fileName_and_format[1].trim().toLowerCase());
                            System.out.println("File is "+file);
                            System.out.println("Format is "+format);
                            return file;
                        }
                    }
                    return url.trim().toLowerCase();
                })
                .forEach(processedUrl::append);
        System.out.println(new String(processedUrl));
//        handlePostRequest(new String(processedUrl),unProcessedPath);
    }

    private String checkFormat(String url){
         return switch (url) {
            case "txt" -> Formats.TXT.toString().trim().toLowerCase();
            case "json" -> Formats.JSON.toString().trim().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + url);
        };
    }

    private void parseThirdComponent(String component){}

    private void handleGetRequest(){}

    private void handlePostRequest(String processedPath, String unProcessedPath){
        // save using trie
    }

    private void handlePutRequest(){}

    private void handleDeleteRequest(){}

}

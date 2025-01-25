package Implementation;

import Common.Enums.RequestType;
import Common.RequestLine;
import Implementation.Builder.RequestLineBuilder;

public class RequestLineHandler {

    private RequestType requestType;

    public RequestLineHandler(){ }

    // POST /some/path HTTP/1.1
    public void processRequestLine(String RequestLine){
        String[] requestLineComponents = RequestLine.split(" ");
        if(requestLineComponents.length != 3){
            // Error response code
        }
        parseFirstComponent(requestLineComponents[0]);
        parseSecondComponent(requestLineComponents[1]);
    }

    // validation and parsing First Component
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

    // some/path/
    // validation and parsing Second Component
    private void parseSecondComponent(String component){
        // Check in hash map that the key is present
        // If present then parse on '/' character search the resource in tree based on String arr we get
        //
    }

    // validation and parsing Third Component
    private void parseThirdComponent(String component){

    }

    private void handleGetRequest(){}

    private void handlePostRequest(){}

    private void handlePutRequest(){}

    private void handleDeleteRequest(){}

}

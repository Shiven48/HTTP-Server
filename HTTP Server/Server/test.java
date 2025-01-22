import Implementation.Builder.RequestLineBuilder;
import Implementation.RequestLineImpl;
import Common.RequestLine;
import Common.RequestType;

public class test {

    public static void main(String[] args){

        RequestLineBuilder builder = new RequestLineBuilder(RequestType.GET,"HTTP/1.1")
                                    .setRequestResourcePath("api/some/path");

        RequestLine requestLine = new RequestLineImpl(builder);
//        System.out.println(requestLine.requestVersion()+" "+requestLine.requestType()+" "+requestLine.requestResourcePath());
    }
}

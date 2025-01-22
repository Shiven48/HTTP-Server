import Common.RequestHeader;
import Implementation.Builder.RequestHeaderBuilder;
import Implementation.Builder.RequestLineBuilder;
import Implementation.RequestHeaderImpl;
import Implementation.RequestLineImpl;
import Common.RequestLine;
import Common.Enums.RequestType;

import java.util.List;

public class test {

    public static void main(String[] args){

//        RequestLine requestLine = new RequestLineBuilder(RequestType.GET,"HTTP/1.1")
//                                    .setRequestResourcePath("api/some/path")
//                                    .build();
//        System.out.println(requestLine.requestVersion()+" "+requestLine.requestType()+" "+requestLine.requestResourcePath());

//        RequestHeader header = new RequestHeaderBuilder("localhost",8080)
//                .setAcceptFormats(List.of("application/json"))
//                .setContentType("application/json")
//                .setUserAgent("mozilla/firefox")
//                .build();
//        System.out.println(header.contentType()+" "+header.acceptFormats()+" "+header.host()+" "+header.port()+" "+header.userAgent());


    }
}

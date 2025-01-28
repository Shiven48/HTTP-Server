package Common;

public final class HTTPFields {

    private HTTPFields(){
    }

    public static final class HTTPMethods{

        private static final String GET = "GET";

        private static final String POST = "POST";

        private static final String PUT = "PUT";

        private static final String DELETE = "DELETE";

        public HTTPMethods(){

        }
    }

    public static final class Protocol{

        private static final String HTTP_1_0 = "HTTP/1.0";

        private static final String HTTP_1_1 = "HTTP/1.1";

        private static final String HTTP_2_0 = "HTTP/2.0";

        private Protocol(){

        }
    }

    public static final class ContentTypes {

        public static final String ApplicationJson = "application/json";

        public static final String PlainText = "text/plain";
    }

    public static final class Headers{

        public static final String ContentEncoding = "Content-Encoding";

        public static final String ContentLength = "Content-Length";

        public static final String ContentType = "Content-Type";

        public static final String Date = "Date";

        public static final String Host = "Host";

        public static final String UserAgent = "User-Agent";
    }

}

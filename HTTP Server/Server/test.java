public class test {

    public native String sayHello();
        static {
            System.loadLibrary("test");
        }
        public static void main(String[] args){
        test t = new test();
        System.out.println(t.sayHello());
    }
}



public class TrieJNI {

    public native void initialize();  // Initialize the Trie
    public native void insert(String path, String data);
    public native String lookup(String path);

    static {
        // Load the shared library containing the native code
        System.loadLibrary("trie");  // Load 'trie.dll'
    }

    public static void main(String[] args) {
        TrieJNI trie = new TrieJNI();

        // Initialize the Trie before using it
        trie.initialize();

        // Example usage of native methods
        trie.insert("apiuseruserdetailsjson", "/path/to/api/user/userdetails.json");
        String result = trie.lookup("apiuseruserdetailsjson");
        System.out.println("Result from Trie: " + result);
    }
}

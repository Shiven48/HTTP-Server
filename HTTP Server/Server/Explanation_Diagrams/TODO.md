add more parsing current one handles the (/some/path/1 , /some/path/file.txt)
To Handle - /some/path/path?file=file.txt (Query Params)

Make Trie Run

separate the file and the format  - add file to the trie string [insert] 
                                    store format -> My idea is to use interface to handle 
                                    format(someFile.txt = use File class to retrieve file using trie) 
                                    noFormat files(some/path/1 = having mapped data in it think how to store them -> can we use map key 
                                                    will we be path and value will be the file format and that will be saved inside ([This is sus] a common file)


Handling GET request - use trie [lookup] if match and if a file [can I use file format here] return the file using [File class]
                        if the [lookup] is [true but no file] then I can fetch the common file and pass the key to find the data
                        if [lookup] fails then respond with a Response Status illegal path or something
package to.xuan.trie.exceptions;

public class TrieNodeNotALeafException extends Exception {

    public TrieNodeNotALeafException(){
        super();
    }

    public TrieNodeNotALeafException(String message){
        super(message);
    }
}

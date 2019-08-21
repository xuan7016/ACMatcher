package to.xuan.acmatcher.trie;

import to.xuan.trie.exceptions.TrieNodeNotALeafException;

import java.util.*;

public class TrieNode {

    private String c;

    private TrieNode parent;

    private boolean isLeaf = false;

    private Set<String> leafWords = new HashSet<>();

    private Map<String, TrieNode> nodePointers = new HashMap<>();

    TrieNode(String c, TrieNode parent){
        this.parent = parent;
        this.c = c;
    }

    public String getC() {
        return c;
    }

    void setAsLeaf(){
        this.isLeaf = true;
    }

    void addLeafWord(String word) throws TrieNodeNotALeafException{
        if (!isLeaf) throw new TrieNodeNotALeafException("Cannot set leaf words when this node is not a leaf node");
        leafWords.add(word);
    }

    void addNextNode(String c, TrieNode node){
        this.nodePointers.put(c, node);
    }

    boolean isInLeafWords(String word){
        return this.leafWords.contains(word);
    }

    boolean isInChildNode(String c) {return this.nodePointers.containsKey(c);}

    TrieNode getChildByKey(String key) {return this.nodePointers.get(key);}
}

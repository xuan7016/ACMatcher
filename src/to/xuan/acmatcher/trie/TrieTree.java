package to.xuan.acmatcher.trie;


import java.util.Map;
import java.util.Set;

public class TrieTree {

    private int maxWordSizeInTree;

    private Set<String> chars;

    private Map<String, TrieNode> roots;

    public TrieTree(Set<String> chars, Map<String, TrieNode> roots, int maxWordSizeInTree){
        this.chars = chars;
        this.roots = roots;
        this.maxWordSizeInTree = maxWordSizeInTree;
    }

    public int getMaxWordSizeInTree() {
        return maxWordSizeInTree;
    }

    public boolean isCharInTree(String c){
        return chars.contains(c);
    }

    public boolean isCharInRoots(String c){
        return roots.containsKey(c);
    }

    public Map<String, TrieNode> getRoots() {
        return roots;
    }

}
